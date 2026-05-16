package com.dteam.neordinarydteam.domain.member.service.query;

import com.dteam.neordinarydteam.domain.member.dto.response.MemberResponse;
import com.dteam.neordinarydteam.domain.member.entity.Member;
import com.dteam.neordinarydteam.domain.member.exception.MemberException;
import com.dteam.neordinarydteam.domain.member.exception.code.MemberErrorCode;
import com.dteam.neordinarydteam.domain.member.mapper.MemberMapper;
import com.dteam.neordinarydteam.domain.member.repository.MemberRepository;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberQueryServiceImpl implements MemberQueryService {
    private final MemberRepository memberRepository;
    private final MemberMapper memberMapper;

    @Override
    public MemberResponse.RoleDTO getMemberRole(UUID uuid) {
        Member member = memberRepository
                .findByUuid(uuid)
                .orElseThrow(() -> new MemberException(MemberErrorCode.MEMBER_NOT_FOUND));

        return memberMapper.toRoleDTO(member);
    }

    @Override
    public MemberResponse.InfoDTO getMemberInfo(UUID uuid) {
        Member member = memberRepository
                .findByUuid(uuid)
                .orElseThrow(() -> new MemberException(MemberErrorCode.MEMBER_NOT_FOUND));

        return memberMapper.toInfoDTO(member);
    }
}
