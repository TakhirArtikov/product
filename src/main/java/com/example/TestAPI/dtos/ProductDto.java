package com.example.TestAPI.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {


    public int productId;
    public String productName;
    public int productSize;
    public int productPrice;

}
