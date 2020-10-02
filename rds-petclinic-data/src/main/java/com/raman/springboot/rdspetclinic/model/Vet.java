package com.raman.springboot.rdspetclinic.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "vets")
public class Vet extends Person {

    /**
     * 1. One Vet can have many specialities
     * 2. One speciality can belong to many vets
     * 3. From 1) & 2) we conclude that relationship will be @ManyToMany
     * 4. By default fetch type is LAZY for @ManyToMany, we want it EAGER so that it loads everything at once
     * 5. R--> Whenever @ManyToMany relationship is there, it is must to have join table
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "vet_specialities",
            joinColumns = @JoinColumn(name = "vet_id"),
            inverseJoinColumns = @JoinColumn(name = "speciality_id"))
    private Set<Speciality> specialities = new HashSet<>(); // to avoid NPE

    public Set<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Set<Speciality> specialities) {
        this.specialities = specialities;
    }
}
