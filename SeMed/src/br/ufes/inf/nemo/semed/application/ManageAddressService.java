package br.ufes.inf.nemo.semed.application;

import javax.ejb.Local;

import br.ufes.inf.nemo.semed.model.Address;
import br.ufes.inf.nemo.util.ejb3.application.CrudService;

@Local
public interface ManageAddressService extends CrudService<Address> {

}
