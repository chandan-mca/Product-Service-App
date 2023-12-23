package com.scaler.productserviceapp.dtos;

import lombok.Data;

@Data
public class FakeStoreProductDto {

    private Long id;
    private String title;
    private double price;
    private String description;
    private String category;
    private String image;
    private FakeStoreRatingDto rating;

}