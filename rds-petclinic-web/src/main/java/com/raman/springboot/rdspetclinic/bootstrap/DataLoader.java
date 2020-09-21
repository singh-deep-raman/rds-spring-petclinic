package com.raman.springboot.rdspetclinic.bootstrap;

import com.raman.springboot.rdspetclinic.model.Owner;
import com.raman.springboot.rdspetclinic.model.Pet;
import com.raman.springboot.rdspetclinic.model.PetType;
import com.raman.springboot.rdspetclinic.model.Vet;
import com.raman.springboot.rdspetclinic.services.OwnerService;
import com.raman.springboot.rdspetclinic.services.PetTypeService;
import com.raman.springboot.rdspetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

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

        /** save some type of pets petclinic treats like dog, cat, etc */
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
        owner.setAddress("Sec 51");
        owner.setCity("Gurugram");
        owner.setTelephone("9888872022");
        /** create pet for michael owner */
        Pet michaelsPet = new Pet();
        michaelsPet.setName("messi");
        michaelsPet.setPetType(savedDogPetType);
        michaelsPet.setBirthDate(LocalDate.of(2000,11,30));
        michaelsPet.setOwner(owner);
        owner.getPets().add(michaelsPet);

        ownerService.save(owner);

        Owner owner2 = new Owner();
        owner2.setFirstName("Lincoln");
        owner2.setLastName("Burrows");
        owner2.setAddress("M. Vihar");
        owner2.setCity("Ludhiana");
        owner2.setTelephone("9582263997");
        /** create pet for lincoln */
        Pet lincolnPet = new Pet();
        lincolnPet.setName("orion");
        lincolnPet.setPetType(savedCatPetType);
        lincolnPet.setBirthDate(LocalDate.of(2000,11,30));
        lincolnPet.setOwner(owner2);
        owner.getPets().add(lincolnPet);

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
