package com.raman.springboot.rdspetclinic.repositories;

import com.raman.springboot.rdspetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

/**
 * R--> You can extend PagingAndSortingRepository which also implements CrudRepository to use some more methods
 * R--> You can also extend JpaRepository which extends PagingAndSortingRepository interface, to use some more functionality
 *
 * Our example is tied to just basic CRUD operations so CrudRepository will do the trick
 */
public interface OwnerRepository extends CrudRepository<Owner, Long> {

    /**
     * We are adding this method because it is based on lastname which is not part of ID
     * JPA will implement this method at runtime
     */
    Owner findByLastName(String lastName);
}
