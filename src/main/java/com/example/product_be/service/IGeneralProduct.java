package com.example.product_be.service;

import java.util.Optional;

public interface IGeneralProduct<T> {
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    T save(T t);

    void remove(Long id);
}
