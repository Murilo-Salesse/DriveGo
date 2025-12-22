package br.com.DriveGo.drivego.infrastructure.beans;

import br.com.DriveGo.drivego.core.gateways.*;
import br.com.DriveGo.drivego.core.usecases.categories.*;
import br.com.DriveGo.drivego.core.usecases.email.SendVerificationEmailUseCase;
import br.com.DriveGo.drivego.core.usecases.email.SendVerifiyLoginEmailUseCase;
import br.com.DriveGo.drivego.core.usecases.payments.CreatePaymentUseCase;
import br.com.DriveGo.drivego.core.usecases.payments.CreatePaymentUseCaseImp;
import br.com.DriveGo.drivego.core.usecases.reservations.*;
import br.com.DriveGo.drivego.core.usecases.users.*;
import br.com.DriveGo.drivego.core.usecases.vehicles.*;
import br.com.DriveGo.drivego.core.usecases.vehiclesPhotos.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {


    @Bean public CreateCategoryUseCase createCategoryUseCase(CategoryGateway categoryGateway) {
        return new CreateCategoryUseCaseImp(categoryGateway);
    }

    @Bean public FindByIdCategoryUseCase findByIdCategoryUseCase(CategoryGateway categoryGateway) {
        return new FindByIdCategoryUseCaseImp(categoryGateway);
    }

    @Bean public ListAllCategoryUseCase listAllCategoryUseCase(CategoryGateway categoryGateway) {
        return new ListAllCategoryUseCaseImp(categoryGateway);
    }

    @Bean public DeleteCategoryUseCase deleteCategoryUseCase(CategoryGateway categoryGateway) {
        return new DeleteCategoryUseCaseImp(categoryGateway);
    }

    @Bean public UpdateCategoryUseCase updateCategoryUseCase(CategoryGateway categoryGateway) {
        return new UpdateCategoryUseCaseImp(categoryGateway);
    }

    @Bean public ListCategoryByNameUseCase listCategoryByNameUseCase(CategoryGateway categoryGateway) {
        return new ListCategoryByNameUseCaseImp(categoryGateway);
    }


    @Bean public CreateVehicleUseCase createVehicleUseCase(VehicleGateway vehicleGateway) {
        return new CreateVehicleUseCaseImp(vehicleGateway);
    }

    @Bean public ListAllVehiclesUseCase listAllVehiclesUseCase(VehicleGateway vehicleGateway) {
        return new ListAllVehiclesUseCaseImp(vehicleGateway);
    }

    @Bean public FindByIdVehicleUseCase findByIdVehicleUseCase(VehicleGateway vehicleGateway) {
        return new FindByIdVehicleUseCaseImp(vehicleGateway);
    }

    @Bean public FindVehiclesUseCase findVehiclesUseCase(VehicleGateway vehicleGateway) {
        return new FindVehiclesUseCaseImp(vehicleGateway);
    }

    @Bean public UpdateVehicleUseCase updateVehicleUseCase(VehicleGateway vehicleGateway) {
        return new UpdateVehicleUseCaseImp(vehicleGateway);
    }

    @Bean public DeleteVehicleByIdUseCase deleteVehicleByIdUseCase(VehicleGateway vehicleGateway) {
        return new DeleteVehicleByIdUseCaseImp(vehicleGateway);
    }


    @Bean public CreateVehiclePhotoUseCase createVehiclePhotoUseCase(VehiclePhotoGateway vehiclePhotoGateway, VehicleGateway vehicleGateway) {
        return new CreateVehiclePhotoUseCaseImp(vehiclePhotoGateway, vehicleGateway);
    }

    @Bean public ListAllVehiclePhotosUseCase listAllVehiclePhotosUseCase(VehiclePhotoGateway vehiclePhotoGateway) {
        return new ListAllVehiclePhotosUseCaseImp(vehiclePhotoGateway);
    }

    @Bean public FindByIdVehiclePhotoUseCase findByIdVehiclePhotoUseCase(VehiclePhotoGateway vehiclePhotoGateway) {
        return new FindByIdVehiclePhotoUseCaseImp(vehiclePhotoGateway);
    }

    @Bean public UpdatePhotoVehiclePhotoUseCase updatePhotoVehiclePhotoUseCase(VehiclePhotoGateway vehiclePhotoGateway) {
        return new UpdatePhotoVehiclePhotoUseCaseImp(vehiclePhotoGateway);
    }

    @Bean public DeleteVehiclePhotoByIdUseCase deleteVehiclePhotoByIdUseCase(VehiclePhotoGateway vehiclePhotoGateway) {
        return new DeleteVehiclePhotoByIdUseCaseImp(vehiclePhotoGateway);
    }


    @Bean public CreateUserUseCase createUserUseCase(UserGateway userGateway,
                                                     PasswordHashGateway passwordHashGateway,
                                                     SendVerificationEmailUseCase emailGateway) {
        return new CreateUserUseCaseImp(userGateway, passwordHashGateway, emailGateway);
    }

    @Bean public LoginUserUseCase loginUserUseCase(UserGateway userGateway,
                                                   PasswordHashGateway passwordHashGateway,
                                                   SendVerifiyLoginEmailUseCase sendVerifiyLoginEmailUseCase

    ) {
        return new LoginUserUseCaseImp(userGateway, passwordHashGateway, sendVerifiyLoginEmailUseCase);
    }

    @Bean public ValidateTokenUseCase validateTokenUseCase(UserGateway userGateway) {
        return new ValidateTokenUseCaseImp(userGateway);
    }

    @Bean public ValidateTokenLoginUseCase validateTokenLoginUseCase(UserGateway userGateway, JwtTokenGateway jwtTokenGateway) {
        return new ValidateTokenLoginUseCaseImp(userGateway, jwtTokenGateway);
    }


    @Bean public CreateReservationUseCase createReservationUseCase(ReservationGateway reservationGateway,
                                                                   VehicleGateway vehicleGateway,
                                                                   UserGateway userGateway) {
        return new CreateReservationUseCaseImp(reservationGateway, vehicleGateway, userGateway);
    }

    @Bean public CountTotalReservationUseCase countTotalReservationUseCase(ReservationGateway reservationGateway) {
        return new CountTotalReservationUseCaseImp(reservationGateway);
    }

    @Bean public CountTotalReservationCostUseCase countTotalReservationCostUseCase(ReservationGateway reservationGateway) {
        return new CountTotalReservationCostUseCaseImp(reservationGateway);
    }

    @Bean public FindReservationByIdUseCase findReservationByIdUseCase(ReservationGateway reservationGateway) {
        return new FindReservationByIdUseCaseImp(reservationGateway);
    }

    @Bean public ListAllReservationUseCase listAllReservationUseCase(ReservationGateway reservationGateway) {
        return new ListAllReservationUseCaseImp(reservationGateway);
    }

    @Bean public UpdateReservationUseCase updateReservationUseCase(ReservationGateway reservationGateway,
                                                                   VehicleGateway vehicleGateway) {
        return new UpdateReservationUseCaseImp(reservationGateway, vehicleGateway);
    }


    @Bean public CreatePaymentUseCase createPaymentUseCase(PaymentGateway paymentGateway,
                                                           ReservationGateway reservationGateway,
                                                           StripeGateway stripeGateway) {
        return new CreatePaymentUseCaseImp(paymentGateway, reservationGateway, stripeGateway);
    }
}
