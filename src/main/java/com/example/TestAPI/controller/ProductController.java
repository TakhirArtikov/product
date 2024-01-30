package com.example.TestAPI.controller;

import com.example.TestAPI.dtos.ProductDto;
import com.example.TestAPI.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;

    @GetMapping("/{id}")
    public ProductDto getProduct(@PathVariable int id){
        return service.getProduct(id);
    }

    @GetMapping("/all")
    public List<ProductDto> getAllProducts(){
        return service.getAllProduct();
    }
    @PostMapping
    public void addProduct(@RequestBody ProductDto dto){
        service.add(dto);
    }

    @PutMapping
    public void updateProduct(@RequestBody ProductDto dto){
        service.update(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id){

        service.delele(id);
    }
    @GetMapping("/sum-size")
    public int sumProductSize(){
       return service.sumProductSize();

    }

}
