package com.dteam.neordinarydteam.global.swagger.annotation;

import com.dteam.neordinarydteam.domain.bookmark.exception.code.BookmarkErrorCode;
import com.dteam.neordinarydteam.domain.customer.exception.code.CustomerErrorCode;
import com.dteam.neordinarydteam.domain.facility.exception.code.FacilityErrorCode;
import com.dteam.neordinarydteam.domain.member.exception.code.MemberErrorCode;
import com.dteam.neordinarydteam.domain.owner.exception.code.OwnerErrorCode;
import com.dteam.neordinarydteam.domain.partnerpost.exception.code.PartnerPostErrorCode;
import com.dteam.neordinarydteam.global.apiPayload.code.ErrorCode;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiErrorCodeExamples {

    // ErrorCode
    ErrorCode[] value() default {};

    MemberErrorCode[] member() default {};

    CustomerErrorCode[] customer() default {};

    BookmarkErrorCode[] bookmark() default {};

    FacilityErrorCode[] facility() default {};

    OwnerErrorCode[] owner() default {};

    PartnerPostErrorCode[] partnerPost() default {};
}
