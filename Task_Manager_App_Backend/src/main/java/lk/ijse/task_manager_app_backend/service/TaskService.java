package lk.ijse.task_manager_app_backend.service;

import lk.ijse.task_manager_app_backend.dto.TaskStatus;
import lk.ijse.task_manager_app_backend.dto.impl.TaskDTO;
import lk.ijse.task_manager_app_backend.exception.DataPersistException;

import java.util.List;

public interface TaskService {
    void saveTask(TaskDTO taskDTO) throws DataPersistException;
    List<TaskDTO> getAllTasks();
    TaskStatus getTaskById(Long taskId);
    void deleteTask(Long taskId);
    void updateTask(Long taskId, TaskDTO taskDTO);
}
