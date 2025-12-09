package br.com.DriveGo.drivego.core.entities;
import br.com.DriveGo.drivego.core.enums.Status;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class Vehicle {

    private UUID id;
    private String license_plate;
    private String vin;
    private  String brand;
    private String model;
    private Short year;
    private String category_id;
    private Status status;
    private Long mileage;
    private BigDecimal daily_price;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public Vehicle(UUID id, String license_plate, String vin, String brand, String model, Short year, String category_id, Status status, Long mileage, BigDecimal daily_price, LocalDateTime created_at, LocalDateTime updated_at) {
        this.id = id;
        this.license_plate = license_plate;
        this.vin = vin;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.category_id = category_id;
        this.status = status;
        this.mileage = mileage;
        this.daily_price = daily_price;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getLicense_plate() {
        return license_plate;
    }

    public void setLicense_plate(String license_plate) {
        this.license_plate = license_plate;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Short getYear() {
        return year;
    }

    public void setYear(Short year) {
        this.year = year;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getMileage() {
        return mileage;
    }

    public void setMileage(Long mileage) {
        this.mileage = mileage;
    }

    public BigDecimal getDaily_price() {
        return daily_price;
    }

    public void setDaily_price(BigDecimal daily_price) {
        this.daily_price = daily_price;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(id, vehicle.id) && Objects.equals(license_plate, vehicle.license_plate) && Objects.equals(vin, vehicle.vin) && Objects.equals(brand, vehicle.brand) && Objects.equals(model, vehicle.model) && Objects.equals(year, vehicle.year) && Objects.equals(category_id, vehicle.category_id) && status == vehicle.status && Objects.equals(mileage, vehicle.mileage) && Objects.equals(daily_price, vehicle.daily_price) && Objects.equals(created_at, vehicle.created_at) && Objects.equals(updated_at, vehicle.updated_at);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, license_plate, vin, brand, model, year, category_id, status, mileage, daily_price, created_at, updated_at);
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", license_plate='" + license_plate + '\'' +
                ", vin='" + vin + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", category_id='" + category_id + '\'' +
                ", status=" + status +
                ", mileage=" + mileage +
                ", daily_price=" + daily_price +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }
}
