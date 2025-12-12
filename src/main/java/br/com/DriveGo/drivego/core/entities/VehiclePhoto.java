package br.com.DriveGo.drivego.core.entities;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class VehiclePhoto {

    private UUID id;
    private UUID vehicle_id;
    private String url;
    private LocalDateTime updated_at;

    public VehiclePhoto(UUID id, UUID vehicle_id, String url, LocalDateTime updated_at) {
        this.id = id;
        this.vehicle_id = vehicle_id;
        this.url = url;
        this.updated_at = updated_at;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
        VehiclePhoto that = (VehiclePhoto) o;
        return Objects.equals(id, that.id) && Objects.equals(vehicle_id, that.vehicle_id) && Objects.equals(url, that.url) && Objects.equals(updated_at, that.updated_at);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, vehicle_id, url, updated_at);
    }

    @Override
    public String toString() {
        return "VehiclePhotos{" +
                "id=" + id +
                ", vehicle_id=" + vehicle_id +
                ", url='" + url + '\'' +
                ", updated_at=" + updated_at +
                '}';
    }
}
