package lk.ijse.task_manager_app_backend.controller;

import lk.ijse.task_manager_app_backend.dto.TaskStatus;
import lk.ijse.task_manager_app_backend.dto.impl.TaskDTO;
import lk.ijse.task_manager_app_backend.exception.DataPersistException;
import lk.ijse.task_manager_app_backend.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/tasks")
public class TaskController {
    @Autowired
    TaskService taskService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveTask(@RequestBody TaskDTO taskDTO) {
        try {
            taskService.saveTask(taskDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (DataPersistException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TaskDTO> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public TaskStatus getTaskById(@PathVariable("id") Long id) {
        return taskService.getTaskById(id);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteTaskById(@PathVariable("id") Long id) {
        try {
            taskService.deleteTask(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, value = "/{id}")
    public ResponseEntity<Void> updateTask(@PathVariable("id") Long id, @RequestBody TaskDTO taskDTO) {
        try {
            taskService.updateTask(id, taskDTO);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
