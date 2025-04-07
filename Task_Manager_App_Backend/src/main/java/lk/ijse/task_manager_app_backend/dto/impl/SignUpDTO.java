package lk.ijse.task_manager_app_backend.dto.impl;

import lk.ijse.task_manager_app_backend.dto.SignUpStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SignUpDTO implements SignUpStatus {
    private Long id;
    private String username;
    private String password;
}
