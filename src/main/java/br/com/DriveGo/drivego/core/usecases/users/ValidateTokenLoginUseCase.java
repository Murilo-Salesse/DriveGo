package br.com.DriveGo.drivego.core.usecases.users;

import br.com.DriveGo.drivego.core.usecases.users.dtos.VerificationLoginResult;

public interface ValidateTokenLoginUseCase {

    VerificationLoginResult execute(String email, String verificationCode);
}
