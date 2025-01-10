package com.questionpro.assesment.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.questionpro.assesment.model.GroceryItem;
import com.questionpro.assesment.model.Order;
import com.questionpro.assesment.repository.GroceryItemRepository;
import com.questionpro.assesment.repository.OrderRepository;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private final GroceryItemRepository groceryItemRepository;
    private final OrderRepository orderRepository;
    
    public UserController(GroceryItemRepository groceryItemRepository, OrderRepository orderRepository) {
        this.groceryItemRepository = groceryItemRepository;
        this.orderRepository = orderRepository;
    }

    @GetMapping("/items") 
    public ResponseEntity<List<GroceryItem>> getAllItems() {
        return ResponseEntity.ok(groceryItemRepository.findAll());
    }

    @PostMapping("/orders")
    public ResponseEntity<Order> createOrder(@RequestBody List<Long> itemIds, @RequestParam String userEmail) {
        List<GroceryItem> items = groceryItemRepository.findAllById(itemIds);
        
        Order order = new Order();
        order.setItems(items);
        order.setOrderDate(LocalDateTime.now());
        order.setUserEmail(userEmail);
        
        return ResponseEntity.ok(orderRepository.save(order));
    }
} 