package br.com.DriveGo.drivego.core.entities;

import br.com.DriveGo.drivego.core.enums.ReservationStatus;

import java.time.LocalDateTime;

public class Reservation {

    String id;
    String user_id;
    String vehicle_id;
    LocalDateTime start_datetime;
    LocalDateTime end_datetime;
    ReservationStatus status;
    Double total_amount;
    Double deposit_amount;
    LocalDateTime created_at;
    LocalDateTime updated_at;
}
