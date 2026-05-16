package com.dteam.neordinarydteam.domain.customer.entity;

import com.dteam.neordinarydteam.domain.member.entity.Member;
import com.dteam.neordinarydteam.global.entity.BaseEntity;
import com.dteam.neordinarydteam.global.enums.Curation;
import com.dteam.neordinarydteam.global.enums.Region;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Customer extends BaseEntity {
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE, orphanRemoval = true)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @Enumerated(EnumType.STRING)
    private Curation curation;

    @Enumerated(EnumType.STRING)
    private Region region;

    public void update(Curation curation, Region region) {
        this.curation = curation;
        this.region = region;
    }
}
