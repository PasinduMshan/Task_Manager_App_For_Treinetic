package lk.ijse.task_manager_app_backend.service.impl;

import lk.ijse.task_manager_app_backend.dao.UserDAO;
import lk.ijse.task_manager_app_backend.exception.UserNotFoundException;
import lk.ijse.task_manager_app_backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    @Autowired
    private final UserDAO userDAO;

    @Override
    public UserDetailsService userDetailsService() {
        return userName ->
                userDAO.findByUsername(userName)
                        .orElseThrow(()-> new UserNotFoundException("User Not Found"));
    }
}
