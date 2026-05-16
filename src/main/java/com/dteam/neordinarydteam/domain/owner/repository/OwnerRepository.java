package com.dteam.neordinarydteam.domain.owner.repository;

import com.dteam.neordinarydteam.domain.owner.entity.Owner;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
    Optional<Owner> findByMemberId(Long memberId);
}
