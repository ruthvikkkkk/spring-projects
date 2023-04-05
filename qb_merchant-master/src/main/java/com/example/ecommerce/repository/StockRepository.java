package com.example.ecommerce.repository;

import com.example.ecommerce.entity.Stock;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StockRepository extends CrudRepository<Stock, String> {

    List<Stock> findAll();
}
