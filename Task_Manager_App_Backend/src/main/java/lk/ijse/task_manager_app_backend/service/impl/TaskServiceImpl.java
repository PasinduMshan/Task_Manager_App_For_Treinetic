package lk.ijse.task_manager_app_backend.service.impl;

import lk.ijse.task_manager_app_backend.dao.TaskDAO;
import lk.ijse.task_manager_app_backend.dto.impl.TaskDTO;
import lk.ijse.task_manager_app_backend.entity.Task;
import lk.ijse.task_manager_app_backend.exception.DataPersistException;
import lk.ijse.task_manager_app_backend.service.TaskService;
import lk.ijse.task_manager_app_backend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskDAO taskDAO;
    @Autowired
    private Mapping mapping;

    @Override
    public void saveTask(TaskDTO taskDTO) throws DataPersistException {
        Task savedTask = taskDAO.save(mapping.toTaskEntity(taskDTO));
        if (savedTask == null) {
            throw new DataPersistException("Task not saved!");
        }
    }
}
