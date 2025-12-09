package br.com.DriveGo.drivego.core.entities;

import br.com.DriveGo.drivego.core.enums.ReservationStatus;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class Reservation {

    private UUID id;
    private String user_id;
    private String vehicle_id;
    private LocalDateTime start_datetime;
    private LocalDateTime end_datetime;
    private ReservationStatus status;
    private Double total_amount;
    private Double deposit_amount;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public Reservation(UUID id, String user_id, String vehicle_id, LocalDateTime start_datetime, LocalDateTime end_datetime, ReservationStatus status, Double total_amount, Double deposit_amount, LocalDateTime created_at, LocalDateTime updated_at) {
        this.id = id;
        this.user_id = user_id;
        this.vehicle_id = vehicle_id;
        this.start_datetime = start_datetime;
        this.end_datetime = end_datetime;
        this.status = status;
        this.total_amount = total_amount;
        this.deposit_amount = deposit_amount;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(String vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public LocalDateTime getStart_datetime() {
        return start_datetime;
    }

    public void setStart_datetime(LocalDateTime start_datetime) {
        this.start_datetime = start_datetime;
    }

    public LocalDateTime getEnd_datetime() {
        return end_datetime;
    }

    public void setEnd_datetime(LocalDateTime end_datetime) {
        this.end_datetime = end_datetime;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }

    public Double getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(Double total_amount) {
        this.total_amount = total_amount;
    }

    public Double getDeposit_amount() {
        return deposit_amount;
    }

    public void setDeposit_amount(Double deposit_amount) {
        this.deposit_amount = deposit_amount;
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
        Reservation that = (Reservation) o;
        return Objects.equals(id, that.id) && Objects.equals(user_id, that.user_id) && Objects.equals(vehicle_id, that.vehicle_id) && Objects.equals(start_datetime, that.start_datetime) && Objects.equals(end_datetime, that.end_datetime) && status == that.status && Objects.equals(total_amount, that.total_amount) && Objects.equals(deposit_amount, that.deposit_amount) && Objects.equals(created_at, that.created_at) && Objects.equals(updated_at, that.updated_at);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user_id, vehicle_id, start_datetime, end_datetime, status, total_amount, deposit_amount, created_at, updated_at);
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", user_id='" + user_id + '\'' +
                ", vehicle_id='" + vehicle_id + '\'' +
                ", start_datetime=" + start_datetime +
                ", end_datetime=" + end_datetime +
                ", status=" + status +
                ", total_amount=" + total_amount +
                ", deposit_amount=" + deposit_amount +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }
}
