package com.asset.assetmanagement.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    private String categoryType;

    private String categoryName;

    private String description;
}
