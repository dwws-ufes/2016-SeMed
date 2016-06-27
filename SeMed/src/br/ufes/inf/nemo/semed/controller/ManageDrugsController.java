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

import br.ufes.inf.nemo.semed.application.ManageDrugsService;
import br.ufes.inf.nemo.semed.domain.Disease;
import br.ufes.inf.nemo.semed.domain.Drug;
import br.ufes.inf.nemo.util.ejb3.application.CrudService;
import br.ufes.inf.nemo.util.ejb3.controller.CrudController;

@Named @SessionScoped
public class ManageDrugsController extends CrudController<Drug> {

	private static final long serialVersionUID = 1L;

	@EJB private ManageDrugsService manageDrugsService;
	
	public ManageDrugsController() {
		viewPath = "/manageDrugs/";
		bundleName = "msgs";
	}
	
	@Override
	protected CrudService<Drug> getCrudService() {
		return manageDrugsService;
	}

	@Override
	protected Drug createNewEntity() {
		return new Drug();
	}

	@Override
	protected void initFilters() {}

	public void importDrugs(){
		ResultSet drugs = queryDrugs();
		while(drugs.hasNext()){
			QuerySolution querySolution = drugs.next();
			RDFNode uri = querySolution.get("x");
			Literal label = querySolution.getLiteral("label");
			try {
				Drug d = createNewEntity();
				d.setName(label.getValue().toString());
				d.setReferenceResource(uri.toString());
				setSelectedEntity(d);
				save();
			} catch (Exception e) {}
		}
	}
	
	private ResultSet queryDrugs(){
		String query = 
				"PREFIX drugbank_vocabulary: <http://bio2rdf.org/drugbank_vocabulary:> "
				+ "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#> "
				+ "SELECT *  "
				+ "WHERE { "
					+ "?x a drugbank_vocabulary:Drug "
					+ "; rdfs:label ?label } "
				+ "LIMIT 100";
		QueryExecution queryExecution = QueryExecutionFactory.sparqlService("http://bio2rdf.org/sparql", query);
		return queryExecution.execSelect();
	}
	
}
