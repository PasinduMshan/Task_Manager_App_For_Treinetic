package lk.ijse.task_manager_app_backend.dto.impl;

import lk.ijse.task_manager_app_backend.dto.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskDTO implements TaskStatus {
    private Long id;
    private String title;
    private String description;
    private String status;
    private LocalDateTime createdAt;
}
