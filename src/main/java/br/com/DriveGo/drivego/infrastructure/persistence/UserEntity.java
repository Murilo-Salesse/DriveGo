package br.com.DriveGo.drivego.infrastructure.persistence;

import br.com.DriveGo.drivego.core.enums.Roles;
import br.com.DriveGo.drivego.core.enums.UserStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String email;

    private String passwordHash;

    private String googleId;

    @Column(nullable = false)
    private String fullName;

    @Enumerated(EnumType.STRING)
    private Roles role = Roles.CLIENT;

    @Enumerated(EnumType.STRING)
    private UserStatus status = UserStatus.PENDING;

    private String phone;

    private LocalDateTime lastLoginAt;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "user")
    private List<ReservationEntity> reservations;
}
