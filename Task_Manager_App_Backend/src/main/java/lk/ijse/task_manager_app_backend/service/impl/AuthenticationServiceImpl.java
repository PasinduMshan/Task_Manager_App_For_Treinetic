package lk.ijse.task_manager_app_backend.service.impl;

import lk.ijse.task_manager_app_backend.dao.UserDAO;
import lk.ijse.task_manager_app_backend.dto.impl.SignInDTO;
import lk.ijse.task_manager_app_backend.dto.impl.SignUpDTO;
import lk.ijse.task_manager_app_backend.entity.User;
import lk.ijse.task_manager_app_backend.exception.AlreadyExistsException;
import lk.ijse.task_manager_app_backend.exception.UserNotFoundException;
import lk.ijse.task_manager_app_backend.secure.JWTAuthResponse;
import lk.ijse.task_manager_app_backend.service.AuthenticationService;
import lk.ijse.task_manager_app_backend.service.JWTService;
import lk.ijse.task_manager_app_backend.util.Mapping;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    private final UserDAO userDAO;
    @Autowired
    private final Mapping mapping;

    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JWTService jwtService;

    @Override
    public JWTAuthResponse signUp(SignUpDTO signUpDTO) {
        signUpDTO.setPassword(passwordEncoder.encode(signUpDTO.getPassword()));
        User user = mapping.toUserEntity(signUpDTO);
        if (userDAO.existsById(user.getId())) throw new AlreadyExistsException("user already exists");
        userDAO.save(user);
        var jwtToken = jwtService.generateToken(user);
        return JWTAuthResponse.builder().token(jwtToken).build();
    }

    @Override
    public JWTAuthResponse signIn(SignInDTO signInDto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInDto.getUsername(), signInDto.getPassword())
        );
        User userEntity = userDAO.findByUsername(signInDto.getUsername())
                .orElseThrow(() -> new UserNotFoundException("user not found"));
        var jwtToken = jwtService.generateToken(userEntity);
        System.out.println(jwtToken);
        return JWTAuthResponse.builder().token(jwtToken).build();
    }

    @Override
    public JWTAuthResponse refreshToken(String token) {
        String userName = jwtService.extractUserName(token);
        User user = userDAO.findByUsername(userName)
                .orElseThrow(() -> new UserNotFoundException("user not found"));
        var jwtToken = jwtService.generateToken(user);
        System.out.println(jwtToken);
        return JWTAuthResponse.builder().token(jwtToken).build();
    }
}
