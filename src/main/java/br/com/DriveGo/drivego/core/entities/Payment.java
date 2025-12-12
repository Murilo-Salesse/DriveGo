package br.com.DriveGo.drivego.core.entities;
import br.com.DriveGo.drivego.core.enums.PaymentStatus;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class Payment {

    private UUID id;
    private UUID reservation_id;
    private Double amount;
    private String method;
    private PaymentStatus status;
    private String provider_reference;
    private LocalDateTime created_at;

    public Payment(UUID id, UUID reservation_id, Double amount, String method, PaymentStatus status, String provider_reference, LocalDateTime created_at) {
        this.id = id;
        this.reservation_id = reservation_id;
        this.amount = amount;
        this.method = method;
        this.status = status;
        this.provider_reference = provider_reference;
        this.created_at = created_at;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getReservation_id() {
        return reservation_id;
    }

    public void setReservation_id(UUID reservation_id) {
        this.reservation_id = reservation_id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public String getProvider_reference() {
        return provider_reference;
    }

    public void setProvider_reference(String provider_reference) {
        this.provider_reference = provider_reference;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(id, payment.id) && Objects.equals(reservation_id, payment.reservation_id) && Objects.equals(amount, payment.amount) && Objects.equals(method, payment.method) && status == payment.status && Objects.equals(provider_reference, payment.provider_reference) && Objects.equals(created_at, payment.created_at);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, reservation_id, amount, method, status, provider_reference, created_at);
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", reservation_id=" + reservation_id +
                ", amount=" + amount +
                ", method='" + method + '\'' +
                ", status=" + status +
                ", provider_reference='" + provider_reference + '\'' +
                ", created_at=" + created_at +
                '}';
    }
}
