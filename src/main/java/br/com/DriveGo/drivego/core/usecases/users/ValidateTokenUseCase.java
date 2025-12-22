package br.com.DriveGo.drivego.core.usecases.users;
import br.com.DriveGo.drivego.core.usecases.users.dtos.VerificationResult;

public interface ValidateTokenUseCase {

    VerificationResult execute(String email, String verificationCode);
}
