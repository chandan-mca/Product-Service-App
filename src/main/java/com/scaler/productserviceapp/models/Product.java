package com.scaler.productserviceapp.models;

import lombok.Data;

@Data
public class Product {

    private Long id;
    private String title;
    private double price;
    private String description;
    private Category category;
    private String imageUrl;
    private Rating rating;
}
