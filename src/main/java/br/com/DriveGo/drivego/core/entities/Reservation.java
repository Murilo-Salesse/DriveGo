package br.com.DriveGo.drivego.core.entities;

import br.com.DriveGo.drivego.core.enums.ReservationStatus;
import br.com.DriveGo.drivego.core.exceptions.BusinessException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import java.util.UUID;

public class Reservation {

    private static final BigDecimal DEPOSIT_PERCENTAGE = new BigDecimal("0.50");
    private static final int MINIMUM_DAYS = 1;
    private static final int SCALE = 2; // 2 casas decimais para valores monetários

    private UUID id;
    private UUID userId;
    private UUID vehicleId;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private ReservationStatus status;
    private BigDecimal totalAmount;
    private BigDecimal depositAmount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public Reservation(UUID id, UUID userId, UUID vehicleId, LocalDateTime startDateTime, LocalDateTime endDateTime, ReservationStatus status, BigDecimal totalAmount, BigDecimal depositAmount, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.userId = userId;
        this.vehicleId = vehicleId;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.status = status;
        this.totalAmount = totalAmount;
        this.depositAmount = depositAmount;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Reservation() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public UUID getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(UUID vehicleId) {
        this.vehicleId = vehicleId;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalDateTime endDateTime) {
        this.endDateTime = endDateTime;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(BigDecimal depositAmount) {
        this.depositAmount = depositAmount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return Objects.equals(id, that.id) && Objects.equals(userId, that.userId) && Objects.equals(vehicleId, that.vehicleId) && Objects.equals(startDateTime, that.startDateTime) && Objects.equals(endDateTime, that.endDateTime) && status == that.status && Objects.equals(totalAmount, that.totalAmount) && Objects.equals(depositAmount, that.depositAmount) && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, vehicleId, startDateTime, endDateTime, status, totalAmount, depositAmount, createdAt, updatedAt);
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", userId=" + userId +
                ", vehicleId=" + vehicleId +
                ", startDateTime=" + startDateTime +
                ", endDateTime=" + endDateTime +
                ", status=" + status +
                ", totalAmount=" + totalAmount +
                ", depositAmount=" + depositAmount +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    /**
     * Calcula o total da reserva baseado na diária do veículo e duração da reserva
     *
     * @param dailyRate
     */
    public void calculateTotalAmount(BigDecimal dailyRate) {
        validateDates();

        long days = ChronoUnit.DAYS.between(startDateTime, endDateTime);
        if (days < MINIMUM_DAYS) {
            days = MINIMUM_DAYS; // garante no mínimo 1 dia
        }

        // Multiplica diária pelos dias e arredonda para 2 casas decimais

        this.totalAmount = dailyRate.multiply(BigDecimal.valueOf(days))
                .setScale(SCALE, RoundingMode.HALF_UP);
    }

    /**
     * Calcula o valor do depósito com base no total da reserva
     *
     */
    public void calculateDeposit() {
        if (totalAmount == null) {
            throw new IllegalStateException("Total da reserva não calculado");
        }

        this.depositAmount = totalAmount.multiply(DEPOSIT_PERCENTAGE)
                .setScale(SCALE, RoundingMode.HALF_UP);
    }

    /**
     * Valida datas da reserva
     */
    private void validateDates() {
        if (startDateTime == null || endDateTime == null) {
            throw new BusinessException("Datas da reserva não podem ser nulas");
        }

        if (!startDateTime.isBefore(endDateTime)) {
            throw new BusinessException("Data inicial deve ser antes da data final");
        }
    }
}
