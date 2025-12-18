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
@NoArgsConstructor
@AllArgsConstructor
public class VehicleRequest {

    @NotBlank
    private String licensePlate;
    @NotBlank
    private String vin;

    @NotBlank
    private String brand;

    @NotBlank
    private String model;

    @NotNull
    private Short year;

    @NotNull
    private BigDecimal dailyPrice;

    @NotNull
    private Long mileage;

    @NotNull
    private UUID categoryId;
}
