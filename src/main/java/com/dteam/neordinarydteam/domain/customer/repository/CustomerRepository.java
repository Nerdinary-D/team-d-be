package com.dteam.neordinarydteam.domain.customer.repository;

import com.dteam.neordinarydteam.domain.customer.entity.Customer;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("SELECT c FROM Customer c JOIN FETCH c.member m WHERE m.uuid = :uuid")
    Optional<Customer> findByUuid(@Param("uuid") UUID uuid);
}
