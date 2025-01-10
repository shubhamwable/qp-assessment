package com.questionpro.assesment.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.questionpro.assesment.model.GroceryItem;
import com.questionpro.assesment.repository.GroceryItemRepository;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final GroceryItemRepository groceryItemRepository;

    public AdminController(GroceryItemRepository groceryItemRepository) {
        this.groceryItemRepository = groceryItemRepository;
    }

    @PostMapping("/items")
    public ResponseEntity<GroceryItem> addItem(@RequestBody GroceryItem item) {
        return ResponseEntity.ok(groceryItemRepository.save(item));
    }

    @GetMapping("/items")
    public ResponseEntity<List<GroceryItem>> getAllItems() {
        return ResponseEntity.ok(groceryItemRepository.findAll());
    }

    @PutMapping("/items/{id}")
    public ResponseEntity<GroceryItem> updateItem(@PathVariable Long id, @RequestBody GroceryItem item) {
        if (!groceryItemRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        item.setId(id);
        return ResponseEntity.ok(groceryItemRepository.save(item));
    }

    @DeleteMapping("/items/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        if (!groceryItemRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        groceryItemRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
} 