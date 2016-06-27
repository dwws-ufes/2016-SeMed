package br.ufes.inf.nemo.semed.controller;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.RDFNode;

import br.ufes.inf.nemo.semed.application.ManageDiseasesService;
import br.ufes.inf.nemo.semed.domain.Disease;
import br.ufes.inf.nemo.util.ejb3.application.CrudService;
import br.ufes.inf.nemo.util.ejb3.controller.CrudController;

@Named @SessionScoped
public class ManageDiseasesController extends CrudController<Disease> {

	private static final long serialVersionUID = 1L;

	@EJB private ManageDiseasesService manageDiseasesService;
	
	public ManageDiseasesController() {
		viewPath = "/manageDiseases/";
		bundleName = "msgs";
	}
	
	@Override
	protected CrudService<Disease> getCrudService() {
		return manageDiseasesService;
	}

	@Override
	protected Disease createNewEntity() {
		return new Disease();
	}

	@Override
	protected void initFilters() {}
	
	public void importDiseases(){
		ResultSet diseases = queryDiseases();
		while(diseases.hasNext()){
			QuerySolution querySolution = diseases.next();
			RDFNode uri = querySolution.get("x");
			Literal label = querySolution.getLiteral("label");
			try {
				Disease d = createNewEntity();
				d.setName(label.getValue().toString());
				d.setReferenceResource(uri.toString());
				setSelectedEntity(d);
				save();
			} catch (Exception e) {}
		}
	}
	
	private ResultSet queryDiseases(){
		String query =
				"PREFIX drugbank_vocabulary: <http://bio2rdf.org/drugbank_vocabulary:> "
				+ "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
				// + "PREFIX ns47: <http://bio2rdf.org/ctd_vocabulary:> "
				+ "PREFIX ns54: <http://bio2rdf.org/pharmgkb_vocabulary:> "
				+ "SELECT DISTINCT ?x ?label "
				+ "WHERE { "
					+ "{ SELECT * WHERE { ?x a ns54:Disease } LIMIT 100 } . "
					+ "?x rdfs:label ?label . "
				+ "}";
		QueryExecution queryExecution = QueryExecutionFactory.sparqlService("http://bio2rdf.org/sparql", query);
		return queryExecution.execSelect();
	}

}
