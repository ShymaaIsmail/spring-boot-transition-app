 package training.demo.service;
import training.demo.domain.dto.EmployeeDTO;
import  training.demo.domain.entity.Employee;
import java.util.List;
import training.demo.repository.EmployeeRepository;
import training.demo.service.EmployeeService;   
import org.springframework.stereotype.Service;
import  training.demo.mapper.BaseMapper;

import java.util.ArrayList; 
  
@Service  
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final BaseMapper baseMapper;
    public EmployeeService (EmployeeRepository employeeRepository,BaseMapper baseMapper)  {
        this.employeeRepository=employeeRepository;
        this.baseMapper=baseMapper;
    }
    
    
    public List<EmployeeDTO> findAll() {
        List<Employee> allEmployees =new ArrayList<Employee>();;
        Iterable<Employee> employees = employeeRepository.findAll();
        employees.forEach(allEmployees::add);
        return baseMapper.transformList(EmployeeDTO.class, allEmployees, Employee.class);
    }
    
    public List<EmployeeDTO> findEmployeeByName(String name) {
        List<Employee> employees = employeeRepository.findByName(name);
        return baseMapper.transformList(EmployeeDTO.class, employees, Employee.class);
    }
    
    public Long addNewEmployee(EmployeeDTO employeeDto) {
        Employee employee= baseMapper.transformFromSourceToDestination(Employee.class, employeeDto, EmployeeDTO.class);
        Employee addedEmployee=  employeeRepository.save(employee);
        return addedEmployee.getId();
    }
    
    public EmployeeDTO updateEmployee(EmployeeDTO employeeDto) {
        Employee employee= baseMapper.transformFromSourceToDestination(Employee.class, employeeDto, EmployeeDTO.class);
        Employee updatedEmployee=  employeeRepository.save(employee);
        EmployeeDTO updatedEmployeeDTO= baseMapper.transformFromSourceToDestination(EmployeeDTO.class, updatedEmployee, Employee.class);
        return updatedEmployeeDTO;
    }
    
    public void delete(long id) {
        Employee toBeDeletedEmployee=  employeeRepository.findById(id).get();
        employeeRepository.delete(toBeDeletedEmployee);
    }
    
    public EmployeeDTO findEmployeeByID(Long id) {
        EmployeeDTO existedEmployeeDTO=null;
        Employee existedEmployee=null;
        boolean isExistedEmployee= employeeRepository.existsById(id);
        if(isExistedEmployee){
        existedEmployee= employeeRepository.findById(id).get();
        existedEmployeeDTO=baseMapper.transformFromSourceToDestination(EmployeeDTO.class, existedEmployee, Employee.class);
        }
        return existedEmployeeDTO;
    }
  


}
    
