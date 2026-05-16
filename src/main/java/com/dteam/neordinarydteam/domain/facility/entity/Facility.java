package com.dteam.neordinarydteam.domain.facility.entity;

import com.dteam.neordinarydteam.global.entity.BaseEntity;
import com.dteam.neordinarydteam.global.enums.Curation;
import com.dteam.neordinarydteam.global.enums.Region;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Facility extends BaseEntity {
    @Column
    private String name;

    @Column(name = "address_id", nullable = false)
    private Long addressId;

    @Enumerated(EnumType.STRING)
    @Column
    private Category category;

    @Column
    private String image;

    @Enumerated(EnumType.STRING)
    @Column
    private Region region;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "facility_curation", joinColumns = @JoinColumn(name = "facility_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "curation")
    private List<Curation> curations = new ArrayList<>();
}
