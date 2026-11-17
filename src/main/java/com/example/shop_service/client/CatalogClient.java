package com.example.shop_service.client;

import com.example.shop_service.common.BaseResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "catalog-service")
public interface CatalogClient {
    @GetMapping("/v1/internal/categories")
    BaseResponse<List<String>> getCategoryNames(@RequestParam String shopId) ;
}
