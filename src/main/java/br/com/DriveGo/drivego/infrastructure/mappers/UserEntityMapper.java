package br.com.DriveGo.drivego.infrastructure.mappers;

import br.com.DriveGo.drivego.core.entities.User;
import br.com.DriveGo.drivego.infrastructure.persistence.ReservationEntity;
import br.com.DriveGo.drivego.infrastructure.persistence.UserEntity;
import lombok.experimental.UtilityClass;

import java.util.ArrayList;

@UtilityClass
public class UserEntityMapper {

    // Converte de UserRequest(entrada) para UserEntity (entidade para salvar no banco)
    public static UserEntity toEntity(User user) {
        UserEntity entity = new UserEntity();

        entity.setId(user.getId());
        entity.setEmail(user.getEmail());
        entity.setPasswordHash(user.getPasswordHash());
        entity.setGoogleId(user.getGoogleId());
        entity.setFullName(user.getFullName());
        entity.setRole(user.getRole());
        entity.setStatus(user.getStatus());
        entity.setPhone(user.getPhone());
        entity.setLastLoginAt(user.getLastLoginAt());
        entity.setCreatedAt(user.getCreatedAt());
        entity.setUpdatedAt(user.getUpdatedAt());

        return entity;
    }

    // Converte de UserEntity (entidade do banco) para UserRequest (saida)
    public static User toDomain(UserEntity entity) {
        return new User(
                entity.getId(),
                entity.getEmail(),
                entity.getPasswordHash(),
                entity.getGoogleId(),
                entity.getFullName(),
                entity.getRole(),
                entity.getStatus(),
                entity.getPhone(),
                entity.getLastLoginAt(),
                entity.getCreatedAt(),
                entity.getUpdatedAt(),
                entity.getReservations() != null
                        ? entity.getReservations().stream().map(ReservationEntity::getId).toList()
                        : new ArrayList<>()
        );
    }
}
