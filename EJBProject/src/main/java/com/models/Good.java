package com.models;

import java.io.Serializable;

public class Good implements Serializable{
    private int id;
    private String title;
    private int amount;
    private String description;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Good(int id, String title, int amount, String description){
        this.id = id;
        this.title = title;
        this.amount = amount;
        this.description = description;
    }

    public Good() {}
}
