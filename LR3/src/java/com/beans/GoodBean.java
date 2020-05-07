package com.beans;

import com.entity.Good;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class GoodBean implements GoodBeanLocal {
    @PersistenceContext(unitName = "LR3PU")
    private EntityManager em;
    
    @Override
    public List<Good> findAll() {
        List <Good> goods
                =em.createQuery("SELECT u FROM Good u").getResultList();
        return goods;
    }
    
    
    @Override
    public void create(Good good) {
        em.persist(good);
    }

    @Override
    public void edit(Good good) {
        em.merge(good);
    }

    @Override
    public void remove(Good good) {
        em.remove(em.merge(good));
    }
     
    @Override
    public Good find(int id) {
        return em.find(Good.class, id);
    }
}
