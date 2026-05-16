package com.dteam.neordinarydteam.domain.address.repository;

import com.dteam.neordinarydteam.domain.address.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {}
