package com.raman.springboot.rdspetclinic.model;

import java.io.Serializable;

/**
 * This will be the parent of each entity we are going to persist in DB
 * That's why it has only id field
 * We are also implementing Serializable interface which is a good thing
 */
public class BaseEntity implements Serializable {

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
