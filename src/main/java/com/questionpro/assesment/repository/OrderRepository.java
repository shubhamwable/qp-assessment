package com.questionpro.assesment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.questionpro.assesment.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
} 