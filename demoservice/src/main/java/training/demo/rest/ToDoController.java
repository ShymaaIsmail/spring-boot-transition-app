package training.demo.rest;

import java.util.List;

import training.demo.model.ToDoModel;
import training.demo.exception.NotFoundEntityException;
import training.demo.service.ToDoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@RequestMapping("todo")
public class ToDoController {

    private final ToDoService toDoService;

    @GetMapping()
    public ResponseEntity<List<ToDoModel>> findAll() {
        List<ToDoModel> toDos = toDoService.findAll();
        return ResponseEntity.ok(toDos);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<ToDoModel> findById(@PathVariable Long id) {
        ToDoModel toDo = toDoService.findToDoByID(id);
        return ResponseEntity.ok(toDo);
    }

    @PostMapping()
    public ResponseEntity<Long> postToDo(@RequestBody ToDoModel todo) {
        Long addedToDoId = toDoService.addNewToDo(todo);
        return ResponseEntity.ok(addedToDoId);
    }

    @PutMapping()
    public ResponseEntity<ToDoModel> putToDo(@RequestBody ToDoModel todo) {
        ToDoModel updatedToDo = toDoService.updateToDo(todo);
        return ResponseEntity.ok(updatedToDo);
    }

    @DeleteMapping("/{id}/users/{userId}")
    public void deleteToDo(@PathVariable Long id, @PathVariable Long userId) {
        toDoService.delete(id, userId);
    }

}