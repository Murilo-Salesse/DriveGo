package br.com.DriveGo.drivego.infrastructure.persistence;

import br.com.DriveGo.drivego.core.enums.PaymentStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "payments")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private VehicleEntity vehicle;

    @NotNull
    private Double amount;

    @NotBlank
    private String method;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "payment_status")
    private PaymentStatus payment_status = PaymentStatus.PENDING;

    @NotBlank
    private String provider_reference;

    @CreationTimestamp
    private LocalDateTime created_at;
}
