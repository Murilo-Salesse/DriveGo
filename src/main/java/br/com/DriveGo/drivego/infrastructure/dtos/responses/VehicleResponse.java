package br.com.DriveGo.drivego.infrastructure.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehicleResponse {

    private UUID id;
    private String license_plate;
    private String vin;
    private String brand;
    private String model;
    private Short year;

    private UUID category_id;

    private String status;
    private Long mileage;
    private BigDecimal daily_price;

    private LocalDateTime created_at;
    private LocalDateTime updated_at;
}
