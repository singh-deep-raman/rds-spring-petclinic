package com.raman.springboot.rdspetclinic.services;

import java.util.Set;

/**
 * This is created to move common methods from service classes into a single interface
 * R--> This is created by taking in mind CrudRepository<T,ID> interface of JPA
 */
public interface CrudService<T,ID> {

    Set<T> findAll();

    T findById(ID id);

    T save(T object);

    void delete(T object);

    void deleteById(ID id);

}
