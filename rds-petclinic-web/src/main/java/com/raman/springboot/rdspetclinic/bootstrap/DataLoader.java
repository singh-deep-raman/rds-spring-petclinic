package com.raman.springboot.rdspetclinic.bootstrap;

import com.raman.springboot.rdspetclinic.model.Owner;
import com.raman.springboot.rdspetclinic.model.PetType;
import com.raman.springboot.rdspetclinic.model.Vet;
import com.raman.springboot.rdspetclinic.services.OwnerService;
import com.raman.springboot.rdspetclinic.services.PetTypeService;
import com.raman.springboot.rdspetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    /** earlier new operator was used, now we are using DI, because these services are Spring Managed Beans now
     *  due to @Service annotation */
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        /** no need to set Ids, because we have given that responsibility to Service/Dao class */
        Owner owner = new Owner();
        owner.setFirstName("Michael");
        owner.setLastName("Scofield");

        ownerService.save(owner);

        Owner owner2 = new Owner();
        owner2.setFirstName("Lincoln");
        owner2.setLastName("Burrows");

        ownerService.save(owner2);

        System.out.println("Loaded Owners");

        Vet vet = new Vet();
        vet.setFirstName("Sarah");
        vet.setLastName("Gordon");

        vetService.save(vet);

        Vet vet1 = new Vet();
        vet1.setFirstName("Abc");
        vet1.setLastName("Def");

        vetService.save(vet1);

        System.out.println("Loaded vets");
    }
}
