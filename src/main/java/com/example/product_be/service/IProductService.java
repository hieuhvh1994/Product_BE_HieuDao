package com.example.product_be.service;

import com.example.product_be.model.Product;

import java.time.LocalDate;

public interface IProductService extends IGeneralProduct<Product> {
    Boolean existsByName(String name);
    Boolean existsByDateOfManufacture(LocalDate date);
    Boolean existsByDescription(String description);
    Boolean existsByAvatarProduct(String avatarProduct);
}
