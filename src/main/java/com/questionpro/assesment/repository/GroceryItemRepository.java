package com.questionpro.assesment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.questionpro.assesment.model.GroceryItem;

@Transactional
public interface GroceryItemRepository extends JpaRepository<GroceryItem, Long> {
} 