package com.dteam.neordinarydteam.domain.mate.repository;

import com.dteam.neordinarydteam.domain.facility.entity.Facility;
import com.dteam.neordinarydteam.domain.mate.entity.Mate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MateRepository extends JpaRepository<Mate, Long> {
    Page<Mate> findAllByFacility(Facility facility, Pageable pageable);
}
