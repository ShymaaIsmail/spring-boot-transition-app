package com.example.transitiondemoapp.transitiondemo.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.transitiondemoapp.transitiondemo.model.Employee;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
 

@RestController
public class EmployeeController {
	
private List<Employee> employeeList = new ArrayList<Employee>();
 
    public EmployeeController(){
        employeeList.add(new Employee(1l, "emp1"));
        employeeList.add(new Employee(2l, "emp2"));
        employeeList.add(new Employee(3l, "emp3"));
        employeeList.add(new Employee(4l, "emp4"));
    }

    @RequestMapping("/employee/all")
    public List<Employee> findAll() {
        return employeeList;
    }

    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public Employee addemployee(Employee employee) {
        employeeList.add(employee);
        return employee;
    }

    @RequestMapping("/employee/findby/{id}")
    public Employee findById(@PathVariable Long id) {
        return employeeList.stream().
                 filter(employee -> employee.getId().equals(id)).
                   findFirst().get();
    }
	@GetMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}
}