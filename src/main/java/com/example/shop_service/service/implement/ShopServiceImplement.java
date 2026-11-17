package com.example.shop_service.service.implement;

import com.example.shop_service.common.BaseResponse;
import com.example.shop_service.dto.request.ShopCreateRequest;
import com.example.shop_service.dto.request.ShopProfileUpdateRequest;
import com.example.shop_service.dto.response.ShopProfileResponse;
import com.example.shop_service.entity.Shop;
import com.example.shop_service.exception.BusinessException;
import com.example.shop_service.client.CatalogClient;
import com.example.shop_service.repository.ShopRepository;
import com.example.shop_service.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShopServiceImplement implements ShopService {
    private final ShopRepository shopRepository ;
    private final CatalogClient catalogClient ;

    @Override
    public void createShop(ShopCreateRequest request) {
        Shop newShop = new Shop() ;

        newShop.setKeycloakOwnerId(request.getKeycloakOwnerId());
        newShop.setName(request.getShopName());
        newShop.setDescription(request.getDescription());
        newShop.setContactName(request.getContactName());
        newShop.setContactPhone(request.getContactPhone());
        newShop.setProvinceCode(request.getProvinceCode());
        newShop.setProvinceName(request.getProvinceName());
        newShop.setWardCode(request.getWardCode());
        newShop.setWardName(request.getWardName());
        newShop.setDetailAddress(request.getDetailAddress());
        newShop.setStatus("PENDING");

        shopRepository.save(newShop) ;
    }

    @Override
    public ShopProfileResponse getProfile(String keycloakOwnerId) {
        Shop shop = shopRepository.findByKeycloakOwnerId(keycloakOwnerId) ;
        if (shop == null) return null ;
        ShopProfileResponse response = new ShopProfileResponse();

        response.setShopId(shop.getId());
        response.setShopName(shop.getName());
        response.setContactPhone(shop.getContactPhone());
        response.setDescriptionShop(shop.getDescription());
        response.setContactName(shop.getContactName());
        response.setProvinceCode(shop.getProvinceCode());
        response.setProvinceName(shop.getProvinceName());
        response.setWardCode(shop.getWardCode());
        response.setWardName(shop.getWardName());
        response.setDetailAddress(shop.getDetailAddress());

        BaseResponse<List<String>> categories = catalogClient.getCategoryNames(shop.getId()) ;
        if (categories.getMeta().getCode() != 200 ) {
            throw new BusinessException("Lỗi lấy danh mục kinh doanh của shop") ;
        }
        response.setCategories(categories.getData());
        return response ;
    }

    @Override
    public void updateProfile(String keycloakOwnerId, ShopProfileUpdateRequest request) {
        Shop shop = shopRepository.findByKeycloakOwnerId(keycloakOwnerId) ;
        if (shop == null) return;

        shop.setName(request.getShopName());
        shop.setContactPhone(request.getContactPhone());
        shop.setDescription(request.getDescriptionShop());
        shop.setContactName(request.getContactName());
        shop.setProvinceCode(request.getProvinceCode());
        shop.setProvinceName(request.getProvinceName());
        shop.setWardCode(request.getWardCode());
        shop.setWardName(request.getWardName());
        shop.setDetailAddress(request.getDetailAddress());

        shopRepository.save(shop) ;
    }

    @Override
    public String findShopIdByKeycloakUserId(String keycloakUserId) {
        Shop shop = shopRepository.findByKeycloakOwnerId(keycloakUserId) ;
        if (shop == null) throw new BusinessException("Không tồn tại cửa hàng có keycloakOwnerId là : "+keycloakUserId) ;
        return shop.getId() ;
    }

}
