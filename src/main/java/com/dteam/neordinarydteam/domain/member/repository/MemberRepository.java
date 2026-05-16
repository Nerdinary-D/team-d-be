package com.dteam.neordinarydteam.domain.member.repository;

import com.dteam.neordinarydteam.domain.member.entity.Member;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByUuid(UUID uuid);
}
