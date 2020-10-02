package com.raman.springboot.rdspetclinic.repositories;

import com.raman.springboot.rdspetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

/**
 * R--> You can extend PagingAndSortingRepository which also implements CrudRepository to use some more methods
 * R--> You can also extend JpaRepository which extends PagingAndSortingRepository interface, to use some more functionality
 *
 * Our example is tied to just basic CRUD operations so CrudRepository will do the trick
 */
public interface PetRepository extends CrudRepository<Pet, Long> {
}
