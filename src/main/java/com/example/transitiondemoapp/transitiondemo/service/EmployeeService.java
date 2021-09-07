package com.example.transitiondemoapp.transitiondemo.service;
import com.example.transitiondemoapp.transitiondemo.model.Employee;
import java.util.List;
  
public interface EmployeeService {
        List<Employee> findAll();
        List<Employee> findEmployeeByName(String name);
}
    
