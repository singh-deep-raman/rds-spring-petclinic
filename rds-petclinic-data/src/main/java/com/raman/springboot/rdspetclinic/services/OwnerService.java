package com.raman.springboot.rdspetclinic.services;

import com.raman.springboot.rdspetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}
