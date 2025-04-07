package lk.ijse.task_manager_app_backend.service;

import lk.ijse.task_manager_app_backend.dto.impl.SignInDTO;
import lk.ijse.task_manager_app_backend.dto.impl.SignUpDTO;
import lk.ijse.task_manager_app_backend.secure.JWTAuthResponse;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthenticationService {
    JWTAuthResponse signUp(SignUpDTO signUpDTO);
    JWTAuthResponse signIn(SignInDTO signInDto);
    JWTAuthResponse refreshToken(String token);
    UserDetailsService userDetailsService();
}
