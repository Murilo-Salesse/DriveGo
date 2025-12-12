package br.com.DriveGo.drivego.infrastructure.persistence;

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
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "vehicles")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class VehicleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(columnDefinition = "uuid")
    private UUID id;

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
    @Column(name = "vehicle_status")
    private Status vehicle_status = Status.AVAILABLE;

    @NotNull
    private Long mileage;

    @NotNull
    private BigDecimal daily_price;

    @CreationTimestamp
    private LocalDateTime created_at;

    @UpdateTimestamp
    private LocalDateTime updated_at;

    // usar new arraylist para quando não existir nada no array poder vir como null e não dar erro
    @OneToMany(mappedBy = "vehicle")
    private List<VehiclePhotosEntity> photos = new ArrayList<>();

    @OneToMany(mappedBy = "vehicle")
    private List<ReservationEntity> reservations = new ArrayList<>();

    @OneToMany(mappedBy = "vehicle")
    private List<MaintenanceRecordsEntity> maintenanceRecords = new ArrayList<>();

    @OneToMany(mappedBy = "vehicle")
    private List<DamageEntity> damages = new ArrayList<>();
}
