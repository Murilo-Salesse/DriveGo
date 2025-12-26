package br.com.DriveGo.drivego.infrastructure.mappers;

import java.util.ArrayList;
import java.util.List;

import br.com.DriveGo.drivego.core.entities.User;
import br.com.DriveGo.drivego.infrastructure.dtos.requests.UserRegisterRequest;
import br.com.DriveGo.drivego.infrastructure.dtos.requests.UserUpdateRequest;
import br.com.DriveGo.drivego.infrastructure.dtos.responses.UserResponse;
import br.com.DriveGo.drivego.infrastructure.dtos.responses.UserSimpleResponse;
import lombok.experimental.UtilityClass;

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
                null,
                null,
                request.getPhone(),
                null,
                null,
                null,
                null,
                null,
                new ArrayList<>()
        );
    }

    public static User toDomain(UserUpdateRequest request) {
        User user = new User();
        user.setFullName(request.getFullName());
        user.setPhone(request.getPhone());
        return user;
    }

    // ✔ Genérico para respostas
    public static UserResponse toResponse(User u) {
        return new UserResponse(
                u.getId(),
                u.getEmail(),
                u.getFullName(),
                u.getPhone()
        );
    }

    public static UserSimpleResponse toSimpleResponse(User u) {
        return new UserSimpleResponse(
                u.getEmail()
        );
    }

    public static List<UserResponse> toResponseList(List<User> users) {
        return users.stream()
                .map(UserMapper::toResponse)
                .toList();
    }
}
