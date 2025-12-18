package br.com.DriveGo.drivego.core.usecases.email;

import br.com.DriveGo.drivego.core.gateways.EmailGateway;

public class SendVerificationEmailUseCase {

    private final EmailGateway emailGateway;

    public SendVerificationEmailUseCase(EmailGateway emailGateway) {
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
                    <style>
                        body {
                            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
                            background-color: #f4f7fa;
                            margin: 0;
                            padding: 0;
                        }
                        .container {
                            max-width: 600px;
                            margin: 40px auto;
                            background-color: #ffffff;
                            border-radius: 12px;
                            overflow: hidden;
                            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
                        }
                        .header {
                            background: linear-gradient(135deg, #667eea 0%%, #764ba2 100%%);
                            padding: 40px 20px;
                            text-align: center;
                            color: white;
                        }
                        .header h1 {
                            margin: 0;
                            font-size: 28px;
                            font-weight: 600;
                        }
                        .content {
                            padding: 40px 30px;
                            color: #333333;
                        }
                        .greeting {
                            font-size: 18px;
                            margin-bottom: 20px;
                            color: #555555;
                        }
                        .message {
                            font-size: 16px;
                            line-height: 1.6;
                            color: #666666;
                            margin-bottom: 30px;
                        }
                        .code-container {
                            background-color: #f8f9fa;
                            border: 2px dashed #667eea;
                            border-radius: 8px;
                            padding: 30px;
                            text-align: center;
                            margin: 30px 0;
                        }
                        .code-label {
                            font-size: 14px;
                            color: #888888;
                            text-transform: uppercase;
                            letter-spacing: 1px;
                            margin-bottom: 10px;
                        }
                        .code {
                            font-size: 36px;
                            font-weight: bold;
                            color: #667eea;
                            letter-spacing: 8px;
                            font-family: 'Courier New', monospace;
                        }
                        .warning {
                            background-color: #fff3cd;
                            border-left: 4px solid #ffc107;
                            padding: 15px;
                            margin: 25px 0;
                            border-radius: 4px;
                        }
                        .warning-icon {
                            display: inline-block;
                            margin-right: 8px;
                        }
                        .warning-text {
                            font-size: 14px;
                            color: #856404;
                            margin: 0;
                        }
                        .footer {
                            background-color: #f8f9fa;
                            padding: 30px;
                            text-align: center;
                            border-top: 1px solid #e9ecef;
                        }
                        .footer-text {
                            font-size: 13px;
                            color: #888888;
                            margin: 5px 0;
                        }
                        .logo {
                            font-size: 24px;
                            font-weight: bold;
                            margin-bottom: 10px;
                        }
                        .divider {
                            height: 1px;
                            background-color: #e9ecef;
                            margin: 25px 0;
                        }
                        .info-box {
                            background-color: #e7f3ff;
                            border-left: 4px solid #2196F3;
                            padding: 15px;
                            margin: 20px 0;
                            border-radius: 4px;
                        }
                        .info-text {
                            font-size: 14px;
                            color: #0c5460;
                            margin: 0;
                        }
                    </style>
                </head>
                <body>
                    <div class="container">
                        <div class="header">
                            <div class="logo">🚗 DriveGo</div>
                            <h1>Verificação de Conta</h1>
                        </div>
                       \s
                        <div class="content">
                            <p class="greeting">Olá! 👋</p>
                           \s
                            <p class="message">
                                Obrigado por se cadastrar no <strong>DriveGo</strong>!\s
                                Para completar seu cadastro e garantir a segurança da sua conta,\s
                                precisamos verificar seu endereço de e-mail.
                            </p>
                           \s
                            <div class="code-container">
                                <div class="code-label">Seu código de verificação</div>
                                <div class="code">%s</div>
                            </div>
                           \s
                            <div class="warning">
                                <span class="warning-icon">⏱️</span>
                                <p class="warning-text">
                                    <strong>Atenção:</strong> Este código expira em <strong>5 minutos</strong>.
                                </p>
                            </div>
                           \s
                            <div class="divider"></div>
                           \s
                            <div class="info-box">
                                <p class="info-text">
                                    <strong>🔒 Segurança:</strong> Se você não solicitou este código,\s
                                    por favor ignore este e-mail. Sua conta permanecerá segura.
                                </p>
                            </div>
                        </div>
                       \s
                        <div class="footer">
                            <p class="footer-text"><strong>DriveGo</strong> - Sua liberdade sobre rodas</p>
                            <p class="footer-text">Este é um e-mail automático, por favor não responda.</p>
                            <p class="footer-text" style="margin-top: 15px;">
                                © 2024 DriveGo. Todos os direitos reservados.
                            </p>
                        </div>
                    </div>
                </body>
                </html>
               \s""".formatted(code);
    }
}
