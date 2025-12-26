package br.com.DriveGo.drivego.infrastructure.beans;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.DriveGo.drivego.core.gateways.CategoryGateway;
import br.com.DriveGo.drivego.core.gateways.JwtTokenGateway;
import br.com.DriveGo.drivego.core.gateways.PasswordHashGateway;
import br.com.DriveGo.drivego.core.gateways.PaymentGateway;
import br.com.DriveGo.drivego.core.gateways.ReservationGateway;
import br.com.DriveGo.drivego.core.gateways.StripeGateway;
import br.com.DriveGo.drivego.core.gateways.UserGateway;
import br.com.DriveGo.drivego.core.gateways.VehicleGateway;
import br.com.DriveGo.drivego.core.gateways.VehiclePhotoGateway;
import br.com.DriveGo.drivego.core.usecases.categories.CreateCategoryUseCase;
import br.com.DriveGo.drivego.core.usecases.categories.CreateCategoryUseCaseImp;
import br.com.DriveGo.drivego.core.usecases.categories.DeleteCategoryUseCase;
import br.com.DriveGo.drivego.core.usecases.categories.DeleteCategoryUseCaseImp;
import br.com.DriveGo.drivego.core.usecases.categories.FindByIdCategoryUseCase;
import br.com.DriveGo.drivego.core.usecases.categories.FindByIdCategoryUseCaseImp;
import br.com.DriveGo.drivego.core.usecases.categories.ListAllCategoryUseCase;
import br.com.DriveGo.drivego.core.usecases.categories.ListAllCategoryUseCaseImp;
import br.com.DriveGo.drivego.core.usecases.categories.ListCategoryByNameUseCase;
import br.com.DriveGo.drivego.core.usecases.categories.ListCategoryByNameUseCaseImp;
import br.com.DriveGo.drivego.core.usecases.categories.UpdateCategoryUseCase;
import br.com.DriveGo.drivego.core.usecases.categories.UpdateCategoryUseCaseImp;
import br.com.DriveGo.drivego.core.usecases.email.SendVerificationEmailUseCase;
import br.com.DriveGo.drivego.core.usecases.email.SendVerifiyLoginEmailUseCase;
import br.com.DriveGo.drivego.core.usecases.payments.CreatePaymentUseCase;
import br.com.DriveGo.drivego.core.usecases.payments.CreatePaymentUseCaseImp;
import br.com.DriveGo.drivego.core.usecases.reservations.CountTotalReservationCostUseCase;
import br.com.DriveGo.drivego.core.usecases.reservations.CountTotalReservationCostUseCaseImp;
import br.com.DriveGo.drivego.core.usecases.reservations.CountTotalReservationUseCase;
import br.com.DriveGo.drivego.core.usecases.reservations.CountTotalReservationUseCaseImp;
import br.com.DriveGo.drivego.core.usecases.reservations.CreateReservationUseCase;
import br.com.DriveGo.drivego.core.usecases.reservations.CreateReservationUseCaseImp;
import br.com.DriveGo.drivego.core.usecases.reservations.FindReservationByIdUseCase;
import br.com.DriveGo.drivego.core.usecases.reservations.FindReservationByIdUseCaseImp;
import br.com.DriveGo.drivego.core.usecases.reservations.ListAllReservationUseCase;
import br.com.DriveGo.drivego.core.usecases.reservations.ListAllReservationUseCaseImp;
import br.com.DriveGo.drivego.core.usecases.reservations.UpdateReservationUseCase;
import br.com.DriveGo.drivego.core.usecases.reservations.UpdateReservationUseCaseImp;
import br.com.DriveGo.drivego.core.usecases.users.CreateUserUseCase;
import br.com.DriveGo.drivego.core.usecases.users.CreateUserUseCaseImp;
import br.com.DriveGo.drivego.core.usecases.users.LoginUserUseCase;
import br.com.DriveGo.drivego.core.usecases.users.LoginUserUseCaseImp;
import br.com.DriveGo.drivego.core.usecases.users.UpdateUserUseCase;
import br.com.DriveGo.drivego.core.usecases.users.UpdateUserUseCaseImp;
import br.com.DriveGo.drivego.core.usecases.users.ValidateTokenLoginUseCase;
import br.com.DriveGo.drivego.core.usecases.users.ValidateTokenLoginUseCaseImp;
import br.com.DriveGo.drivego.core.usecases.users.ValidateTokenUseCase;
import br.com.DriveGo.drivego.core.usecases.users.ValidateTokenUseCaseImp;
import br.com.DriveGo.drivego.core.usecases.vehicles.CreateVehicleUseCase;
import br.com.DriveGo.drivego.core.usecases.vehicles.CreateVehicleUseCaseImp;
import br.com.DriveGo.drivego.core.usecases.vehicles.DeleteVehicleByIdUseCase;
import br.com.DriveGo.drivego.core.usecases.vehicles.DeleteVehicleByIdUseCaseImp;
import br.com.DriveGo.drivego.core.usecases.vehicles.FindByIdVehicleUseCase;
import br.com.DriveGo.drivego.core.usecases.vehicles.FindByIdVehicleUseCaseImp;
import br.com.DriveGo.drivego.core.usecases.vehicles.FindVehiclesUseCase;
import br.com.DriveGo.drivego.core.usecases.vehicles.FindVehiclesUseCaseImp;
import br.com.DriveGo.drivego.core.usecases.vehicles.ListAllVehiclesUseCase;
import br.com.DriveGo.drivego.core.usecases.vehicles.ListAllVehiclesUseCaseImp;
import br.com.DriveGo.drivego.core.usecases.vehicles.UpdateVehicleUseCase;
import br.com.DriveGo.drivego.core.usecases.vehicles.UpdateVehicleUseCaseImp;
import br.com.DriveGo.drivego.core.usecases.vehiclesPhotos.CreateVehiclePhotoUseCase;
import br.com.DriveGo.drivego.core.usecases.vehiclesPhotos.CreateVehiclePhotoUseCaseImp;
import br.com.DriveGo.drivego.core.usecases.vehiclesPhotos.DeleteVehiclePhotoByIdUseCase;
import br.com.DriveGo.drivego.core.usecases.vehiclesPhotos.DeleteVehiclePhotoByIdUseCaseImp;
import br.com.DriveGo.drivego.core.usecases.vehiclesPhotos.FindByIdVehiclePhotoUseCase;
import br.com.DriveGo.drivego.core.usecases.vehiclesPhotos.FindByIdVehiclePhotoUseCaseImp;
import br.com.DriveGo.drivego.core.usecases.vehiclesPhotos.ListAllVehiclePhotosUseCase;
import br.com.DriveGo.drivego.core.usecases.vehiclesPhotos.ListAllVehiclePhotosUseCaseImp;
import br.com.DriveGo.drivego.core.usecases.vehiclesPhotos.UpdatePhotoVehiclePhotoUseCase;
import br.com.DriveGo.drivego.core.usecases.vehiclesPhotos.UpdatePhotoVehiclePhotoUseCaseImp;

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

    @Bean public UpdateUserUseCase updateUserUseCase(UserGateway userGateway) {
        return new UpdateUserUseCaseImp(userGateway);
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
