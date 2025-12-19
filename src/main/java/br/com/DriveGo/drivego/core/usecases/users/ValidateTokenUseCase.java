package br.com.DriveGo.drivego.core.usecases.users;

import br.com.DriveGo.drivego.infrastructure.dtos.responses.VerificationResponse;

public interface ValidateTokenUseCase {

    VerificationResponse execute(String email, String verificationCode);
}
