package com.example.shop_service.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShopProfileUpdateRequest {
    @NotBlank(message = "Không để trống tên cửa hàng")
    private String shopName ;

    @NotBlank(message = "Không để trống số điện thoại liên lạc ")
    private String contactPhone ;

    @NotBlank(message = "Khong để trống mô tả cho cửa hàng")
    private String descriptionShop ;

    @NotBlank(message = "Không để trống tên người liên lạc")
    private String contactName ;

    @NotBlank(message = "Không để trống mã tỉnh / thành phố")
    private String provinceCode ;

    @NotBlank(message = "Không để trống tên tỉnh / thành phố")
    private String provinceName ;

    @NotBlank(message = "Không để trống mã xã / phường ")
    private String wardCode ;

    @NotBlank(message = "Không để trống tên xã / phường ")
    private String wardName ;

    @NotBlank(message = "Không để trống địa chỉ chi tiết ")
    private String detailAddress ;
}
