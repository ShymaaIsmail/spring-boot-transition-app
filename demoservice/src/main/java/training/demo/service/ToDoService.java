package training.demo.service;

import training.demo.model.ToDoModel;
import training.demo.entity.ToDo;
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

    public List<ToDoModel> findAll() {
        List<ToDo> allToDos = new ArrayList<ToDo>();
        Iterable<ToDo> ToDos = toDoRepository.findAll();
        ToDos.forEach(allToDos::add);
        return baseMapper.transformList(ToDoModel.class, allToDos, ToDo.class);
    }

    public Long addNewToDo(ToDoModel ToDoDto) {
        ToDo todo = baseMapper.transformFromSourceToDestination(ToDo.class, ToDoDto, ToDoModel.class);
        ToDo addedToDo = toDoRepository.save(todo);
        return addedToDo.getId();
    }

    public ToDoModel updateToDo(ToDoModel toDoDto) {
        ToDo toDo = baseMapper.transformFromSourceToDestination(ToDo.class, toDoDto, ToDoModel.class);
        ToDo updatedToDo = toDoRepository.save(toDo);
        ToDoModel updatedToDoDTO = baseMapper.transformFromSourceToDestination(ToDoModel.class, updatedToDo,
                ToDo.class);
        return updatedToDoDTO;
    }

    public void delete(long id, long employeeId) {
        ToDo todoToBeDeleted = toDoRepository.findByIdAndEmployee_id(id, employeeId);
        toDoRepository.delete(todoToBeDeleted);
    }

    public ToDoModel findToDoByID(Long id) {
        ToDoModel existedToDoDTO = null;
        ToDo existedToDo = null;
        boolean isExistedToDo = toDoRepository.existsById(id);
        if (isExistedToDo) {
            existedToDo = toDoRepository.findById(id).get();
            existedToDoDTO = baseMapper.transformFromSourceToDestination(ToDoModel.class, existedToDo, ToDo.class);
        }
        return existedToDoDTO;
    }

}
