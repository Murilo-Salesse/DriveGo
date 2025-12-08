package br.com.DriveGo.drivego.infrastructure.persistence;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "maintenance_records")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class MaintenanceRecordsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private VehicleEntity vehicle;

    @NotBlank
    private String description;

    @NotBlank
    private Double cost;

    private LocalDateTime date;
}
