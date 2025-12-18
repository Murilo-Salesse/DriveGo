package br.com.DriveGo.drivego.infrastructure.configurations;

import br.com.DriveGo.drivego.core.entities.User;
import br.com.DriveGo.drivego.core.enums.Roles;
import br.com.DriveGo.drivego.core.enums.UserStatus;
import br.com.DriveGo.drivego.infrastructure.mappers.UserEntityMapper;
import br.com.DriveGo.drivego.infrastructure.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Configuration
public class AdminInitializer {

    @Value("${app.admin.email:admin@drivego.com}")
    private String adminEmail;

    @Value("${app.admin.password:admin123}")
    private String adminPassword;

    @Value("${app.admin.initialize:true}")
    private boolean initializeAdmin;

    @Bean
    public CommandLineRunner initializeAdminUser(UserRepository userRepository,
                                                 PasswordEncoder passwordEncoder) {
        return args -> {
            if (!initializeAdmin) {
                return;
            }

            // Verifica se já existe um admin
            if (userRepository.findByEmail(adminEmail).isEmpty()) {
                User adminUser = new User();
                adminUser.setEmail(adminEmail);
                adminUser.setPasswordHash(passwordEncoder.encode(adminPassword));
                adminUser.setFullName("Administrador");
                adminUser.setRole(Roles.ADMIN);
                adminUser.setStatus(UserStatus.ACTIVE);
                adminUser.setCreatedAt(LocalDateTime.now());
                adminUser.setReservationsIds(new ArrayList<>());

                userRepository.save(UserEntityMapper.toEntity(adminUser));

                System.out.println("====================================");
                System.out.println("Admin user created successfully!");
                System.out.println("Email: " + adminEmail);
                System.out.println("Password: " + adminPassword);
                System.out.println("====================================");
            }
        };
    }
}