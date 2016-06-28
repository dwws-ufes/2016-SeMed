package br.ufes.inf.nemo.semed.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.ResourceFactory;
import com.hp.hpl.jena.vocabulary.OWL2;
import com.hp.hpl.jena.vocabulary.RDF;

import br.ufes.inf.nemo.semed.domain.Disease;
import br.ufes.inf.nemo.semed.persistence.DiseaseDAO;

@WebServlet(urlPatterns = { ListDiseaseInRdfServlet.urlPattern, ListDiseaseInRdfServlet.urlPattern + "/*" })
public class ListDiseaseInRdfServlet extends HttpServlet {

	public static final String urlPattern = "/data/diseaseData";
	
	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(ListDoctorInRdfServlet.class.getCanonicalName());

	private static final DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

	@EJB
	private DiseaseDAO diseaseDAO;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getPathInfo()==null) {
			allDiseasesRDFResponse(resp);
		} else {
			trySingleDiseaseRDFResponse(req,resp);
		}
	}

	private void trySingleDiseaseRDFResponse(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String pathInfo = req.getPathInfo();
		logger.log(Level.INFO, "Retrieving URL" + pathInfo);
		long id = -1;
		Disease d = null;
		
		try{
			id = Long.parseUnsignedLong(pathInfo.substring(1));
			d = diseaseDAO.retrieveById(id);
		} catch (NumberFormatException e) {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
			return ;
		}
		
		if(d==null){
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
		} else {
			resp.setContentType("text/xml");
			Model model = ModelFactory.createDefaultModel();
//			String myNS = NSUtils.SEMED_NS;
//			String grNS = NSUtils.GR_NS;
			model.setNsPrefix(NSUtils.SEMED_PREFIX, NSUtils.SEMED_NS);
			model.setNsPrefix(NSUtils.GR_PREFIX, NSUtils.GR_NS);
			addDiseaseToModel(model, d);
			logger.log(Level.INFO, "Added Doctor/" + d.getId() + " to the RDF model");

			try (PrintWriter out = resp.getWriter()) {
				model.write(out, "RDF/XML");
			}
		}
	}

	private void allDiseasesRDFResponse(HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/xml");
		List<Disease> diseases = diseaseDAO.retrieveAll();
		Model model = ModelFactory.createDefaultModel();
		model.setNsPrefix(NSUtils.SEMED_PREFIX, NSUtils.SEMED_NS);
		model.setNsPrefix(NSUtils.GR_PREFIX, NSUtils.GR_NS);

		for (Disease d : diseases) {
			addDiseaseToModel(model, d);
		}

		try (PrintWriter out = resp.getWriter()) {
			model.write(out, "RDF/XML");
		}
	}
	
	private void addDiseaseToModel(Model model, Disease d){
		Property semedName = ResourceFactory.createProperty(NSUtils.SEMED_PROP_DISEASE_NAME);
		Property semedReferenceResource = ResourceFactory.createProperty(NSUtils.SEMED_PROP_DISEASE_SOURCE);
		
		model.createResource("http://www.semed.com/SeMed"+urlPattern+"/"+d.getId())
				.addProperty(RDF.type, NSUtils.SEMED_DISEASE)
				.addProperty(semedName, d.getName())
				.addProperty(semedReferenceResource, d.getReferenceResource())
				.addProperty(OWL2.sameAs, d.getReferenceResource());
	}
	
}
