package br.com.DriveGo.drivego.core.entities;

import java.util.UUID;

public class Damage {

    private UUID id;
    private UUID vehicleId;
    private UUID reservationId;
    private String description;
    private Double estimatedCost;

    public Damage() {}

    public Damage(UUID id,
                  UUID vehicleId,
                  UUID reservationId,
                  String description,
                  Double estimatedCost) {
        this.id = id;
        this.vehicleId = vehicleId;
        this.reservationId = reservationId;
        this.description = description;
        this.estimatedCost = estimatedCost;
    }

    // Getters e Setters
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(UUID vehicleId) {
        this.vehicleId = vehicleId;
    }

    public UUID getReservationId() {
        return reservationId;
    }

    public void setReservationId(UUID reservationId) {
        this.reservationId = reservationId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getEstimatedCost() {
        return estimatedCost;
    }

    public void setEstimatedCost(Double estimatedCost) {
        this.estimatedCost = estimatedCost;
    }
}