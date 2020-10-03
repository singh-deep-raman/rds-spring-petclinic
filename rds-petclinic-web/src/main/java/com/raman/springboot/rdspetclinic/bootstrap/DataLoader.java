package com.raman.springboot.rdspetclinic.bootstrap;

import com.raman.springboot.rdspetclinic.model.*;
import com.raman.springboot.rdspetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    /** earlier new operator was used, now we are using DI, because these services are Spring Managed Beans now
     *  due to @Service annotation */
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        loadData();
    }

    private void loadData() {
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

        Owner savedOwner1 = ownerService.save(owner);

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
        owner2.getPets().add(lincolnPet); // wrote owner instead of owner2, evils of copy pasting, id was coming null for pet, because mapping was incorrect

        Owner savedOwner2 = ownerService.save(owner2);

        System.out.println("Loaded Owners");

        /** creating specialities of vets */
        Speciality radiology = new Speciality();
        radiology.setDescription("radiology");

        Speciality surgery = new Speciality();
        surgery.setDescription("surgery");

        Speciality dentistry = new Speciality();
        dentistry.setDescription("dentistry");

        /** saving and getting objects so that we have Ids */
        Speciality savedRadiology = specialityService.save(radiology);
        Speciality savedSurgery = specialityService.save(surgery);
        Speciality savedDentistry = specialityService.save(dentistry);

        /** below code creates vets */
        Vet vet = new Vet();
        vet.setFirstName("Sarah");
        vet.setLastName("Gordon");
        vet.getSpecialities().add(dentistry);
        vet.getSpecialities().add(radiology);

        vetService.save(vet);

        Vet vet1 = new Vet();
        vet1.setFirstName("Abc");
        vet1.setLastName("Def");
        vet1.getSpecialities().add(surgery);
        vetService.save(vet1);

        System.out.println("Loaded vets");

        /** Create visits */
        Visit visit = new Visit();
        visit.setDate(LocalDate.now());
        visit.setDescription("Dog is ill");
        visit.setPet(savedOwner1.getPets().iterator().next()); // we need savedOwner because saved owner's pet has ids, and we have added validation

        visitService.save(visit);

        Visit visit2 = new Visit();
        visit2.setDate(LocalDate.now());
        visit2.setDescription("Cat is ill");
        visit2.setPet(savedOwner2.getPets().iterator().next());

        visitService.save(visit2);
        System.out.println("Visits loaded !!!");
    }
}
