package com.dteam.neordinarydteam.domain.owner.entity;

import com.dteam.neordinarydteam.global.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Owner extends BaseEntity {
    @Column(name = "facility_id", nullable = false)
    private Long facilityId;

    @Column(name = "member_id", nullable = false)
    private Long memberId;
}
