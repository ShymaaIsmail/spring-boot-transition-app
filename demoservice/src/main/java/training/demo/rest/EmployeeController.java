package training.demo.rest;

import java.util.List;

import training.demo.model.EmployeeModel;
import training.demo.service.EmployeeService;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@AllArgsConstructor
@RequestMapping("employee")
public class EmployeeController {

    protected EmployeeService employeeService;

    @GetMapping()
    public ResponseEntity<List<EmployeeModel>> findAll() {
        List<EmployeeModel> employees = employeeService.findAll();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("findByName/{name}")
    public ResponseEntity<List<EmployeeModel>> findByName(@PathVariable String name) {
        List<EmployeeModel> employees = employeeService.findEmployeeByName(name);
        return ResponseEntity.ok(employees);
    }

    @GetMapping("findById/{id}")
    public ResponseEntity<EmployeeModel> findById(@PathVariable Long id) {
        EmployeeModel employeeDto = employeeService.findEmployeeByID(id);
        return ResponseEntity.ok(employeeDto);
    }

    @PostMapping()
    public ResponseEntity<Long> postEmployee(@RequestBody EmployeeModel employeeDto) {
        Long addedEmployeeId = employeeService.addNewEmployee(employeeDto);
        return ResponseEntity.ok(addedEmployeeId);
    }

    @PutMapping()
    public ResponseEntity<EmployeeModel> putEmployee(@RequestBody EmployeeModel employeeDto) {
        EmployeeModel updatedEmployeeId = employeeService.updateEmployee(employeeDto);
        return ResponseEntity.ok(updatedEmployeeId);
    }

}