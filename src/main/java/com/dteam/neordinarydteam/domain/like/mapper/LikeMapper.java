package com.dteam.neordinarydteam.domain.like.mapper;

import com.dteam.neordinarydteam.domain.customer.entity.Customer;
import com.dteam.neordinarydteam.domain.facility.entity.Facility;
import com.dteam.neordinarydteam.domain.like.dto.response.LikeResponse;
import com.dteam.neordinarydteam.domain.like.entity.Like;
import com.dteam.neordinarydteam.global.enums.Curation;
import java.util.UUID;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LikeMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "updatedAt", ignore = true)
    Like toCreateEntity(Customer customer, Facility facility);

    LikeResponse.ExistDTO toExistDTO(UUID uuid, boolean isLiked);

    @Mapping(target = "uuid", source = "uuid")
    @Mapping(target = "image", source = "like.facility.image")
    @Mapping(target = "name", source = "like.facility.name")
    @Mapping(target = "category", source = "like.facility.category")
    @Mapping(target = "hashTags", source = "like.facility.curations")
    @Mapping(target = "facilityId", source = "like.facility.id")
    @Mapping(target = "isLiked", constant = "true") // 내가 좋아요 한 목록이므로 항상 true 지정
    LikeResponse.MyDTO toMyDTO(Like like, UUID uuid);

    /**
     * MapStruct가 List<Curation>을 List<String>으로 변환할 때
     * 원소 하나하나에 자동으로 적용할 단일 객체 변환 메서드입니다.
     */
    default String mapCurationToHashtag(Curation curation) {
        if (curation == null) {
            return null;
        }
        return curation.getHashtag();
    }
}
