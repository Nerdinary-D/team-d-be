package com.dteam.neordinarydteam.domain.customer.entity;

import com.dteam.neordinarydteam.domain.member.entity.Member;
import com.dteam.neordinarydteam.global.entity.BaseEntity;
import com.dteam.neordinarydteam.global.enums.Curation;
import com.dteam.neordinarydteam.global.enums.Region;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Customer extends BaseEntity {
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "customer_curation", joinColumns = @JoinColumn(name = "customer_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "curation")
    @Builder.Default
    private List<Curation> curations = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private Region region = Region.SEOUL;

    public void updateRegion(Region region) {
        this.region = region;
    }

    public void updateCurations(List<Curation> curations) {
        this.curations.clear();
        if (curations != null) {
            this.curations.addAll(curations);
        }
    }
}
