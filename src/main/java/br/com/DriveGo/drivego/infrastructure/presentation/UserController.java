package br.com.DriveGo.drivego.infrastructure.presentation;

import br.com.DriveGo.drivego.core.entities.User;
import br.com.DriveGo.drivego.core.usecases.users.CreateUserUseCase;
import br.com.DriveGo.drivego.infrastructure.dtos.requests.UserRegisterRequest;
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

    public UserController(CreateUserUseCase createUserUseCase, JwtTokenService jwtTokenService) {
        this.createUserUseCase = createUserUseCase;
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
}
