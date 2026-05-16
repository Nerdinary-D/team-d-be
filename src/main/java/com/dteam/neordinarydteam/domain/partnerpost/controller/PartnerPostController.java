package com.dteam.neordinarydteam.domain.partnerpost.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "PartnerPost", description = "PartnerPost API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/examples")
public class PartnerPostController {}
