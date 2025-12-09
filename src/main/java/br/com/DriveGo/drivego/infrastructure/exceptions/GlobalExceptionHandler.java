package br.com.DriveGo.drivego.infrastructure.exceptions;


import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.time.LocalDateTime;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<@NonNull Map<String, Object>> handleNotFound(NotFoundException ex) {
        Map<String, Object> response = Map.of(
                "timestamp", LocalDateTime.now().toString(),
                "status", 404,
                "error", "OPS, ID não encontrado",
                "message", ex.getMessage()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<@NonNull Map<String, Object>> handleEndpointNotFound(Exception ex) {
        Map<String, Object> response = Map.of(
                "timestamp", LocalDateTime.now().toString(),
                "status", 404,
                "error", "OPS, página não encontrada",
                "message", "O endpoint solicitado não existe."
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<@NonNull Map<String, Object>> handleInternalError(Exception ex) {
        Map<String, Object> response = Map.of(
                "timestamp", LocalDateTime.now().toString(),
                "status", 500,
                "error", "OPS, algo deu errado no servidor",
                "message", ex.getMessage()
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}