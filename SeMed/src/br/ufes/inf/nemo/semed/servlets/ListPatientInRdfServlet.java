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

import br.ufes.inf.nemo.semed.domain.Patient;
import br.ufes.inf.nemo.semed.persistence.PatientDAO;

/**
 * Servlet implementation class ListPatientInRdfServlet
 */

@WebServlet(urlPatterns = { "/data/patientData" })
public class ListPatientInRdfServlet extends HttpServlet {
	/**
	 * 
	 */
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
		resp.setContentType("text/xml");

		List<Patient> patients = patientDAO.retrieveAll();

		Model model = ModelFactory.createDefaultModel();
		String myNS = "http://localhost:8080/SeMed/data/patientData/";
		String grNS = "http://purl.org/goodrelations/v1#";
		model.setNsPrefix("gr", grNS);
		Resource grFullName = ResourceFactory.createResource(grNS + "FullName");
		Property grCpf = ResourceFactory.createProperty(grNS + "Cpf");
		Property grBirthDate = ResourceFactory.createProperty(grNS + "BirthDate");

		for (Patient patient : patients) {
			model.createResource(myNS + patient.getId()).addProperty(RDF.type, grFullName)
					.addProperty(RDFS.label, patient.getFullName()).addProperty(RDFS.comment, patient.getSurname())
					.addLiteral(grBirthDate,
							ResourceFactory.createTypedLiteral(df.format(patient.getBirthDate()),
									XSDDatatype.XSDdateTime))
					.addProperty(grCpf, model.createResource().addProperty(RDF.type, grCpf).addLiteral(grCpf,
							patient.getCpf().toString()));

			logger.log(Level.INFO, "Added TourPackage/" + patient.getId() + " to the RDF model");
		}

		try (PrintWriter out = resp.getWriter()) {
			model.write(out, "RDF/XML");
		}
	}

}