package br.com.DriveGo.drivego.core.entities;
import br.com.DriveGo.drivego.core.enums.PaymentStatus;
import java.time.LocalDateTime;

public class Payment {

    String id;
    String reservation_id;
    Double amount;
    String method;
    PaymentStatus status;
    String provider_reference;
    LocalDateTime created_at;
}
