package lk.ijse.task_manager_app_backend.controller;

import lk.ijse.task_manager_app_backend.dto.impl.SignInDTO;
import lk.ijse.task_manager_app_backend.dto.impl.SignUpDTO;
import lk.ijse.task_manager_app_backend.exception.AlreadyExistsException;
import lk.ijse.task_manager_app_backend.secure.JWTAuthResponse;
import lk.ijse.task_manager_app_backend.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthUserController {
    private final AuthenticationService authenticationService;

    @PostMapping("/signUp")
    public ResponseEntity<JWTAuthResponse> signUp(@RequestBody SignUpDTO signUpDTO) {
        try {
            return ResponseEntity.ok(authenticationService.signUp(signUpDTO));
        } catch (AlreadyExistsException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/signIn")
    public ResponseEntity<JWTAuthResponse> signIn(@RequestBody SignInDTO signInDTO) {
        return ResponseEntity.ok(authenticationService.signIn(signInDTO));
    }

    @PostMapping("/refresh/{token}")
    public ResponseEntity<JWTAuthResponse> refreshToken(@PathVariable("token") String token) {
        return ResponseEntity.ok(authenticationService.refreshToken(token));
    }
}
