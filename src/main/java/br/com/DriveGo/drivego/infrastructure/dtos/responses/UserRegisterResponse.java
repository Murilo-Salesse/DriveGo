package br.com.DriveGo.drivego.infrastructure.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRegisterResponse {

    UUID id;
    String email;
    String fullName;
    String phone;
}
