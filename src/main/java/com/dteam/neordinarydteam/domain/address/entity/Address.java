package com.dteam.neordinarydteam.domain.address.entity;

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
public class Address extends BaseEntity {

    @Column(nullable = false)
    private String sido;

    @Column(nullable = false)
    private String sigungu;

    @Column(name = "road_address", nullable = false)
    private String roadAddress;

    @Column(name = "detail_address")
    private String detailAddress;

    @Column(nullable = false)
    private String latitude;

    @Column(nullable = false)
    private String longitude;
}
