package br.ufes.inf.nemo.semed.controller;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.ufes.inf.nemo.semed.application.ManageSemestersService;
import br.ufes.inf.nemo.semed.domain.Semester;
import br.ufes.inf.nemo.util.ejb3.application.CrudService;
import br.ufes.inf.nemo.util.ejb3.application.filters.SimpleFilter;
import br.ufes.inf.nemo.util.ejb3.controller.CrudController;

@Named @SessionScoped
public class ManageSemestersController extends CrudController<Semester> {

	@EJB private ManageSemestersService manageSemestersService;
	
	public ManageSemestersController() {
		viewPath = "/manageSemesters/";
		bundleName = "msgs";
	}
	
	@Override
	protected CrudService<Semester> getCrudService() {
		return manageSemestersService;
	}

	@Override
	protected Semester createNewEntity() {
		return new Semester();
	}

	@Override
	protected void initFilters() {
		addFilter(new SimpleFilter("manageSemesters.filter.byYear", "year",
				getI18nMessage("msgs", "manageSemesters.text.filter.byYear")));
	}

}
