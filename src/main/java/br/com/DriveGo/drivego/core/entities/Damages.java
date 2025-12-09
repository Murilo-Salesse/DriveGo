package br.com.DriveGo.drivego.core.entities;

import java.util.Objects;
import java.util.UUID;

public class Damages {

    private UUID id;
    private String reservation_id;
    private String vehicle_id;
    private String description;
    private Double estimated_cost;

    public Damages(UUID id, String reservation_id, String vehicle_id, String description, Double estimated_cost) {
        this.id = id;
        this.reservation_id = reservation_id;
        this.vehicle_id = vehicle_id;
        this.description = description;
        this.estimated_cost = estimated_cost;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getReservation_id() {
        return reservation_id;
    }

    public void setReservation_id(String reservation_id) {
        this.reservation_id = reservation_id;
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

    public Double getEstimated_cost() {
        return estimated_cost;
    }

    public void setEstimated_cost(Double estimated_cost) {
        this.estimated_cost = estimated_cost;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Damages damages = (Damages) o;
        return Objects.equals(id, damages.id) && Objects.equals(reservation_id, damages.reservation_id) && Objects.equals(vehicle_id, damages.vehicle_id) && Objects.equals(description, damages.description) && Objects.equals(estimated_cost, damages.estimated_cost);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, reservation_id, vehicle_id, description, estimated_cost);
    }

    @Override
    public String toString() {
        return "Damages{" +
                "id=" + id +
                ", reservation_id='" + reservation_id + '\'' +
                ", vehicle_id='" + vehicle_id + '\'' +
                ", description='" + description + '\'' +
                ", estimated_cost=" + estimated_cost +
                '}';
    }
}
