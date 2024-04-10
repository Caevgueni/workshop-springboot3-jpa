package com.devcarlos.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devcarlos.course.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
