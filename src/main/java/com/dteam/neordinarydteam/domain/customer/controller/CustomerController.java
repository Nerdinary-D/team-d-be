package com.dteam.neordinarydteam.domain.customer.controller;

import com.dteam.neordinarydteam.domain.customer.dto.request.CustomerRequest;
import com.dteam.neordinarydteam.domain.customer.dto.response.CustomerResponse;
import com.dteam.neordinarydteam.domain.customer.service.command.CustomerCommandService;
import com.dteam.neordinarydteam.domain.customer.service.query.CustomerQueryService;
import com.dteam.neordinarydteam.global.apiPayload.code.SuccessCode;
import com.dteam.neordinarydteam.global.apiPayload.response.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Customer", description = "Customer API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customers")
public class CustomerController {
    private final CustomerCommandService customerCommandService;
    private final CustomerQueryService customerQueryService;

    @PostMapping
    public ApiResponse<CustomerResponse.CreateDTO> createCustomer(@RequestBody CustomerRequest.CreateDTO dto) {
        return ApiResponse.onSuccess(SuccessCode.CREATED, customerCommandService.createCustomer(dto));
    }

    @PatchMapping("/{uuid}")
    public ApiResponse<CustomerResponse.UpdateDTO> updateCustomer(
            @RequestBody CustomerRequest.UpdateDTO dto, @PathVariable UUID uuid) {
        return ApiResponse.onSuccess(SuccessCode.OK, customerCommandService.updateCustomer(uuid, dto));
    }

    @DeleteMapping("/{uuid}")
    public ApiResponse<CustomerResponse.DeleteDTO> deleteCustomer(@PathVariable UUID uuid) {
        return ApiResponse.onSuccess(SuccessCode.OK, customerCommandService.deleteCustomer(uuid));
    }

    @GetMapping("/{uuid}")
    public ApiResponse<CustomerResponse.MyProfileDTO> getMyProfile(@PathVariable UUID uuid) {
        return ApiResponse.onSuccess(SuccessCode.OK, customerQueryService.getMyProfile(uuid));
    }
}
