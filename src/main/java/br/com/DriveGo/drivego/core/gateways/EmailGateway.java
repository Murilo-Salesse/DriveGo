package br.com.DriveGo.drivego.core.gateways;

public interface EmailGateway {

    void sendEmail(
            String to,
            String subject,
            String body
    );
}