package com.raman.springboot.rdspetclinic.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * 1. Putting @Entity annotation means a separate table will be created for Owner class which will have columns from Person class too
 * 2. @Table annotation is optional but use it to provide explicit table names
 *      For e.g. hadn't we specified @Table annotation with "owners" name, name of the table would be "owner"
 *
 */
@Entity
@Table(name = "owners")
public class Owner extends Person {

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "telephone")
    private String telephone;

    /**
     * 1. We want to delete Pet if Owner is deleted, so CascadeType.ALL
     * 2. mappedBy means in Pet table we will have FK which is id of 'owner' field in Pet class
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
    private Set<Pet> pets = new HashSet<>(); // to avoid NPE

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }
}
