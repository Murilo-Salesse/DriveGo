package br.com.DriveGo.drivego.infrastructure.dtos.responses;

import br.com.DriveGo.drivego.core.enums.ReservationStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationResponse {


    UUID id;
    UUID vehicleId;
    UUID userId;
    ReservationStatus status;
    LocalDateTime startDateTime;
    LocalDateTime endDateTime;
    BigDecimal totalAmount;
    BigDecimal depositAmount;
    LocalDateTime createdAt;
}
