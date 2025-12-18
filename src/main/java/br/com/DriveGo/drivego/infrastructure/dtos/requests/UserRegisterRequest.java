package br.com.DriveGo.drivego.infrastructure.dtos.requests;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterRequest {

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min = 4, message = "Senha deve ter no mínimo 4 caracteres")
    private String password;

    @NotBlank
    private String fullName;

    private String phone;
}
