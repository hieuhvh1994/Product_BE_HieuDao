package com.example.product_be.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 3, max = 50)
    private String name;

    @NotBlank
    private LocalDate dateOfManufacture;
    private String avatarProduct;

    @NotBlank
    @Size(min = 2, max = 200)
    private String description;

    public Product() {
    }

    public Product(String name, LocalDate dateOfManufacture, String description) {
        this.name = name;
        this.dateOfManufacture = dateOfManufacture;
        this.description = description;
    }

    public Product(String name, LocalDate dateOfManufacture, String avatarProduct, String description) {
        this.name = name;
        this.dateOfManufacture = dateOfManufacture;
        this.avatarProduct = avatarProduct;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfManufacture() {
        return dateOfManufacture;
    }

    public void setDateOfManufacture(LocalDate dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }

    public String getAvatarProduct() {
        return avatarProduct;
    }

    public void setAvatarProduct(String avatarProduct) {
        this.avatarProduct = avatarProduct;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
