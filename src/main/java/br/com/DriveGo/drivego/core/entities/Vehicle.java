package br.com.DriveGo.drivego.core.entities;
import br.com.DriveGo.drivego.core.enums.Status;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Vehicle {

    String id;
    String license_plate;
    String vin;
    String brand;
    String model;
    Short year;
    String category_id;
    Status status;
    Long mileage;
    BigDecimal daily_price;
    LocalDateTime created_at;
    LocalDateTime updated_at;
}
