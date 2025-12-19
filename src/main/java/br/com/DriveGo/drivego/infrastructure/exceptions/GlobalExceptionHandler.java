package br.com.DriveGo.drivego.infrastructure.exceptions;

import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<@NonNull Map<String, Object>> handleNotFound(NotFoundException ex) {
        Map<String, Object> response = Map.of(
                "timestamp", LocalDateTime.now().toString(),
                "status", 404,
                "error", "Not Found",
                "message", ex.getMessage()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(DuplicateException.class)
    public ResponseEntity<@NonNull Map<String, Object>> handleDuplicate(DuplicateException ex) {
        Map<String, Object> response = Map.of(
                "timestamp", LocalDateTime.now().toString(),
                "status", 409,
                "error", "Conflict",
                "message", ex.getMessage()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<@NonNull Map<String, Object>> handleUnauthorizes(UnauthorizedException ex) {
        Map<String, Object> response = Map.of(
                "timestamp", LocalDateTime.now().toString(),
                "status", 401,
                "error", "Not authorized",
                "message", ex.getMessage()
        );
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<@NonNull Map<String, Object>> handleEndpointNotFound(NoHandlerFoundException ex) {
        Map<String, Object> response = Map.of(
                "timestamp", LocalDateTime.now().toString(),
                "status", 404,
                "error", "Endpoint Not Found",
                "message", "O endpoint solicitado não existe."
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(InvalidTokenException.class)
    public ResponseEntity<@NonNull Map<String, Object>> handleInvalideToken(InvalidTokenException ex) {
        Map<String, Object> response = Map.of(
                "timestamp", LocalDateTime.now().toString(),
                "status", 401,
                "error", "Endpoint Not Found",
                "message", "Código de verificação inválido"
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<@NonNull Map<String, Object>> handleInvalideCredentials(InvalidCredentialsException ex) {
        Map<String, Object> response = Map.of(
                "timestamp", LocalDateTime.now().toString(),
                "status", 401,
                "error", "Endpoint Not Found",
                "message", "Credenciais inválidas."
        );
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<@NonNull Map<String, Object>> handleInternalError(Exception ex) {
        Map<String, Object> response = Map.of(
                "timestamp", LocalDateTime.now().toString(),
                "status", 500,
                "error", "Internal Server Error",
                "message", ex.getMessage()
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationErrors(
            MethodArgumentNotValidException ex
    ) {

        Map<String, String> fieldErrors = new HashMap<>();

        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            fieldErrors.put(error.getField(), error.getDefaultMessage());
        }

        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("status", 400);
        response.put("error", "Bad Request");
        response.put("message", "Erro de validação");
        response.put("fields", fieldErrors);

        return ResponseEntity.badRequest().body(response);
    }
}