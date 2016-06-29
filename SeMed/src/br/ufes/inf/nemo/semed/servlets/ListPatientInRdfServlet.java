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
import br.ufes.inf.nemo.semed.domain.Patient;
import br.ufes.inf.nemo.semed.persistence.PatientDAO;

/**
 * Servlet implementation class ListPatientInRdfServlet
 */

@WebServlet(urlPatterns = { ListPatientInRdfServlet.urlPattern, ListPatientInRdfServlet.urlPattern + "/*" })
public class ListPatientInRdfServlet extends HttpServlet {
	
	public static final String urlPattern = "/data/patientData";
	
	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(ListPatientInRdfServlet.class.getCanonicalName());

	private static final DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

	@EJB
	private PatientDAO patientDAO;

	/**
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest,
	 *      javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(req.getPathInfo()==null) {
			allPatientsRDFResponse(resp);
		} else {
			trySinglePatientRDFResponse(req,resp);
		}
	}
	
	private void trySinglePatientRDFResponse(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String pathInfo = req.getPathInfo();
		logger.log(Level.INFO, "Retrieving URL" + pathInfo);
		long id = -1;
		Patient p = null;
		
		try{
			id = Long.parseUnsignedLong(pathInfo.substring(1));
			p = patientDAO.retrieveById(id);
		} catch (NumberFormatException e) {
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
			return ;
		}
		
		if(p==null){
			resp.sendError(HttpServletResponse.SC_NOT_FOUND);
		} else {
			resp.setContentType("text/xml");
			Model model = ModelFactory.createDefaultModel();
//			String myNS = NSUtils.SEMED_NS;
//			String grNS = NSUtils.GR_NS;
			model.setNsPrefix(NSUtils.SEMED_PREFIX, NSUtils.SEMED_NS);
			model.setNsPrefix(NSUtils.GR_PREFIX, NSUtils.GR_NS);
			addPatientToModel(model, p);
			logger.log(Level.INFO, "Added Doctor/" + p.getId() + " to the RDF model");

			try (PrintWriter out = resp.getWriter()) {
				model.write(out, "RDF/XML");
			}
		}
	}

	private void allPatientsRDFResponse(HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/xml");
		List<Patient> patients = patientDAO.retrieveAll();
		Model model = ModelFactory.createDefaultModel();
		model.setNsPrefix(NSUtils.SEMED_PREFIX, NSUtils.SEMED_NS);
		model.setNsPrefix(NSUtils.GR_PREFIX, NSUtils.GR_NS);

		for (Patient patient : patients) {
			addPatientToModel(model, patient);
		}

		try (PrintWriter out = resp.getWriter()) {
			model.write(out, "RDF/XML");
		}
	}
	
	private void addPatientToModel(Model model, Patient p){
		Property semedFirstName = ResourceFactory.createProperty(NSUtils.SEMED_PROP_FIRST_NAME);
		Property semedSurname = ResourceFactory.createProperty(NSUtils.SEMED_PROP_SURNAME);
		Property semedBirthDate = ResourceFactory.createProperty(NSUtils.SEMED_PROP_BIRTH_DATE);
		Property semedCpf = ResourceFactory.createProperty(NSUtils.SEMED_PROP_CPF);
		Property semedAddress = ResourceFactory.createProperty(NSUtils.SEMED_PROP_ADDRESS);
		Property semedStreet = ResourceFactory.createProperty(NSUtils.SEMED_PROP_STREET);
		Property semedNumber = ResourceFactory.createProperty(NSUtils.SEMED_PROP_NUMBER);
		Property semedCity = ResourceFactory.createProperty(NSUtils.SEMED_PROP_CITY);
		Property semedZipCode = ResourceFactory.createProperty(NSUtils.SEMED_PROP_ZIP_CODE);
		Property semedState = ResourceFactory.createProperty(NSUtils.SEMED_PROP_STATE);
		
		model.createResource("http://www.semed.com/SeMed"+urlPattern+"/"+p.getId())
				.addProperty(RDF.type, NSUtils.SEMED_PATIENT)
				.addProperty(semedFirstName,p.getFirstName())
				.addProperty(semedSurname, p.getSurname())
				.addProperty(semedBirthDate, ResourceFactory.createTypedLiteral(df.format(p.getBirthDate()), XSDDatatype.XSDdateTime))
				.addProperty(semedCpf,p.getCpf())
				.addProperty(semedAddress, model.createResource()
						.addProperty(RDF.type, NSUtils.SEMED_ADDRESS)
						.addProperty(semedStreet,p.getAddress().getStreet())
						.addProperty(semedNumber,p.getAddress().getNumber()+"")
						.addProperty(semedCity,p.getAddress().getCity())
						.addProperty(semedZipCode,p.getAddress().getZipCode())
						.addProperty(semedState,p.getAddress().getState()));
	}

}