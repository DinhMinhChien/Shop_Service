package com.example.shop_service.service;

import com.example.shop_service.dto.request.ShopCreateRequest;
import com.example.shop_service.dto.request.ShopProfileUpdateRequest;
import com.example.shop_service.dto.response.ShopProfileResponse;

public interface ShopService {
    void createShop(ShopCreateRequest request) ;
    ShopProfileResponse getProfile(String keycloakOwnerId) ;
    void updateProfile(String keycloakOwnerId, ShopProfileUpdateRequest request) ;
    String findShopIdByKeycloakUserId(String keycloakUserId) ;
}
