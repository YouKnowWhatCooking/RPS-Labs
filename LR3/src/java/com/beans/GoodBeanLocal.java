package com.beans;

import com.entity.Good;
import java.util.List;

@Local
public interface GoodBeanLocal {
    public List<Good> findAll();
    public void create(Good u);
    public void edit(Good u);
    public void remove(Good u);
    public Good find(int id);
}
