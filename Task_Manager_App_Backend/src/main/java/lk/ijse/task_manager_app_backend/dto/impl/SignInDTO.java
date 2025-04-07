package lk.ijse.task_manager_app_backend.dto.impl;

import lk.ijse.task_manager_app_backend.dto.SignInStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SignInDTO implements SignInStatus {
    private String username;
    private String password;
}
