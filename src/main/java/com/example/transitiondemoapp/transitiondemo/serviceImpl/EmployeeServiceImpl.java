package com.example.transitiondemoapp.transitiondemo.serviceImpl;
import com.example.transitiondemoapp.transitiondemo.model.Employee;
import com.example.transitiondemoapp.transitiondemo.repository.EmployeeRepository;
import com.example.transitiondemoapp.transitiondemo.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
  
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    
    @Override
    public List<Employee> findAll() {
        List<Employee> allEmployees =new ArrayList<Employee>();;
        Iterable<Employee> employees = employeeRepository.findAll();
        employees.forEach(allEmployees::add);
        return allEmployees;
    }
    @Override
    public List<Employee> findEmployeeByName(String name) {

        List<Employee> employees = employeeRepository.findByName(name);
        return employees;
    }
  


}
    
