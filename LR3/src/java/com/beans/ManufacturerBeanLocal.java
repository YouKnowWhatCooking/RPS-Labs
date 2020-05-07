package com.beans;

import com.entity.Manufacturer;
import java.util.List;


@Local
public interface ManufacturerBeanLocal {
    public List<Manufacturer> findAll();
}

