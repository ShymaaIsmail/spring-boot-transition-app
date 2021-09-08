package training.demo.service;

import  training.demo.domain.entity.Employee;
import java.util.List;
   
public interface EmployeeService {
    List<Employee> findAll();
    List<Employee> findEmployeeByName(String name);
    Employee findEmployeeByID(Long id);
    Long addNewEmployee(Employee employee);
    Employee updateEmployee(Employee employee);
    void delete(long id);
}
