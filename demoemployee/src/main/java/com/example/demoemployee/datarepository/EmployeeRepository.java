package com.example.demoemployee.datarepository;

import com.example.demoemployee.entity.EmployeeEntity;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<EmployeeEntity, String> {
}
