package training.demo.repository;

import  training.demo.domain.entity.ToDo;
import org.springframework.data.repository.CrudRepository;
 
public interface ToDoRepository extends CrudRepository<ToDo, Long> {
 ToDo findByIdAndEmployee_id(Long Id,long Employee_id);
  
}
