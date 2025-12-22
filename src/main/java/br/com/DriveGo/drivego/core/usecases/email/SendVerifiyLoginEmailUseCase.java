package br.com.DriveGo.drivego.core.usecases.email;

import br.com.DriveGo.drivego.core.gateways.EmailGateway;

public class SendVerifiyLoginEmailUseCase {

    private final EmailGateway emailGateway;

    public SendVerifiyLoginEmailUseCase(EmailGateway emailGateway) {
        this.emailGateway = emailGateway;
    }

    public void execute(String email, String code) {
        String subject = "🔐 Verificação de Conta - DriveGo";
        String body = buildHtmlEmail(code);

        emailGateway.sendEmail(email, subject, body);
    }

    private String buildHtmlEmail(String code) {
        return """
        <!DOCTYPE html>
        <html lang="pt-BR">
        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
        </head>
        <body style="font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; background-color: #f4f7fa; margin: 0; padding: 0;">
            <div style="max-width: 600px; margin: 40px auto; background-color: #ffffff; border-radius: 12px; overflow: hidden; box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);">
                <div style="background: linear-gradient(135deg, #667eea 0%%, #764ba2 100%%); padding: 40px 20px; text-align: center; color: white;">
                    <div style="font-size: 24px; font-weight: bold; margin-bottom: 10px;">🚗 DriveGo</div>
                    <h1 style="margin: 0; font-size: 28px; font-weight: 600;">Verificação de Login</h1>
                </div>

                <div style="padding: 40px 30px; color: #333333;">
                    <p style="font-size: 18px; margin-bottom: 20px; color: #555555;">Olá! 👋</p>

                    <p style="font-size: 16px; line-height: 1.6; color: #666666; margin-bottom: 30px;">
                        Recebemos uma solicitação de login na sua conta do <strong>DriveGo</strong>.<br>
                        Para continuar e acessar sua conta com segurança, valide o token abaixo.
                    </p>

                    <div style="background-color: #f8f9fa; border: 2px dashed #667eea; border-radius: 8px; padding: 30px; text-align: center; margin: 30px 0;">
                        <div style="font-size: 14px; color: #888888; text-transform: uppercase; letter-spacing: 1px; margin-bottom: 10px;">
                            Token de acesso
                        </div>
                        <div style="font-size: 36px; font-weight: bold; color: #667eea; letter-spacing: 8px; font-family: 'Courier New', monospace;">
                            %s
                        </div>
                    </div>

                    <div style="background-color: #fff3cd; border-left: 4px solid #ffc107; padding: 15px; margin: 25px 0; border-radius: 4px;">
                        <p style="font-size: 14px; color: #856404; margin: 0;">
                            <span style="display: inline-block; margin-right: 8px;">⏱️</span>
                            <strong>Atenção:</strong> Este token expira em <strong>5 minutos</strong>.
                        </p>
                    </div>

                    <div style="height: 1px; background-color: #e9ecef; margin: 25px 0;"></div>

                    <div style="background-color: #e7f3ff; border-left: 4px solid #2196F3; padding: 15px; margin: 20px 0; border-radius: 4px;">
                        <p style="font-size: 14px; color: #0c5460; margin: 0;">
                            <strong>🔒 Segurança:</strong> Se você não tentou realizar o login,
                            ignore este e-mail. Nenhuma ação será tomada.
                        </p>
                    </div>
                </div>

                <div style="background-color: #f8f9fa; padding: 30px; text-align: center; border-top: 1px solid #e9ecef;">
                    <p style="font-size: 13px; color: #888888; margin: 5px 0;">
                        <strong>DriveGo</strong> - Sua liberdade sobre rodas
                    </p>
                    <p style="font-size: 13px; color: #888888; margin: 5px 0;">
                        Este é um e-mail automático, por favor não responda.
                    </p>
                    <p style="font-size: 13px; color: #888888; margin-top: 15px;">
                        © 2024 DriveGo. Todos os direitos reservados.
                    </p>
                </div>
            </div>
        </body>
        </html>
    """.formatted(code);
    }
}
