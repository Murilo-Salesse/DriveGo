package br.com.DriveGo.drivego.core.entities;
import br.com.DriveGo.drivego.core.enums.Status;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class Vehicle {

    private UUID id;
    private String license_plate;
    private String vin;
    private String brand;
    private String model;
    private Short year;
    private UUID category_id;
    private Status status;
    private Long mileage;
    private BigDecimal daily_price;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    private List<UUID> photoIds = new ArrayList<>();
    private List<UUID> reservationIds = new ArrayList<>();
    private List<UUID> maintenanceRecordIds = new ArrayList<>();
    private List<UUID> damageIds = new ArrayList<>();

    public Vehicle(String license_plate, String vin, String brand, String model,
                   Short year, UUID category_id, BigDecimal daily_price) {
        this.license_plate = license_plate;
        this.vin = vin;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.category_id = category_id;
        this.daily_price = daily_price;
    }

    public Vehicle(UUID id, String license_plate, String vin, String brand, String model, Short year, UUID category_id, Status status, Long mileage, BigDecimal daily_price, LocalDateTime created_at, LocalDateTime updated_at, List<UUID> photoIds, List<UUID> reservationIds, List<UUID> maintenanceRecordIds, List<UUID> damageIds) {
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
        this.photoIds = photoIds;
        this.reservationIds = reservationIds;
        this.maintenanceRecordIds = maintenanceRecordIds;
        this.damageIds = damageIds;
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

    public UUID getCategory_id() {
        return category_id;
    }

    public void setCategory_id(UUID category_id) {
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

    public List<UUID> getPhotoIds() {
        return photoIds;
    }

    public void setPhotoIds(List<UUID> photoIds) {
        this.photoIds = photoIds;
    }

    public List<UUID> getReservationIds() {
        return reservationIds;
    }

    public void setReservationIds(List<UUID> reservationIds) {
        this.reservationIds = reservationIds;
    }

    public List<UUID> getMaintenanceRecordIds() {
        return maintenanceRecordIds;
    }

    public void setMaintenanceRecordIds(List<UUID> maintenanceRecordIds) {
        this.maintenanceRecordIds = maintenanceRecordIds;
    }

    public List<UUID> getDamageIds() {
        return damageIds;
    }

    public void setDamageIds(List<UUID> damageIds) {
        this.damageIds = damageIds;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Vehicle vehicle = (Vehicle) o;
        return Objects.equals(id, vehicle.id) && Objects.equals(license_plate, vehicle.license_plate) && Objects.equals(vin, vehicle.vin) && Objects.equals(brand, vehicle.brand) && Objects.equals(model, vehicle.model) && Objects.equals(year, vehicle.year) && Objects.equals(category_id, vehicle.category_id) && status == vehicle.status && Objects.equals(mileage, vehicle.mileage) && Objects.equals(daily_price, vehicle.daily_price) && Objects.equals(created_at, vehicle.created_at) && Objects.equals(updated_at, vehicle.updated_at) && Objects.equals(photoIds, vehicle.photoIds) && Objects.equals(reservationIds, vehicle.reservationIds) && Objects.equals(maintenanceRecordIds, vehicle.maintenanceRecordIds) && Objects.equals(damageIds, vehicle.damageIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, license_plate, vin, brand, model, year, category_id, status, mileage, daily_price, created_at, updated_at, photoIds, reservationIds, maintenanceRecordIds, damageIds);
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
                ", category_id=" + category_id +
                ", status=" + status +
                ", mileage=" + mileage +
                ", daily_price=" + daily_price +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                ", photoIds=" + photoIds +
                ", reservationIds=" + reservationIds +
                ", maintenanceRecordIds=" + maintenanceRecordIds +
                ", damageIds=" + damageIds +
                '}';
    }
}
