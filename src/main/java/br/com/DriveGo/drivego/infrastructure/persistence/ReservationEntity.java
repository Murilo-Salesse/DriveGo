package br.com.DriveGo.drivego.infrastructure.persistence;

import br.com.DriveGo.drivego.core.enums.ReservationStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "reservations")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReservationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    String id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private VehicleEntity vehicle;

    @NotNull
    private LocalDateTime start_datetime;

    @NotNull
    private LocalDateTime end_datetime;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "reservation_status")
    private ReservationStatus reservation_status = ReservationStatus.PENDING;

    @NotNull
    private Double total_amount;

    @NotNull
    private Double deposit_amount;

    @CreationTimestamp
    private LocalDateTime created_at;

    @UpdateTimestamp
    private LocalDateTime updated_at;

    @OneToMany(mappedBy = "reservation")
    private List<DamageEntity> damages;
}
