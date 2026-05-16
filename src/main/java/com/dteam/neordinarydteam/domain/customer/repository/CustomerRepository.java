package com.dteam.neordinarydteam.domain.customer.repository;

import com.dteam.neordinarydteam.domain.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {}
