 package training.demo.service;
import  training.demo.domain.entity.ToDo;
import java.util.List;
import training.demo.repository.ToDoRepository;
import training.demo.service.ToDoService;   
import org.springframework.stereotype.Service;
 

import java.util.ArrayList; 
  
@Service  
public class ToDoService {
    private final ToDoRepository toDoRepository;

    public ToDoService (ToDoRepository toDoRepository)  {
        this.toDoRepository=toDoRepository;
    }
    
    
    public List<ToDo> findAll() {
        List<ToDo> allToDos =new ArrayList<ToDo>();;
        Iterable<ToDo> ToDos = toDoRepository.findAll();
        ToDos.forEach(allToDos::add);
        return allToDos;
    }
     
    
    public Long addNewToDo(ToDo ToDo) {
         
    ToDo addedToDo=  toDoRepository.save(ToDo);
    
    return addedToDo.getId();
    }
    
    public ToDo updateToDo(ToDo ToDo) {
        ToDo updatedToDo=  toDoRepository.save(ToDo);
    
        return updatedToDo;
    }
    
    public void delete(long id, long employeeId) {
        ToDo todoToBeDeleted=toDoRepository.findByIdAndEmployee_id(id, employeeId);
        toDoRepository.delete(todoToBeDeleted);
    }
    
    public ToDo findToDoByID(Long id) {
        ToDo existedToDo=null;
        boolean isExistedToDo= toDoRepository.existsById(id);
        if(isExistedToDo){
        existedToDo= toDoRepository.findById(id).get();
        }
        return existedToDo;
    }
  


}
    
