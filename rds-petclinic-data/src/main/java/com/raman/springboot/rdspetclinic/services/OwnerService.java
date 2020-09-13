package com.raman.springboot.rdspetclinic.services;

import com.raman.springboot.rdspetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerService extends CrudRepository<Owner, Long> {

    Owner findByLastName(String lastName);
}
