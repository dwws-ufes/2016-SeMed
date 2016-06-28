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

import com.hp.hpl.jena.datatypes.xsd.XSDDatatype;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.ResourceFactory;
import com.hp.hpl.jena.vocabulary.RDF;
import com.hp.hpl.jena.vocabulary.RDFS;

import br.ufes.inf.nemo.semed.domain.Doctor;
import br.ufes.inf.nemo.semed.persistence.DoctorDAO;

/**
 * Servlet implementation class ListDoctorInRdfServlet
 */

@WebServlet(urlPatterns = { ListDoctorInRdfServlet.urlPattern, ListDoctorInRdfServlet.urlPattern + "/*" })
public class ListDoctorInRdfServlet extends HttpServlet {

	public static final String urlPattern = "/data/doctorData";
	
	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(ListDoctorInRdfServlet.class.getCanonicalName());

	private static final DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

	@EJB
	private DoctorDAO doctorDAO;

	/**
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getPathInfo()==null) {
			allDoctorRDFResponse(resp);
		} else {
			trySingleDoctorRDFResponse(req,resp);
		}
	}

	private void trySingleDoctorRDFResponse(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String pathInfo = req.getPathInfo();
		logger.log(Level.INFO, "Retrieving URL" + pathInfo);
		long id = -1;
		Doctor d = null;
		
		try{
			id = Long.parseUnsignedLong(pathInfo.substring(1));
			d = doctorDAO.retrieveById(id);
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
			addDoctorToModel(model, d);
			logger.log(Level.INFO, "Added Doctor/" + d.getId() + " to the RDF model");

			try (PrintWriter out = resp.getWriter()) {
				model.write(out, "RDF/XML");
			}
		}
	}

	private void allDoctorRDFResponse(HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/xml");
		List<Doctor> doctors = doctorDAO.retrieveAll();
		Model model = ModelFactory.createDefaultModel();
		model.setNsPrefix(NSUtils.SEMED_PREFIX, NSUtils.SEMED_NS);
		model.setNsPrefix(NSUtils.GR_PREFIX, NSUtils.GR_NS);

		for (Doctor doctor : doctors) {
			addDoctorToModel(model, doctor);
		}

		try (PrintWriter out = resp.getWriter()) {
			model.write(out, "RDF/XML");
		}
	}
	
	private void addDoctorToModel(Model model, Doctor d){
		Property semedFirstName = ResourceFactory.createProperty(NSUtils.SEMED_PROP_FIRST_NAME);
		Property semedSurname = ResourceFactory.createProperty(NSUtils.SEMED_PROP_SURNAME);
		Property semedBirthDate = ResourceFactory.createProperty(NSUtils.SEMED_PROP_BIRTH_DATE);
		Property semedCpf = ResourceFactory.createProperty(NSUtils.SEMED_PROP_CPF);
		Property semedProfessionalId = ResourceFactory.createProperty(NSUtils.SEMED_PROP_PROFESSIONAL_ID);
		Property semedStreet = ResourceFactory.createProperty(NSUtils.SEMED_PROP_STREET);
		Property semedNumber = ResourceFactory.createProperty(NSUtils.SEMED_PROP_NUMBER);
		Property semedCity = ResourceFactory.createProperty(NSUtils.SEMED_PROP_CITY);
		Property semedZipCode = ResourceFactory.createProperty(NSUtils.SEMED_PROP_ZIP_CODE);
		Property semedState = ResourceFactory.createProperty(NSUtils.SEMED_PROP_STATE);
		
		model.createResource("http://www.semed.com/SeMed"+urlPattern+"/"+d.getId())
				.addProperty(RDF.type, NSUtils.SEMED_DOCTOR)
				.addProperty(semedFirstName,d.getFirstName())
				.addProperty(semedSurname, d.getSurname())
				.addProperty(semedBirthDate, ResourceFactory.createTypedLiteral(df.format(d.getBirthDate()), XSDDatatype.XSDdateTime))
				.addProperty(semedCpf,d.getCpf())
				.addProperty(semedProfessionalId,d.getProfessionalId())
				.addProperty(semedStreet,d.getAddress().getStreet())
				.addProperty(semedNumber,d.getAddress().getNumber()+"")
				.addProperty(semedCity,d.getAddress().getCity())
				.addProperty(semedZipCode,d.getAddress().getZipCode())
				.addProperty(semedState,d.getAddress().getState());
	}

}