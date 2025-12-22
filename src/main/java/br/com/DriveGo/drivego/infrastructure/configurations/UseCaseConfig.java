package br.com.DriveGo.drivego.infrastructure.configurations;

import br.com.DriveGo.drivego.core.gateways.EmailGateway;
import br.com.DriveGo.drivego.core.usecases.email.SendVerificationEmailUseCase;
import br.com.DriveGo.drivego.core.usecases.email.SendVerifiyLoginEmailUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public SendVerificationEmailUseCase sendVerificationEmailUseCase(
            EmailGateway emailGateway
    ) {
        return new SendVerificationEmailUseCase(emailGateway);
    }

    @Bean
    SendVerifiyLoginEmailUseCase sendVerifiyLoginEmailUseCase(
            EmailGateway emailGateway
    ) {
        return  new SendVerifiyLoginEmailUseCase(emailGateway);
    }
}
