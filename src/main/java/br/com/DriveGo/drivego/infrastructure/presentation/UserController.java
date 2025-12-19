package br.com.DriveGo.drivego.infrastructure.presentation;

import br.com.DriveGo.drivego.core.entities.User;
import br.com.DriveGo.drivego.core.usecases.users.CreateUserUseCase;
import br.com.DriveGo.drivego.core.usecases.users.LoginUserUseCase;
import br.com.DriveGo.drivego.core.usecases.users.ValidateTokenUseCase;
import br.com.DriveGo.drivego.infrastructure.dtos.requests.LoginRequest;
import br.com.DriveGo.drivego.infrastructure.dtos.requests.UserRegisterRequest;
import br.com.DriveGo.drivego.infrastructure.dtos.requests.VerifyTokenRequest;
import br.com.DriveGo.drivego.infrastructure.dtos.responses.LoginResponse;
import br.com.DriveGo.drivego.infrastructure.dtos.responses.VerificationResponse;
import br.com.DriveGo.drivego.infrastructure.mappers.UserMapper;
import br.com.DriveGo.drivego.infrastructure.security.JwtTokenService;
import jakarta.validation.Valid;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final CreateUserUseCase createUserUseCase;
    private final LoginUserUseCase loginUserUseCase;
    private final ValidateTokenUseCase validateTokenUseCase;

    public UserController(CreateUserUseCase createUserUseCase, JwtTokenService jwtTokenService, LoginUserUseCase loginUserUseCase, ValidateTokenUseCase validateTokenUseCase) {
        this.createUserUseCase = createUserUseCase;
        this.loginUserUseCase = loginUserUseCase;
        this.validateTokenUseCase = validateTokenUseCase;
    }

    @PostMapping("/register")
    public ResponseEntity<@NonNull Map<String, Object>> registerUser(@Valid @RequestBody
                                                                         UserRegisterRequest request) {
        User savedUser = createUserUseCase.execute(
                UserMapper.toDomain(request));

        Map<String, Object> data = Map.of(
                "message", "Usuário criado com sucesso.",
                "user", UserMapper.toResponse(savedUser)
        );
        Map<String, Object> response = Map.of("data", data);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/verify")
    public ResponseEntity<Map<String, Object>> verifyToken(
            @Valid @RequestBody VerifyTokenRequest request) {

        VerificationResponse response = validateTokenUseCase.execute(
                request.getEmail(),
                request.getCode()
        );

        Map<String, Object> data = Map.of(
                "message", "Email verificado com sucesso",
                "user", UserMapper.toResponse(response.getUser())
        );

        return ResponseEntity.ok(Map.of("data", data));
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(
            @Valid @RequestBody LoginRequest request) {

        LoginResponse response = loginUserUseCase.execute(
                request.getEmail(),
                request.getPassword()
        );

        Map<String, Object> data = Map.of(
                "message", "Login realizado com sucesso",
                "token", response.getToken(),
                "user", UserMapper.toResponse(response.getUser())
        );

        return ResponseEntity.ok(Map.of("data", data));
    }
}
