package com.dteam.neordinarydteam.domain.facility.entity;

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
public class Facility extends BaseEntity {
    @Column
    private String exampleColumn;

    void update(String exampleColumn) {
        this.exampleColumn = exampleColumn;
    }
}
