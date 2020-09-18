package com.raman.springboot.rdspetclinic.services.map;

import com.raman.springboot.rdspetclinic.model.BaseEntity;

import java.util.*;

/**
 * This class will have implementation of common methods of all services
 */
public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    /** As it is map based, we will get and set data from map, which is our data source */
    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T findById(ID id) {
        return map.get(id);
    }

    /** now this method is more like Spring Data JPA save() method */
    T save(T object) {
        if (object != null) {
            if (object.getId() == null) {
                object.setId(getNextId());
            }
            map.put(object.getId(), object);
        } else {
            throw new RuntimeException("Object can't be null");
        }
        return object;
    }

    void deleteById(ID id) {
        map.remove(id);
    }

    void delete(T object) {
        map.entrySet().removeIf(entry -> entry.getValue().equals(object));
    }

    private Long getNextId() {
        /** initally map is empty, so max() method will throw exception, so just handling that */
        Long id;
        try {
            id =  Collections.max(map.keySet()) + 1;
        } catch (NoSuchElementException e) {
            id = 1L;
        }
        return id;
    }
}
