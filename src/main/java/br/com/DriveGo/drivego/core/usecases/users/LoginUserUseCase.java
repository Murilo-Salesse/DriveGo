package br.com.DriveGo.drivego.core.usecases.users;

import br.com.DriveGo.drivego.infrastructure.dtos.responses.LoginResponse;

public interface LoginUserUseCase {

    LoginResponse execute(String email, String password);
}
