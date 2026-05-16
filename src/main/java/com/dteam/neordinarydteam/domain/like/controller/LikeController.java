package com.dteam.neordinarydteam.domain.like.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Like", description = "Like API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/likes")
public class LikeController {}
