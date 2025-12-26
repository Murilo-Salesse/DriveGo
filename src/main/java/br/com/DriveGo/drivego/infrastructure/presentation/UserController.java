package br.com.DriveGo.drivego.infrastructure.presentation;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.DriveGo.drivego.core.entities.User;
import br.com.DriveGo.drivego.core.usecases.users.CreateUserUseCase;
import br.com.DriveGo.drivego.core.usecases.users.LoginUserUseCase;
import br.com.DriveGo.drivego.core.usecases.users.UpdateUserUseCase;
import br.com.DriveGo.drivego.core.usecases.users.ValidateTokenLoginUseCase;
import br.com.DriveGo.drivego.core.usecases.users.ValidateTokenUseCase;
import br.com.DriveGo.drivego.core.usecases.users.dtos.LoginResult;
import br.com.DriveGo.drivego.core.usecases.users.dtos.VerificationLoginResult;
import br.com.DriveGo.drivego.core.usecases.users.dtos.VerificationResult;
import br.com.DriveGo.drivego.infrastructure.dtos.requests.LoginRequest;
import br.com.DriveGo.drivego.infrastructure.dtos.requests.UserRegisterRequest;
import br.com.DriveGo.drivego.infrastructure.dtos.requests.UserUpdateRequest;
import br.com.DriveGo.drivego.infrastructure.dtos.requests.VerifyTokenLoginRequest;
import br.com.DriveGo.drivego.infrastructure.dtos.requests.VerifyTokenRequest;
import br.com.DriveGo.drivego.infrastructure.mappers.UserMapper;
import jakarta.validation.Valid;
import lombok.NonNull;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final CreateUserUseCase createUserUseCase;
    private final LoginUserUseCase loginUserUseCase;
    private final ValidateTokenUseCase validateTokenUseCase;
    private final ValidateTokenLoginUseCase validateTokenLoginUseCase;
    private final UpdateUserUseCase updateUserUseCase;

    public UserController(CreateUserUseCase createUserUseCase,
                          LoginUserUseCase loginUserUseCase,
                          ValidateTokenUseCase validateTokenUseCase,
                          ValidateTokenLoginUseCase validateTokenLoginUseCase,
                          UpdateUserUseCase updateUserUseCase) {
        this.createUserUseCase = createUserUseCase;
        this.loginUserUseCase = loginUserUseCase;
        this.validateTokenUseCase = validateTokenUseCase;
        this.validateTokenLoginUseCase = validateTokenLoginUseCase;
        this.updateUserUseCase = updateUserUseCase;
    }

    @PostMapping("/register")
    public ResponseEntity<@NonNull Map<String, Object>> registerUser(@Valid @RequestBody
                                                                         UserRegisterRequest request) {
        User savedUser = createUserUseCase.execute(
                UserMapper.toDomain(request));

        Map<String, Object> data = Map.of(
                "message", "Cadastro realizado. Verifique seu email para ativar a conta.",
                "user", UserMapper.toSimpleResponse(savedUser)
        );
        Map<String, Object> response = Map.of("data", data);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PostMapping("/verify")
    public ResponseEntity<Map<String, Object>> verifyToken(
            @Valid @RequestBody VerifyTokenRequest request) {

        VerificationResult response = validateTokenUseCase.execute(
                request.getEmail(),
                request.getCode()
        );

        Map<String, Object> data = Map.of(
                "message", "Email verificado com sucesso",
                "user", UserMapper.toSimpleResponse(response.getUser())
        );

        return ResponseEntity.ok(Map.of("data", data));
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(
            @Valid @RequestBody LoginRequest request) {

        LoginResult result = loginUserUseCase.execute(
                request.getEmail(),
                request.getPassword()
        );

        Map<String, Object> data = Map.of(
                "message", "Código de verificação enviado para seu email",
                "user", UserMapper.toSimpleResponse(result.getUser())
        );

        return ResponseEntity.ok(Map.of("data", data));
    }

    @PostMapping("/verifyLogin")
    public ResponseEntity<Map<String, Object>> verifyLoginToken(
            @Valid @RequestBody VerifyTokenLoginRequest request) {

        VerificationLoginResult response = validateTokenLoginUseCase.execute(
                request.getEmail(),
                request.getCode()
        );

        Map<String, Object> data = Map.of(
                "message", "Token verificado com sucesso",
                "user", UserMapper.toResponse(response.getUser()),
                "token", response.getToken()
        );

        return ResponseEntity.ok(Map.of("data", data));
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<Map<String, Object>> updateUser(
            @PathVariable("id") java.util.UUID id,
            @Valid @RequestBody UserUpdateRequest request) {

        User updatedUser = updateUserUseCase.execute(id, UserMapper.toDomain(request));

        Map<String, Object> data = Map.of(
                "message", "Usuário atualizado com sucesso",
                "user", UserMapper.toResponse(updatedUser)
        );

        return ResponseEntity.ok(Map.of("data", data));
    }
}
