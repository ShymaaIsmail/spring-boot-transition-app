 package training.demo.service;
import training.demo.domain.dto.ToDoDTO;
import  training.demo.domain.entity.ToDo;
import java.util.List;
import training.demo.repository.ToDoRepository;
import training.demo.service.ToDoService;   
import training.demo.mapper.BaseMapper;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

import java.util.ArrayList; 

@Service  
@AllArgsConstructor
public class ToDoService {
    private final ToDoRepository toDoRepository;
    private final BaseMapper baseMapper;

    
    public List<ToDoDTO> findAll() {
        List<ToDo> allToDos =new ArrayList<ToDo>();;
        Iterable<ToDo> ToDos = toDoRepository.findAll();
        ToDos.forEach(allToDos::add);
       return baseMapper.transformList(ToDoDTO.class, allToDos, ToDo.class);
    }
     
    
    public Long addNewToDo(ToDoDTO ToDoDto) {
    ToDo todo= baseMapper.transformFromSourceToDestination(ToDo.class, ToDoDto, ToDoDTO.class);
    ToDo addedToDo=  toDoRepository.save(todo);
    return addedToDo.getId();
    }
    
    public ToDoDTO updateToDo(ToDoDTO toDoDto) {
        ToDo toDo= baseMapper.transformFromSourceToDestination(ToDo.class, toDoDto, ToDoDTO.class);
        ToDo updatedToDo=  toDoRepository.save(toDo);
        ToDoDTO updatedToDoDTO= baseMapper.transformFromSourceToDestination(ToDoDTO.class, updatedToDo, ToDo.class);
        return updatedToDoDTO;
    }
    
    public void delete(long id, long employeeId) {
        ToDo todoToBeDeleted=toDoRepository.findByIdAndEmployee_id(id, employeeId);
        toDoRepository.delete(todoToBeDeleted);
    }
    
    public ToDoDTO findToDoByID(Long id) {
        ToDoDTO existedToDoDTO=null;
        ToDo existedToDo=null;
        boolean isExistedToDo= toDoRepository.existsById(id);
        if(isExistedToDo){
        existedToDo= toDoRepository.findById(id).get();
        existedToDoDTO=baseMapper.transformFromSourceToDestination(ToDoDTO.class, existedToDo, ToDo.class);
        }
        return existedToDoDTO;
     }
  


}
    
