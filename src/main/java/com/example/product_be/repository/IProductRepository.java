package com.example.product_be.repository;

import com.example.product_be.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
    Boolean existsByName(String name);
    Boolean existsByDateOfManufacture(LocalDate date);
    Boolean existsByDescription(String description);
    Boolean existsByAvatarProduct(String avatarProduct);
}
