package com.example.fileconsumer.repository;

import com.example.fileconsumer.entity.OrderDto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<OrderDto, Long> {
}
