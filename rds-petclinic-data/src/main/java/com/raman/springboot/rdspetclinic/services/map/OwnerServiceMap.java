package com.raman.springboot.rdspetclinic.services.map;

import com.raman.springboot.rdspetclinic.model.Owner;
import com.raman.springboot.rdspetclinic.services.OwnerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    @Override
    public Owner findByLastName(String lastName) {
        List<Owner> collect = super.map.values().stream().filter(owner -> owner.getLastName().equals(lastName)).collect(Collectors.toList());
        if (collect == null || collect.size() == 0)
            return null;
        else
            return collect.get(0);
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {
        return super.save(object.getId(), object);
    }

    @Override
    public void delete(Owner object) {
        super.delete(object);
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }
}
