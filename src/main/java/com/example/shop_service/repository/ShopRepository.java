package com.example.shop_service.repository;

import com.example.shop_service.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop,String> {
    Shop findByKeycloakOwnerId(String keycloakOwnerId);
}
