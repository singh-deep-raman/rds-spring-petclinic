package com.raman.springboot.rdspetclinic.services.map;

import com.raman.springboot.rdspetclinic.model.Visit;
import com.raman.springboot.rdspetclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Profile({"default", "map"}) // default means when no profile is active, this profile is default to be used
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Visit object) {
        super.delete(object);
    }

    @Override
    public Visit save(Visit visit) {
        if (visit == null ||
                visit.getPet() == null || visit.getPet().getId() == null ||
                visit.getPet().getOwner() == null || visit.getPet().getOwner().getId() == null) {
            throw new RuntimeException("Invalid visit specified");
        }
        return super.save(visit);
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }
}
