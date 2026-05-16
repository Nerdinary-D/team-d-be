package com.dteam.neordinarydteam.domain.like.repository;

import com.dteam.neordinarydteam.domain.like.entity.Like;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LikeRepository extends JpaRepository<Like, Long> {
    boolean existsByCustomerIdAndFacilityId(Long customerId, Long facilityId);

    Optional<Like> findByCustomerIdAndFacilityId(Long customerId, Long facilityId);

    @Query("select l from Like l join fetch l.facility f where l.customer.id = :customerId")
    Page<Like> findByCustomerIdWithFacility(@Param("customerId") Long customerId, Pageable pageable);

    @Query("select l.facility.id from Like l where l.customer.id = :customerId")
    List<Long> findFacilityIdsByCustomerId(@Param("customerId") Long customerId);
}
