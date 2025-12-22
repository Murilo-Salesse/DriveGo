package br.com.DriveGo.drivego.core.entities;
import br.com.DriveGo.drivego.core.enums.PaymentStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class Payment {

    private UUID id;
    private UUID reservationId;
    private BigDecimal amount;

    private String method;   // CARD, PIX
    private String provider; // STRIPE

    private PaymentStatus status;
    private String providerReference;
    private LocalDateTime createdAt;

    public Payment(UUID id, UUID reservationId, BigDecimal amount, String method, String provider, PaymentStatus status, String providerReference, LocalDateTime createdAt) {
        this.id = id;
        this.reservationId = reservationId;
        this.amount = amount;
        this.method = method;
        this.provider = provider;
        this.status = status;
        this.providerReference = providerReference;
        this.createdAt = createdAt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getReservationId() {
        return reservationId;
    }

    public void setReservationId(UUID reservationId) {
        this.reservationId = reservationId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public String getProviderReference() {
        return providerReference;
    }

    public void setProviderReference(String providerReference) {
        this.providerReference = providerReference;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(id, payment.id) && Objects.equals(reservationId, payment.reservationId) && Objects.equals(amount, payment.amount) && Objects.equals(method, payment.method) && Objects.equals(provider, payment.provider) && status == payment.status && Objects.equals(providerReference, payment.providerReference) && Objects.equals(createdAt, payment.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, reservationId, amount, method, provider, status, providerReference, createdAt);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", reservationId=" + reservationId +
                ", amount=" + amount +
                ", method='" + method + '\'' +
                ", provider='" + provider + '\'' +
                ", status=" + status +
                ", providerReference='" + providerReference + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
