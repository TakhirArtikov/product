package com.example.TestAPI.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product")
public class ProductEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int productId;
    @Column(name = "product_name")
    public String productName;
    @Column(name = "product_size")
    public int productSize;

    @Column(name = "product_price")
    public int productPrice;

}
