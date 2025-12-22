package br.com.DriveGo.drivego.infrastructure.gateway;

import br.com.DriveGo.drivego.core.entities.Payment;
import br.com.DriveGo.drivego.core.exceptions.NotFoundException;
import br.com.DriveGo.drivego.core.gateways.PaymentGateway;
import br.com.DriveGo.drivego.infrastructure.mappers.PaymentEntityMapper;
import br.com.DriveGo.drivego.infrastructure.persistence.PaymentEntity;
import br.com.DriveGo.drivego.infrastructure.persistence.PaymentRepository;
import br.com.DriveGo.drivego.infrastructure.persistence.ReservationEntity;
import br.com.DriveGo.drivego.infrastructure.persistence.ReservationRepository;
import org.springframework.stereotype.Component;

@Component
public class PaymentRepositoryGateway implements PaymentGateway {

    private final PaymentRepository paymentRepository;
    private final ReservationRepository reservationRepository;

    public PaymentRepositoryGateway(PaymentRepository paymentRepository,
                                    ReservationRepository reservationRepository) {
        this.paymentRepository = paymentRepository;
        this.reservationRepository = reservationRepository;
    }

    @Override
    public Payment createPayment(Payment payment) {

        ReservationEntity reservation =
                reservationRepository.findById(payment.getReservationId())
                        .orElseThrow(() ->
                                new NotFoundException("Reserva não encontrada")
                        );

        PaymentEntity entity =
                PaymentEntityMapper.toEntity(payment, reservation);

        PaymentEntity saved = paymentRepository.save(entity);

        return PaymentEntityMapper.toDomain(saved);
    }
}

