package com.example.shop_service.controller;

import com.example.shop_service.common.BaseResponse;
import com.example.shop_service.dto.request.ShopProfileUpdateRequest;
import com.example.shop_service.dto.response.ShopProfileResponse;
import com.example.shop_service.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/shops")
public class ExternalShopController {
    private final ShopService shopService ;

    @PreAuthorize("hasAnyRole('SELLER')")
    @GetMapping("/profile")
    public ResponseEntity<BaseResponse<ShopProfileResponse>> getProfile(@RequestHeader("X-Keycloak-User-Id") String keycloakOwnerId) {
        ShopProfileResponse response = shopService.getProfile(keycloakOwnerId);
        return ResponseEntity.ok(BaseResponse.ofSuccess(response,"Lấy profile cửa hàng thành công")) ;
    }

    @PreAuthorize("hasAnyRole('SELLER')")
    @PutMapping("/profile")
    public ResponseEntity<BaseResponse<String>> updateProfile(
            @RequestHeader("X-Keycloak-User-Id") String keycloakOwnerId,
            @RequestBody ShopProfileUpdateRequest request
    ) {
        shopService.updateProfile(keycloakOwnerId,request);
        return ResponseEntity.ok(BaseResponse.ofSuccess("Update profile của cửa hàng thành công")) ;
    }

}
