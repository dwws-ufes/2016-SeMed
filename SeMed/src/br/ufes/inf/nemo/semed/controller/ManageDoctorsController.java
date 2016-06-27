package br.ufes.inf.nemo.semed.controller;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.Literal;

import br.ufes.inf.nemo.semed.application.ManageDoctorsService;
import br.ufes.inf.nemo.semed.domain.Address;
import br.ufes.inf.nemo.semed.domain.Doctor;
import br.ufes.inf.nemo.util.ejb3.application.CrudService;
import br.ufes.inf.nemo.util.ejb3.application.filters.SimpleFilter;
import br.ufes.inf.nemo.util.ejb3.controller.CrudController;

@Named
@SessionScoped
public class ManageDoctorsController extends CrudController<Doctor> {

	private static final long serialVersionUID = 1L;

	@EJB
	private ManageDoctorsService manageDoctorsService;

	public ManageDoctorsController() {
		viewPath = "/manageDoctors/";
		bundleName = "msgs";
	}

	@Override
	protected CrudService<Doctor> getCrudService() {
		return manageDoctorsService;
	}

	@Override
	protected Doctor createNewEntity() {
		Doctor d = new Doctor();
		d.setAddress(new Address());
		return d;
	}

	@Override
	protected void initFilters() {
		addFilter(new SimpleFilter("manageDoctors.filter.byFirstName", "firstName",
				getI18nMessage("msgs", "manageDoctors.text.filter.byFirstName")));
		addFilter(new SimpleFilter("manageDoctors.filter.byCity", "address.city",
				getI18nMessage("msgs", "manageDoctors.text.filter.byCity")));
		addFilter(new SimpleFilter("manageDoctors.filter.byProfessionalId", "professionalId",
				getI18nMessage("msgs", "manageDoctors.text.filter.byProfessionalId")));

	}

	public void suggestDescription() {

		if (this.selectedEntity.getAddress() == null) {
			System.out.println("Endereco nulo");
		} else {
			String name = this.selectedEntity.getAddress().getCity();
			if (name != null && name.length() > 3) {
				String query = "PREFIX dbpedia-owl: <http://dbpedia.org/ontology/> "
						+ "PREFIX dbpprop: <http://dbpedia.org/property/> " + "SELECT ?desc " + "WHERE { "
						+ "?x a dbpedia-owl:Place ; " + "dbpprop:name ?name ; " + "dbpedia-owl:abstract ?desc . "
						+ "FILTER (lcase(str(?name)) = \"" + name.toLowerCase() + "\") "
						+ "FILTER (langMatches(lang(?desc), \"EN\")) " + "}";
				QueryExecution queryExecution = QueryExecutionFactory.sparqlService("http://dbpedia.org/sparql", query);
				ResultSet results = queryExecution.execSelect();
				if (results.hasNext()) {
					QuerySolution querySolution = results.next();
					Literal literal = querySolution.getLiteral("desc");
					this.selectedEntity.getAddress().setDescription("" + literal.getValue());
				}
			}
		}
	}

}
