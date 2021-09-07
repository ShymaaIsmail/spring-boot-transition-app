package training.demo.controller;

import java.util.ArrayList;
import java.util.List;

import training.demo.domain.entity.Employee;
import training.demo.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
 

@RestController
public class EmployeeController {
	
private List<Employee> employeeList = new ArrayList<Employee>();
 

    @Autowired
    protected EmployeeService employeeService;

    public EmployeeController(){
        employeeList.add(new Employee(1l, "emp1"));
        employeeList.add(new Employee(2l, "emp2"));
        employeeList.add(new Employee(3l, "emp3"));
        employeeList.add(new Employee(4l, "emp4"));
    }

    @RequestMapping("/employee/all")
    public List<Employee> findAll() {
       
            List<Employee>  employees = employeeService.findAll();  
            
            return employees;
    }

    @RequestMapping("employee/findByName/{name}")
    public List<Employee> findByName(@PathVariable String name){
    
    List<Employee>  employees = employeeService.findEmployeeByName(name);  
    
    return employees;
    }
    
    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public Employee postEmployee(Employee employee) {
        employeeList.add(employee);
        return employee;
    }

    @RequestMapping("/employee/findBy/{id}")
    public Employee findById(@PathVariable Long id) {
        return employeeList.stream().
                 filter(employee -> employee.getId().equals(id)).
                   findFirst().get();
    }
	 
}