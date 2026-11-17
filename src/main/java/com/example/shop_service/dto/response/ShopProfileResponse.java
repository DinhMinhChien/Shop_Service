package com.example.shop_service.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShopProfileResponse {
    private String shopId ;
    private String shopName ;
    private List<String> categories ;
    private String contactPhone;
    private String descriptionShop ;
    private String contactName ;
    private String provinceName ;
    private String provinceCode ;
    private String wardCode ;
    private String wardName ;
    private String detailAddress ;
    private String logoUrl ;
    private String coverUrl ;

}
