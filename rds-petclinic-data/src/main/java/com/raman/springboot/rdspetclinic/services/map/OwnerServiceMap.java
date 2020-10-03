package com.raman.springboot.rdspetclinic.services.map;

import com.raman.springboot.rdspetclinic.model.Owner;
import com.raman.springboot.rdspetclinic.model.Pet;
import com.raman.springboot.rdspetclinic.services.OwnerService;
import com.raman.springboot.rdspetclinic.services.PetService;
import com.raman.springboot.rdspetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Profile({"default", "map"}) // default means when no profile is active, this profile is default to be used
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {


    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Owner findByLastName(String lastName) {
        List<Owner> collect = super.map.values().stream().filter(owner -> owner.getLastName().equals(lastName)).collect(Collectors.toList());
        if (collect == null || collect.size() == 0)
            return null;
        else
            return collect.get(0);
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {
        /** return null if object to be saved is null */
        if (object == null)
            return null;

        /** We want something like JPA. Like while saving Owner which has Pet, we should make sure Pet is also saved
         *  in DB and has some id associated to it. */
        if (object.getPets() != null) {
            object.getPets().forEach(pet -> {

                if (pet.getPetType() == null)
                    throw new RuntimeException("Pet Type is required");

                // we want to store only if it is not in db, means it has no id
                if (pet.getId() == null) {
                    pet.setPetType(petTypeService.save(pet.getPetType()));
                }

                /** save pet */
                if (pet.getId() == null) {
                    /** means pet is not saved */
                    Pet savedPet = petService.save(pet);
                    pet.setId(savedPet.getId());
                }
            });
        }

        /** then save owner and return saved owner */
        return super.save(object);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
