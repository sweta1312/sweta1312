package com.asset.assetmanagement.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class CategoryDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String assetName;

    private String productType;

    private String productName;

    private String model;

    private String operatingSystem;

    private String serviceTag;

    private String assetStore;

    private String user;

    private String department;

    private String productSerialNo;

    private String purchaseCost;

    private String vendor;

    private String manufacturer;

    private String purchaseType;

    private String purchaseDate;

    private String warrantyExpiryDate;

    private String dscription;

    private String assignTo;

    private String location;
}
