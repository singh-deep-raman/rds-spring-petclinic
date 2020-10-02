package com.raman.springboot.rdspetclinic.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pets")
public class Pet extends BaseEntity{

    @Column(name = "name")
    private String name;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    /**
     * 1. Many pets can belong to one pet type, so @ManyToOne
     * 2. 'pet_type_id' is a column in 'pets' table which will have id value of pet_type table as FK mapping
     */
    @ManyToOne
    @JoinColumn(name = "pet_type_id")
    private PetType petType;

    /**
     * 1. @ManyToOne because many pets can belong to one owner
     * 2. @JoinColumn means inside "pets" table we will have a column 'owner_id' for FK
     */
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    /**
     * 1. @OneToMany because one pet can have many visits
     * 2. CasacdeType.ALL because if pet is deleted, there is no point keeping it's visits in DB
     * 3. mappedBy = 'pet' means mapping is specified in Pet entity on 'pet' property
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
    private Set<Visit> visits = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
