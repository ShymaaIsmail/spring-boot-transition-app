package training.demo.service;

import training.demo.model.EmployeeModel;
import training.demo.entity.Employee;
import java.util.List;
import java.util.Optional;

import training.demo.repository.EmployeeRepository;
import training.demo.service.EmployeeService;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import training.demo.mapper.BaseMapper;

import java.util.ArrayList;

@Service
@AllArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final BaseMapper baseMapper;

    public List<EmployeeModel> findAll() {
        List<Employee> allEmployees = new ArrayList<>();
        Iterable<Employee> employees = employeeRepository.findAll();
        employees.forEach(allEmployees::add);
        return baseMapper.transformList(EmployeeModel.class, allEmployees, Employee.class);
    }

    public List<EmployeeModel> findEmployeeByName(String name) {
        List<Employee> employees = employeeRepository.findByName(name);
        return baseMapper.transformList(EmployeeModel.class, employees, Employee.class);
    }

    public Long addNewEmployee(EmployeeModel employeeDto) {
        Employee employee = baseMapper.transformFromSourceToDestination(Employee.class, employeeDto,
                EmployeeModel.class);
        Employee addedEmployee = employeeRepository.save(employee);
        return addedEmployee.getId();
    }

    public EmployeeModel updateEmployee(EmployeeModel employeeDto) {
        Employee employee = baseMapper.transformFromSourceToDestination(Employee.class, employeeDto,
                EmployeeModel.class);
        Employee updatedEmployee = employeeRepository.save(employee);
        return baseMapper.transformFromSourceToDestination(EmployeeModel.class, updatedEmployee, Employee.class);

    }

    public void delete(long id) {
        Optional<Employee> toBeDeletedEmployee = employeeRepository.findById(id);
        if (toBeDeletedEmployee.isPresent()) {
            employeeRepository.delete(toBeDeletedEmployee.get());
        }
    }

    public EmployeeModel findEmployeeByID(Long id) {
        EmployeeModel existedEmployeeDTO = null;
        Optional<Employee> existedEmployee = employeeRepository.findById(id);
        if (existedEmployee.isPresent()) {
            existedEmployeeDTO = baseMapper.transformFromSourceToDestination(EmployeeModel.class, existedEmployee.get(),
                    Employee.class);
        }
        return existedEmployeeDTO;
    }

}
