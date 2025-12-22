package br.com.DriveGo.drivego.infrastructure.gateway;

import br.com.DriveGo.drivego.core.entities.Reservation;
import br.com.DriveGo.drivego.core.exceptions.NotFoundException;
import br.com.DriveGo.drivego.core.gateways.ReservationGateway;
import br.com.DriveGo.drivego.infrastructure.mappers.ReservationEntityMapper;
import br.com.DriveGo.drivego.infrastructure.persistence.*;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Component
public class ReservationRepositoryGateway implements ReservationGateway {

    private final ReservationRepository reservationRepository;
    private final UserRepository userRepository;
    private final VehicleRepository vehicleRepository;

    public ReservationRepositoryGateway(ReservationRepository reservationRepository,
                                        UserRepository userRepository,
                                        VehicleRepository vehicleRepository) {
        this.reservationRepository = reservationRepository;
        this.userRepository = userRepository;
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public Reservation createReservation(Reservation reservation) {
        UserEntity user = userRepository.findById(reservation.getUserId())
                .orElseThrow(() -> new NotFoundException("Usuário não encontrado."));

        VehicleEntity vehicle = vehicleRepository.findById(reservation.getVehicleId())
                .orElseThrow(() -> new NotFoundException("Veiculo não encontrada."));

        ReservationEntity entity =
                ReservationEntityMapper.toEntity(reservation, user, vehicle);

        ReservationEntity saved = reservationRepository.save(entity);

        return ReservationEntityMapper.toDomain(saved);
    }

    @Override
    public Reservation findById(UUID id) {
        ReservationEntity entity = reservationRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Reserva não encontrada."));

        return ReservationEntityMapper.toDomain(entity);
    }

    @Override
    public Reservation update(Reservation reservation) {
        ReservationEntity entity =
                reservationRepository.findById(reservation.getId())
                        .orElseThrow(() ->
                                new NotFoundException("Reserva não encontrada")
                        );

        entity.setStartDateTime(reservation.getStartDateTime());
        entity.setEndDateTime(reservation.getEndDateTime());
        entity.setTotalAmount(reservation.getTotalAmount());
        entity.setDepositAmount(reservation.getDepositAmount());

        ReservationEntity saved = reservationRepository.save(entity);
        return ReservationEntityMapper.toDomain(saved);
    }


    @Override
    public List<Reservation> listAll() {
        List<ReservationEntity> listEntity = reservationRepository.findAll();

        return listEntity.stream()
                .map(ReservationEntityMapper::toDomain)
                .toList();
    }

    @Override
    public Long totalReservations() {return reservationRepository.countAll();}

    @Override
    public BigDecimal countTotalReservationCost(UUID id) {
        userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Usuário não encontrada."));

        return reservationRepository.sumTotalSpentByUser(id);
    }
}
