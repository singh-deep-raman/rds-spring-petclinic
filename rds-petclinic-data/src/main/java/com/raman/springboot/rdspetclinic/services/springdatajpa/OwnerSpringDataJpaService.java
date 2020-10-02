package com.raman.springboot.rdspetclinic.services.springdatajpa;

import com.raman.springboot.rdspetclinic.model.Owner;
import com.raman.springboot.rdspetclinic.repositories.OwnerRepository;
import com.raman.springboot.rdspetclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * This implementation of OwnerService fetches data from JPA.
 * We have another implementation of OwnerService which fetches data from Map we created.
 * We will leverage the profiles feature of Spring to provide which implementation to use at runtime for Service
 *
 * R--> right now we haven't specified any profile in application.properties file, so this class is being ingored because "springdatajpa" is not active profile
 */
@Service
@Profile("springdatajpa")
public class OwnerSpringDataJpaService implements OwnerService {

    private final OwnerRepository ownerRepository;

    public OwnerSpringDataJpaService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> ownerSet = new HashSet<>();
        ownerRepository.findAll().forEach(ownerSet::add);
        return ownerSet;
    }

    @Override
    public Owner findById(Long id) {
        Optional<Owner> ownerOptional = ownerRepository.findById(id);
        /*if (ownerOptional.isPresent()) {
            return ownerOptional.get();
        } else {
            return null;
        }*/
        // it is equivalent of above code
        return ownerOptional.orElse(null);
    }

    @Override
    public Owner save(Owner object) {
        return ownerRepository.save(object);
    }

    @Override
    public void delete(Owner object) {
        ownerRepository.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        ownerRepository.deleteById(id);
    }
}
