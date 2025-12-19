package br.com.DriveGo.drivego.infrastructure.dtos.responses;

import br.com.DriveGo.drivego.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {

    private String token;
    private User user;
}
