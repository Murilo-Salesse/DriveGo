package br.com.DriveGo.drivego.infrastructure.presentation;

import br.com.DriveGo.drivego.core.entities.Reservation;
import br.com.DriveGo.drivego.core.usecases.reservations.*;
import br.com.DriveGo.drivego.infrastructure.configurations.UserPrincipal;
import br.com.DriveGo.drivego.infrastructure.dtos.requests.ReservationRequest;
import br.com.DriveGo.drivego.infrastructure.dtos.requests.ReservationUpdateRequest;
import br.com.DriveGo.drivego.infrastructure.mappers.ReservationMapper;
import jakarta.validation.Valid;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {

    private final CreateReservationUseCase createReservationUseCase;
    private final CountTotalReservationUseCase countTotalReservationUseCase;
    private final CountTotalReservationCostUseCase countTotalReservationCostUseCase;
    private final FindReservationByIdUseCase findReservationByIdUseCase;
    private final ListAllReservationUseCase listAllReservationUseCase;
    private final UpdateReservationUseCase updateReservationUseCase;

    public ReservationController(CreateReservationUseCase createReservationUseCase, CountTotalReservationUseCase countTotalReservationUseCase, CountTotalReservationCostUseCase countTotalReservationCostUseCase, FindReservationByIdUseCase findReservationByIdUseCase, ListAllReservationUseCase listAllReservationUseCase, UpdateReservationUseCase updateReservationUseCase) {
        this.createReservationUseCase = createReservationUseCase;
        this.countTotalReservationUseCase = countTotalReservationUseCase;
        this.countTotalReservationCostUseCase = countTotalReservationCostUseCase;
        this.findReservationByIdUseCase = findReservationByIdUseCase;
        this.listAllReservationUseCase = listAllReservationUseCase;
        this.updateReservationUseCase = updateReservationUseCase;
    }

    @PostMapping("/register")
    public ResponseEntity<@NonNull Map<String, Object>> registerReservation(
            @Valid @RequestBody ReservationRequest request,
            @AuthenticationPrincipal UserPrincipal principal
    ) {
        UUID userId = principal.getId();

        Reservation savedReservation =
                createReservationUseCase.execute(
                        ReservationMapper.toDomain(request, userId)
                );

        Map<String, Object> data = Map.of(
                "message", "Reserva realizada com sucesso.",
                "reservation", ReservationMapper.toResponse(savedReservation)
        );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("data", data));
    }

    @GetMapping("/count")
    public ResponseEntity<@NonNull Map<String, Object>> count() {


        Map<String, Object> data = Map.of(
                "message", "Total gasto.",
                "total", countTotalReservationUseCase.execute()
        );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("data", data));
    }

    @GetMapping("/totalSpend")
    public ResponseEntity<@NonNull Map<String, Object>> countTotalSpend(
            @AuthenticationPrincipal UserPrincipal principal
    ) {

        Map<String, Object> data = Map.of(
                "message", "Total gasto.",
                "total", countTotalReservationCostUseCase.execute(principal.getId())
        );

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(Map.of("data", data));
    }

    @GetMapping("/{id}")
    public ResponseEntity<@NonNull Map<String, Object>> findById(@PathVariable("id") UUID id) {

        Reservation reservation = findReservationByIdUseCase.execute(id);

        Map<String, Object> data = Map.of(
                "reservation", ReservationMapper.toResponse(reservation)
        );

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("data", data));
    }

    @GetMapping("/all")
    public ResponseEntity<@NonNull Map<String, Object>> listAll() {

        List<Reservation> reservations = listAllReservationUseCase.execute();

        Map<String, Object> data = Map.of(
                "reservations", ReservationMapper.toResponseList(reservations)
        );

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("data", data));
    }

    @PutMapping("/{id}")
    public ResponseEntity<@NonNull Map<String, Object>> updateReservation(
            @PathVariable UUID id,
            @Valid @RequestBody ReservationUpdateRequest request
    ) {
        Reservation updated =
                updateReservationUseCase.execute(
                        id,
                        ReservationMapper.toDomainUpdate(request)
                );

        return ResponseEntity.ok(
                Map.of("reservation", ReservationMapper.toResponse(updated))
        );
    }

}
