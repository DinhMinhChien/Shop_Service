package com.example.shop_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "shops")
public class Shop extends BaseEntity {
    @Id
    @UuidGenerator
    @Column(name = "id")
    private String id ;

    @Column(name = "keycloak_owner_id")
    private String keycloakOwnerId ;

    @Column(name = "name")
    private String name ;

    @Column(name = "logo_url")
    private String logoUrl ;

    @Column(name = "description")
    private String description ;

    @Column(name = "contact_name")
    private String contactName ;

    @Column(name = "contact_phone")
    private String contactPhone ;

    @Column(name = "province_code")
    private String provinceCode ;

    @Column(name = "province_name")
    private String provinceName ;

    @Column(name = "ward_code")
    private String wardCode ;

    @Column(name = "ward_name")
    private String wardName ;

    @Column(name = "detail_address")
    private String detailAddress ;

    @Column(name = "status")
    private String status ;

    @Column(name = "reviewed_by")
    private String reviewedBy ;

    @Column(name = "reviewed_at")
    private String reviewedAt ;



}
