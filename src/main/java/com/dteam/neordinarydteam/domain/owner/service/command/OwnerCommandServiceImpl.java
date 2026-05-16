package com.dteam.neordinarydteam.domain.owner.service.command;

import com.dteam.neordinarydteam.domain.member.entity.Member;
import com.dteam.neordinarydteam.domain.member.enums.MemberRole;
import com.dteam.neordinarydteam.domain.member.mapper.MemberMapper;
import com.dteam.neordinarydteam.domain.member.repository.MemberRepository;
import com.dteam.neordinarydteam.domain.owner.dto.request.OwnerRequest;
import com.dteam.neordinarydteam.domain.owner.dto.response.OwnerResponse;
import com.dteam.neordinarydteam.domain.owner.entity.Owner;
import com.dteam.neordinarydteam.domain.owner.exception.OwnerException;
import com.dteam.neordinarydteam.domain.owner.exception.code.OwnerErrorCode;
import com.dteam.neordinarydteam.domain.owner.mapper.OwnerMapper;
import com.dteam.neordinarydteam.domain.owner.repository.OwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class OwnerCommandServiceImpl implements OwnerCommandService {
    private final OwnerRepository ownerRepository;
    private final OwnerMapper ownerMapper;
    private final MemberMapper memberMapper;
    private final MemberRepository memberRepository;

    @Override
    public OwnerResponse.CreateDTO createOwner(OwnerRequest.CreateDTO dto) {
        if (memberRepository.existsByUuid(dto.uuid())) {
            throw new OwnerException(OwnerErrorCode.OWNER_ALREADY_EXISTS);
        }
        Member savedMember = memberRepository.save(memberMapper.toCreateEntity(dto.uuid(), MemberRole.ROLE_OWNER));

        Owner savedOwner = ownerRepository.save(ownerMapper.toCreateEntity(savedMember));

        return ownerMapper.toCreateDTO(savedMember.getUuid(), savedOwner);
    }
}
