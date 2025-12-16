package br.com.DriveGo.drivego.infrastructure.dtos.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehicleRequest {

    @NotBlank
    private String licensePlate;  // Muda de "plate" para "licensePlate"

    @NotBlank
    private String vin;

    @NotBlank
    private String brand;

    @NotBlank
    private String model;

    @NotNull
    private Short year;  // Muda de Integer para Short

    @NotNull
    private BigDecimal dailyPrice;  // Muda de Double para BigDecimal e nome para camelCase

    @NotNull
    private Long mileage;

    @NotNull
    private UUID categoryId;  // Muda de category_id para categoryId
}
