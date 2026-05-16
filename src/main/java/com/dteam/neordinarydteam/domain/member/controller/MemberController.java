package com.dteam.neordinarydteam.domain.member.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Member", description = "Member API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/examples")
public class MemberController {}
