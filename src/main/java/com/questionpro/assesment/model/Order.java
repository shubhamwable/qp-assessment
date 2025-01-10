package com.questionpro.assesment.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "grocery_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToMany
    private List<GroceryItem> items;
    
    private LocalDateTime orderDate;
    private String userEmail;

    public Long getId() { return id; }
    public List<GroceryItem> getItems() { return items; }
    public LocalDateTime getOrderDate() { return orderDate; }
    public String getUserEmail() { return userEmail; }

    public void setId(Long id) { this.id = id; }
    public void setItems(List<GroceryItem> items) { this.items = items; }
    public void setOrderDate(LocalDateTime orderDate) { this.orderDate = orderDate; }
    public void setUserEmail(String userEmail) { this.userEmail = userEmail; }
} 