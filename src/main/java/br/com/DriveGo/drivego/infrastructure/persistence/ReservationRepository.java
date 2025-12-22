package br.com.DriveGo.drivego.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.UUID;

public interface ReservationRepository extends JpaRepository<ReservationEntity, UUID> {

    @Query("SELECT COUNT(r) FROM ReservationEntity r")
    long countAll();

    @Query("""
    SELECT COALESCE(SUM(r.totalAmount), 0)
    FROM ReservationEntity r
    WHERE r.user.id = :userId
      AND r.status IN ('CONFIRMED', 'COMPLETED', 'PENDING')
""")
    BigDecimal sumTotalSpentByUser(@Param("userId") UUID userId);
}
