package training.demo.controller;
 
import java.util.List;

import training.demo.domain.dto.EmployeeDTO; 
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
public class EmployeeController {
	  
    protected EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService=employeeService;
    }

    @GetMapping()
    public List<EmployeeDTO> findAll() {
       List<EmployeeDTO>  employees = employeeService.findAll();  
       return employees;
    }

    @GetMapping("findByName/{name}")
    public List<EmployeeDTO> findByName(@PathVariable String name){
    List<EmployeeDTO>  employees = employeeService.findEmployeeByName(name);  
    return employees;
    }
    
    @GetMapping("findById/{id}")
    public EmployeeDTO findById(@PathVariable Long id) {
        return employeeService.findEmployeeByID(id);
    }
    
    @PostMapping()
    public Long postEmployee(@RequestBody EmployeeDTO employeeDto) {
        Long addedEmployeeId= employeeService.addNewEmployee(employeeDto);
        return addedEmployeeId;
    }

    @PutMapping()
    public EmployeeDTO putEmployee(@RequestBody EmployeeDTO employeeDto) {
        EmployeeDTO updatedEmployeeId= employeeService.updateEmployee(employeeDto);
        return updatedEmployeeId;
    } 
 
	 
}