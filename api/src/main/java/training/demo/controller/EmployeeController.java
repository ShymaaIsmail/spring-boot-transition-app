package training.demo.controller;

import java.util.ArrayList;
import java.util.List;

import training.demo.domain.entity.Employee;
import training.demo.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
 
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class EmployeeController {
	 
    @Autowired
    protected EmployeeService employeeService;

    @GetMapping("/employee/all")
    public List<Employee> findAll() {
       List<Employee>  employees = employeeService.findAll();  
       return employees;
    }

    @GetMapping("employee/findByName/{name}")
    public List<Employee> findByName(@PathVariable String name){
    
    List<Employee>  employees = employeeService.findEmployeeByName(name);  
    
    return employees;
    }
    
    @GetMapping("/employee/findBy/{id}")
    public Employee findById(@PathVariable Long id) {
        return employeeService.findEmployeeByID(id);
    }


    @PostMapping("/employee")
    public Long postEmployee(@RequestBody Employee employee) {
        Long addedEmployeeId= employeeService.addNewEmployee(employee);
        return addedEmployeeId;
    }

    @PutMapping(value = "/employee")
    public Employee putEmployee(@RequestBody Employee employee) {
        Employee updatedEmployeeId= employeeService.updateEmployee(employee);
        return updatedEmployeeId;
    } 

    
	 
}