package training.demo.service;

import  training.demo.domain.entity.Employee;
import java.util.List;
   
public interface EmployeeService {
    List<Employee> findAll();
    List<Employee> findEmployeeByName(String name);
}
