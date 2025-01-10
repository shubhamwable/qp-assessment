package com.questionpro.assesment.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class GroceryItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    private int inventory;

    public Long getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getInventory() { return inventory; }

    public void setId(Long id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
    public void setInventory(int inventory) { this.inventory = inventory; }
} 