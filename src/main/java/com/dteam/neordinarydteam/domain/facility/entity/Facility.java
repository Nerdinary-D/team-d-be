package com.dteam.neordinarydteam.domain.facility.entity;

import com.dteam.neordinarydteam.global.entity.BaseEntity;
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

    @ElementCollection
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "facility_infra_info", joinColumns = @JoinColumn(name = "facility_id"))
    @Column(name = "infra_info")
    private List<InfraInfo> infraInfos = new ArrayList<>();
}
