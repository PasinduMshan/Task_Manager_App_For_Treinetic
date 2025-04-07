package lk.ijse.task_manager_app_backend.util;

import lk.ijse.task_manager_app_backend.dto.impl.TaskDTO;
import lk.ijse.task_manager_app_backend.entity.Task;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapping {
    @Autowired
    private ModelMapper modelMapper;

    public Task toTaskEntity(TaskDTO taskDTO) {
        return modelMapper.map(taskDTO, Task.class);
    }
    public TaskDTO toTaskDTO(Task task) {
        return modelMapper.map(task, TaskDTO.class);
    }
    public List<TaskDTO> toTaskDTOList(List<Task> taskList) {
        return modelMapper.map(taskList, new TypeToken<List<TaskDTO>>() {}.getType());
    }
}
