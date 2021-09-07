package training.demo.service.impl;
import  training.demo.domain.entity.Employee;
import java.util.List;
import training.demo.repository.EmployeeRepository;
import training.demo.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList; 
  
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
    
