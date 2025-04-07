package lk.ijse.task_manager_app_backend.service;

import lk.ijse.task_manager_app_backend.dto.impl.TaskDTO;
import lk.ijse.task_manager_app_backend.exception.DataPersistException;

public interface TaskService {
    void saveTask(TaskDTO taskDTO) throws DataPersistException;
}
