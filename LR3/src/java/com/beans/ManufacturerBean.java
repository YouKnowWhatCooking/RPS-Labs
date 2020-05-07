package com.beans;

import com.entity.Manufacturer;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class ManufacturerBean implements ManufacturerBeanLocal {
    @PersistenceContext(unitName = "LR3PU")
    private EntityManager em;
    
    @Override
    public List<Manufacturer> findAll() {
        List < Manufacturer > manList
                =em.createQuery("SELECT r FROM Manufacturer r").getResultList();
        return manList;
    }

    @Override
    public Manufacturer find(int id) {
        Manufacturer m = em.find(Manufacturer.class, id);        
        return m;
    }
}
