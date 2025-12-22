package br.com.DriveGo.drivego.core.usecases.users;
import br.com.DriveGo.drivego.core.usecases.users.dtos.LoginResult;

public interface LoginUserUseCase {
    LoginResult execute(String email, String password);
}
