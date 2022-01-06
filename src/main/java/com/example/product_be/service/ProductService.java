package com.example.product_be.service;

import com.example.product_be.model.Product;
import com.example.product_be.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void remove(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Boolean existsByName(String name) {
        return productRepository.existsByName(name);
    }

    @Override
    public Boolean existsByDateOfManufacture(LocalDate date) {
        return productRepository.existsByDateOfManufacture(date);
    }

    @Override
    public Boolean existsByDescription(String description) {
        return productRepository.existsByDescription(description);
    }

    @Override
    public Boolean existsByAvatarProduct(String avatarProduct) {
        return this.productRepository.existsByAvatarProduct(avatarProduct);
    }
}
