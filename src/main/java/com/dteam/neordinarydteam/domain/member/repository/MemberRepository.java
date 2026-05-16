package com.dteam.neordinarydteam.domain.member.repository;

import com.dteam.neordinarydteam.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {}
