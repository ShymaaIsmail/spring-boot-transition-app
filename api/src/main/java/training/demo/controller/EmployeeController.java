package training.demo.controller;
 
import java.util.List;
import training.demo.domain.entity.Employee;
import training.demo.service.EmployeeService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
 
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
@RestController
@RequestMapping("employee")
@CrossOrigin(origins="*")
public class EmployeeController {
	  
    protected EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService=employeeService;
    }

    @GetMapping()
    public List<Employee> findAll() {
       List<Employee>  employees = employeeService.findAll();  
       return employees;
    }

    @GetMapping("findByName/{name}")
    public List<Employee> findByName(@PathVariable String name){
    
    List<Employee>  employees = employeeService.findEmployeeByName(name);  
    
    return employees;
    }
    
    @GetMapping("findById/{id}")
    public Employee findById(@PathVariable Long id) {
        return employeeService.findEmployeeByID(id);
    }
    
    @PostMapping()
    public Long postEmployee(@RequestBody Employee employee) {
        Long addedEmployeeId= employeeService.addNewEmployee(employee);
        return addedEmployeeId;
    }

    @PutMapping()
    public Employee putEmployee(@RequestBody Employee employee) {
        Employee updatedEmployeeId= employeeService.updateEmployee(employee);
        return updatedEmployeeId;
    } 

    
	 
}