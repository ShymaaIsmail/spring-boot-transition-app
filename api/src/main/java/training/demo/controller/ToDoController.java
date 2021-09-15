package training.demo.controller;
 
import java.util.List;

import training.demo.domain.dto.ToDoDTO; 
import training.demo.service.ToDoService;
  
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
 
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("todo")
public class ToDoController {
	  
    protected ToDoService toDoService;

    public ToDoController(ToDoService toDoService) {
        this.toDoService=toDoService;
    }
    @GetMapping()
    public List<ToDoDTO> findAll() {
       List<ToDoDTO>  ToDos = toDoService.findAll();  
       return ToDos;
    }
 
    
    @GetMapping("/findBy/{id}")
    public ToDoDTO findById(@PathVariable Long id) {
        return toDoService.findToDoByID(id);
    }
    
    @PostMapping()
    public Long postToDo(@RequestBody ToDoDTO ToDo) {
        Long addedToDoId= toDoService.addNewToDo(ToDo);
        return addedToDoId;
    }

    @PutMapping()
    public ToDoDTO putToDo(@RequestBody ToDoDTO ToDo) {
        ToDoDTO updatedToDoId= toDoService.updateToDo(ToDo);
        return updatedToDoId;
    } 


    @DeleteMapping("/{id}/users/{userId}")
    public void deleteToDo(@PathVariable Long id, @PathVariable Long userId) {
        toDoService.delete(id,userId); 
    }  
    
	  
}