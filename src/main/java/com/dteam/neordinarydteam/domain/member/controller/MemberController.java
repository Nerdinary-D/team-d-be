package com.dteam.neordinarydteam.domain.member.controller;

import com.dteam.neordinarydteam.domain.member.dto.response.MemberResponse;
import com.dteam.neordinarydteam.domain.member.service.query.MemberQueryService;
import com.dteam.neordinarydteam.global.apiPayload.code.SuccessCode;
import com.dteam.neordinarydteam.global.apiPayload.response.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Member", description = "Member API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/members")
public class MemberController {
    private final MemberQueryService memberQueryService;

    @GetMapping("/{uuid}/role")
    public ApiResponse<MemberResponse.RoleDTO> getMemberRole(@PathVariable String uuid) {
        return ApiResponse.onSuccess(SuccessCode.OK, memberQueryService.getMemberRole(uuid));
    }
}
