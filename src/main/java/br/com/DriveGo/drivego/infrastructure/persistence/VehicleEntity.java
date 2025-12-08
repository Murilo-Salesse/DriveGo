package br.com.DriveGo.drivego.infrastructure.persistence;

import br.com.DriveGo.drivego.core.enums.Roles;
import br.com.DriveGo.drivego.core.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "vehicles")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class VehicleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @NotBlank
    private String license_plate;

    @NotBlank
    private String vin;

    @NotBlank
    private String brand;

    @NotBlank
    private String model;

    @NotNull
    private Short year;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "vehicle_status")
    private Status vehicle_status = Status.AVAILABLE;

    @NotNull
    private Long mileage;

    @NotNull
    private BigDecimal daily_price;

    @CreationTimestamp
    private LocalDateTime created_at;

    @UpdateTimestamp
    private LocalDateTime updated_at;

    @OneToMany(mappedBy = "vehicle")
    private List<VehiclePhotosEntity> photos;

    @OneToMany(mappedBy = "vehicle")
    private List<ReservationEntity> reservations;
}
