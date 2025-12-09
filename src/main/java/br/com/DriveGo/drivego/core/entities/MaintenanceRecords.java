package br.com.DriveGo.drivego.core.entities;

import java.time.LocalDateTime;
import java.util.UUID;

public class MaintenanceRecords {

    private UUID id;
    private String vehicle_id;
    private String description;
    private Double cost;
    private LocalDateTime date;

    public MaintenanceRecords(UUID id, String vehicle_id, String description, Double cost, LocalDateTime date) {
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

    public String getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(String vehicle_id) {
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
}
