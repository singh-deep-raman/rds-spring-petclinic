package com.raman.springboot.rdspetclinic.services;

public interface OwnerService<Owner, Long> extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);
}
