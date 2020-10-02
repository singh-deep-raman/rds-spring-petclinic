package com.raman.springboot.rdspetclinic.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * # We are mapping Person class with @MappedSuperclass annotation so that JPA doesn't create table for Person class
 * # But any Entity class extending from Person will have firstName and lastName columns in their respective tables
 */
@MappedSuperclass
public class Person extends BaseEntity{

    /**
     * Use @Column annotation to specify column name explicitly and other things you wish
     */
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
