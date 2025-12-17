package br.com.DriveGo.drivego.infrastructure.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehiclePhotoResponse {

    private UUID id;
    private String url;
    private LocalDateTime uploadedAt;
}
