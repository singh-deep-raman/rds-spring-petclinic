package com.raman.springboot.rdspetclinic.bootstrap;

import com.raman.springboot.rdspetclinic.model.Owner;
import com.raman.springboot.rdspetclinic.model.Vet;
import com.raman.springboot.rdspetclinic.services.OwnerService;
import com.raman.springboot.rdspetclinic.services.PetService;
import com.raman.springboot.rdspetclinic.services.VetService;
import com.raman.springboot.rdspetclinic.services.map.OwnerServiceMap;
import com.raman.springboot.rdspetclinic.services.map.PetServiceMap;
import com.raman.springboot.rdspetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    /** earlier new operator was used, now we are using DI, because these services are Spring Managed Beans now
     *  due to @Service annotation */
    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner = new Owner();
        owner.setId(1L);
        owner.setFirstName("Michael");
        owner.setLastName("Scofield");

        ownerService.save(owner);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Lincoln");
        owner2.setLastName("Burrows");

        ownerService.save(owner2);

        System.out.println("Loaded Owners");

        Vet vet = new Vet();
        vet.setId(1L);
        vet.setFirstName("Sarah");
        vet.setLastName("Gordon");

        vetService.save(vet);

        Vet vet1 = new Vet();
        vet1.setId(2L);
        vet1.setFirstName("Abc");
        vet1.setLastName("Def");

        vetService.save(vet1);

        System.out.println("Loaded vets");
    }
}
