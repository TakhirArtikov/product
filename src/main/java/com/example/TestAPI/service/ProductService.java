package com.example.TestAPI.service;


import com.example.TestAPI.dtos.ProductDto;

import java.util.List;

public interface ProductService {
    void delele(int id);
    void update(ProductDto dto);
    void add(ProductDto dto);
    ProductDto getProduct(int id);
    List<ProductDto> getAllProduct();

    int sumProductSize();
}
