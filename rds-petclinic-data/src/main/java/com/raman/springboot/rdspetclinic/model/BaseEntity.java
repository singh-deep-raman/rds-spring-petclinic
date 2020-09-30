package com.raman.springboot.rdspetclinic.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * This will be the parent of each entity we are going to persist in DB
 * That's why it has only id field
 * We are also implementing Serializable interface which is a good thing
 */
@MappedSuperclass
public class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
/**
 * Notes
 *      # A mapped superclass provides persistent entity state and mapping information but is not itself an entity.
 *      # A mapped superclass, unlike an entity, does not allow querying, persisting, or relationships to the superclass.
 *      # @MappedSuperclass annotation is used to designate a class as mapped superclass.
 *      # All mappings annotation can be used on the root class except for @Entity.
 *      # Also persistent relationships defined by a mapped superclass must be unidirectional.
 *      # Mapping information may be overridden in the subclasses by using the @AttributeOverride and @AssociationOverride annotations.
 *      # Both abstract and concrete classes may be specified as mapped superclasses.
 *      # It is similar to table per class inheritance but no table joins or inheritance exists in data model.
 *      # There's no table for the mapped superclass. Inheritance only exists in object model.
 *      # The main disadvantage of using mapped superclass is that we cannot load all entities (subclasses) represented by the mapped superclass,
 *         i.e., polymorphic queries are not possible.
  */
