package com.dteam.neordinarydteam.domain.mate.repository;

import com.dteam.neordinarydteam.domain.facility.entity.Facility;
import com.dteam.neordinarydteam.domain.mate.entity.Mate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MateRepository extends JpaRepository<Mate, Long> {
    // 전체 조회 시 Facility를 Fetch Join하여 N+1 방지
    @EntityGraph(attributePaths = {"facility"})
    Page<Mate> findAll(Pageable pageable);

    // 필터링 조회 시 Facility를 Fetch Join하여 N+1 방지
    @EntityGraph(attributePaths = {"facility"})
    Page<Mate> findAllByFacility(Facility facility, Pageable pageable);
}
