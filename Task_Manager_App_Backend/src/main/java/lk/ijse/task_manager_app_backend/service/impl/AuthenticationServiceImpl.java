package lk.ijse.task_manager_app_backend.service.impl;

import lk.ijse.task_manager_app_backend.dao.UserDAO;
import lk.ijse.task_manager_app_backend.dto.impl.SignInDTO;
import lk.ijse.task_manager_app_backend.dto.impl.SignUpDTO;
import lk.ijse.task_manager_app_backend.exception.UserNotFoundException;
import lk.ijse.task_manager_app_backend.secure.JWTAuthResponse;
import lk.ijse.task_manager_app_backend.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    private final UserDAO userDAO;

    @Override
    public JWTAuthResponse signUp(SignUpDTO signUpDTO) {
        return null;
    }

    @Override
    public JWTAuthResponse signIn(SignInDTO signInDto) {
        return null;
    }

    @Override
    public JWTAuthResponse refreshToken(String token) {
        return null;
    }

    @Override
    public UserDetailsService userDetailsService() {
        return username -> (org.springframework.security.core.userdetails.UserDetails)
                userDAO.findByUsername(username)
                        .orElseThrow(()-> new UserNotFoundException("User Not Found"));
    }
}
