package com.scaler.productserviceapp.services;

import com.scaler.productserviceapp.dtos.FakeStoreProductDto;
import com.scaler.productserviceapp.dtos.FakeStoreRatingDto;
import com.scaler.productserviceapp.models.Category;
import com.scaler.productserviceapp.models.Product;
import com.scaler.productserviceapp.models.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeStoreProductService implements ProductService {

    private RestTemplate restTemplate;

    @Autowired
    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private Product convertFakeStoreProductToProduct(FakeStoreProductDto fakeStoreProduct) {
        Product product = new Product();
        product.setId(fakeStoreProduct.getId());
        product.setTitle(fakeStoreProduct.getTitle());
        product.setPrice(fakeStoreProduct.getPrice());
        product.setDescription(fakeStoreProduct.getDescription());
        product.setImageUrl(fakeStoreProduct.getImage());

        product.setCategory(new Category());
        product.getCategory().setName(fakeStoreProduct.getCategory());

        product.setRating(new Rating());
        product.getRating().setRate(fakeStoreProduct.getRating().getRate());
        product.getRating().setCount(fakeStoreProduct.getRating().getCount());

        return product;
    }

    @Override
    public Product getSingleProduct(Long id) {
        FakeStoreProductDto fakeStoreProductDto = restTemplate.getForObject(
                "https://fakestoreapi.com/products/" + id,
                FakeStoreProductDto.class
        );

        return convertFakeStoreProductToProduct(fakeStoreProductDto);
    }
}
