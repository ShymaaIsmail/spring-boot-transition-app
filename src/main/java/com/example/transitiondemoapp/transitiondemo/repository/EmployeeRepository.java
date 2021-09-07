package com.example.transitiondemoapp.transitiondemo.repository;
import com.example.transitiondemoapp.transitiondemo.model.Employee;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
 
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
 List<Employee> findByName(String name);
}
