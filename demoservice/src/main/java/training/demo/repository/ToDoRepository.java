package training.demo.repository;

import training.demo.entity.ToDo;
import org.springframework.data.repository.CrudRepository;

public interface ToDoRepository extends CrudRepository<ToDo, Long> {
    ToDo findByIdAndEmployee_id(Long id, long employee_id);
}
