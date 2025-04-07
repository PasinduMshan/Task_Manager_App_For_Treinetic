package lk.ijse.task_manager_app_backend.service.impl;

import lk.ijse.task_manager_app_backend.dao.TaskDAO;
import lk.ijse.task_manager_app_backend.dto.TaskStatus;
import lk.ijse.task_manager_app_backend.dto.impl.TaskDTO;
import lk.ijse.task_manager_app_backend.entity.Task;
import lk.ijse.task_manager_app_backend.exception.DataPersistException;
import lk.ijse.task_manager_app_backend.service.TaskService;
import lk.ijse.task_manager_app_backend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    @Override
    public List<TaskDTO> getAllTasks() {
        List<Task> taskList = taskDAO.findAll();
        return mapping.toTaskDTOList(taskList);
    }

    @Override
    public TaskStatus getTaskById(Long taskId) {
        if (taskDAO.existsById(taskId)) {
            Task taskData = taskDAO.getReferenceById(taskId);
            return mapping.toTaskDTO(taskData);
        } else {
            throw new RuntimeException("Task not found!");
        }
    }

    @Override
    public void deleteTask(Long taskId) {
        Optional<Task> task = taskDAO.findById(taskId);
        if (!task.isPresent()) {
            throw new RuntimeException("Task not found!");
        } else {
            taskDAO.deleteById(taskId);
        }
    }

    @Override
    public void updateTask(Long taskId, TaskDTO taskDTO) {
        Optional<Task> task = taskDAO.findById(taskId);
        if (!task.isPresent()) {
            throw new RuntimeException("Task not found!");
        } else {
            task.get().setTitle(taskDTO.getTitle());
            task.get().setDescription(taskDTO.getDescription());
            task.get().setStatus(taskDTO.getStatus());
            task.get().setCreatedAt(taskDTO.getCreatedAt());
        }
    }
}
