package com.example.restemployee.repository;

import com.example.restemployee.entity.Dependant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DependantRepository extends CrudRepository<Dependant, Integer> {
}
