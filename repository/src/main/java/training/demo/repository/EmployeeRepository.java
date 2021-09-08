package training.demo.repository;

import  training.demo.domain.entity.Employee;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
 
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
 List<Employee> findByName(String name);
 
}
