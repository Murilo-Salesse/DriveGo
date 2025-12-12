package br.com.DriveGo.drivego.core.entities;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class MaintenanceRecord {

    private UUID id;
    private UUID vehicle_id;
    private String description;
    private Double cost;
    private LocalDateTime date;

    public MaintenanceRecord(UUID id, UUID vehicle_id, String description, Double cost, LocalDateTime date) {
        this.id = id;
        this.vehicle_id = vehicle_id;
        this.description = description;
        this.cost = cost;
        this.date = date;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(UUID vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MaintenanceRecord that = (MaintenanceRecord) o;
        return Objects.equals(id, that.id) && Objects.equals(vehicle_id, that.vehicle_id) && Objects.equals(description, that.description) && Objects.equals(cost, that.cost) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, vehicle_id, description, cost, date);
    }

    @Override
    public String toString() {
        return "MaintenanceRecords{" +
                "id=" + id +
                ", vehicle_id=" + vehicle_id +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                ", date=" + date +
                '}';
    }
}
