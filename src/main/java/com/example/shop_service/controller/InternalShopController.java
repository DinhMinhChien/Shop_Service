package com.example.shop_service.controller;

import com.example.shop_service.common.BaseResponse;
import com.example.shop_service.dto.request.ShopCreateRequest;
import com.example.shop_service.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/internal/shops")
public class InternalShopController {
    private final ShopService shopService ;

    @PostMapping
    public ResponseEntity<BaseResponse<String>> createShop(@RequestBody ShopCreateRequest request) {
        shopService.createShop(request);
        return ResponseEntity.ok(BaseResponse.ofSuccess("Tạo thành công gian hàng ")) ;
    }

    @GetMapping
    public ResponseEntity<BaseResponse<String>> findShopIdByKeycloakUserId(@RequestParam String keycloakUserId) {
        String shopId = shopService.findShopIdByKeycloakUserId(keycloakUserId) ;
        return ResponseEntity.ok(BaseResponse.ofSuccess(shopId,"Lấy thành công shopId")) ;
    }

}
