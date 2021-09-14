 package training.demo.service;
import  training.demo.domain.entity.Employee;
import java.util.List;
import training.demo.repository.EmployeeRepository;
import training.demo.service.EmployeeService;   
import org.springframework.stereotype.Service;
 

import java.util.ArrayList; 
  
@Service  
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    public EmployeeService (EmployeeRepository employeeRepository)  {
        this.employeeRepository=employeeRepository;
    }
    
    
    public List<Employee> findAll() {
        List<Employee> allEmployees =new ArrayList<Employee>();;
        Iterable<Employee> employees = employeeRepository.findAll();
        employees.forEach(allEmployees::add);
        return allEmployees;
    }
    
    public List<Employee> findEmployeeByName(String name) {

        List<Employee> employees = employeeRepository.findByName(name);
        return employees;
    }
    
    public Long addNewEmployee(Employee employee) {
         
    Employee addedEmployee=  employeeRepository.save(employee);
    
    return addedEmployee.getId();
    }
    
    public Employee updateEmployee(Employee employee) {
        Employee updatedEmployee=  employeeRepository.save(employee);
    
        return updatedEmployee;
    }
    
    public void delete(long id) {
        Employee toBeDeletedEmployee=  employeeRepository.findById(id).get();
        employeeRepository.delete(toBeDeletedEmployee);
    }
    
    public Employee findEmployeeByID(Long id) {
        Employee existedEmployee=null;
        boolean isExistedEmployee= employeeRepository.existsById(id);
        if(isExistedEmployee){
        existedEmployee= employeeRepository.findById(id).get();
        }
        return existedEmployee;
    }
  


}
    
