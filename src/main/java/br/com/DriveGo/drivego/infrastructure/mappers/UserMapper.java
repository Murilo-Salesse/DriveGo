package br.com.DriveGo.drivego.infrastructure.mappers;

import br.com.DriveGo.drivego.core.entities.User;
import br.com.DriveGo.drivego.core.enums.Roles;
import br.com.DriveGo.drivego.core.enums.UserStatus;
import br.com.DriveGo.drivego.infrastructure.dtos.requests.UserRegisterRequest;
import br.com.DriveGo.drivego.infrastructure.dtos.responses.UserRegisterResponse;
import lombok.experimental.UtilityClass;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@UtilityClass
public class UserMapper {

    // Converte de userRequest (entrada) para UserModel (entidade do pura do core)
    public static User toDomain(UserRegisterRequest request) {
        return new User(
                null,
                request.getEmail(),
                request.getPassword(),
                null,
                request.getFullName(),
                Roles.CLIENT,
                UserStatus.PENDING,
                request.getPhone(),
                null,
                LocalDateTime.now(),
                LocalDateTime.now(),
                new ArrayList<>()
        );
    }

    // Converte de UserModel (entidade do banco) para userRequest (saida)
    public static UserRegisterResponse toResponse(User u) {
        return new UserRegisterResponse(
                u.getId(),
                u.getEmail(),
                u.getFullName(),
                u.getPhone()
        );
    }

    public static List<UserRegisterResponse> toResponseList(List<User> users) {
        return users.stream()
                .map(UserMapper::toResponse)
                .toList();
    }
}
