package com.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "good")
public class Good implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;
    
    @JoinColumn(name = "manufacturer", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Manufacturer manufacturer;

    public Good(Integer id, String title) {
        this.id = id;
        this.title = title;
    }
    
    public Good() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Manufacturer getManufacturer () {
        return manufacturer;
    }

    public void setManufacturer (Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }
}

