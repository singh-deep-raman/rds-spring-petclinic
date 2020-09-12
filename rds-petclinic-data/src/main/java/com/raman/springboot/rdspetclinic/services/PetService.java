package com.raman.springboot.rdspetclinic.services;

import com.raman.springboot.rdspetclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
