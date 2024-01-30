package com.example.TestAPI.service.serviceImpl;

import com.example.TestAPI.dtos.ProductDto;
import com.example.TestAPI.entity.ProductEntity;
import com.example.TestAPI.repository.ProductRepository;

import com.example.TestAPI.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    @Override
    public void delele(int id) {
        Optional<ProductEntity> entity = repository.findById(id);
        repository.delete(entity.get());
    }

    @Override
    public void update(ProductDto dto) {
        Optional<ProductEntity> entity = repository.findById(dto.productId);
        entity.get().setProductName(dto.productName);
        entity.get().setProductPrice(dto.getProductPrice());
        entity.get().setProductSize(dto.productSize);
        repository.save(entity.get());
    }

    @Override
    public void add(ProductDto dto) {
        ProductEntity entity = new ProductEntity();
        entity.setProductName(dto.productName);
        entity.setProductPrice(dto.getProductPrice());
        entity.setProductSize(dto.productSize);
        repository.save(entity);
    }

    @Override
    public ProductDto getProduct(int id) {
        Optional<ProductEntity> entity = repository.findById(id);
        ProductDto dto = new ProductDto();
        dto.setProductPrice(entity.get().productPrice);
        dto.setProductName(entity.get().productName);
        dto.setProductSize(entity.get().productSize);
        dto.setProductId(entity.get().productId);
        return dto;
    }

    @Override
    public List<ProductDto> getAllProduct() {
        List<ProductEntity> entities = repository.findAll();
        List<ProductDto> dtos = new ArrayList<>();
        for (ProductEntity entity : entities) {
            ProductDto dto = new ProductDto();
            dto.setProductPrice(entity.productPrice);
            dto.setProductName(entity.productName);
            dto.setProductSize(entity.productSize);
            dto.setProductId(entity.productId);
            dtos.add(dto);
        }

        return dtos;
    }

    @Override
    public int sumProductSize() {

        return repository.findAll().stream().mapToInt(ProductEntity::getProductSize).sum();

    }
}
