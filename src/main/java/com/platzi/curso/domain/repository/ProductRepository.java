package com.platzi.curso.domain.repository;

import com.platzi.curso.domain.Product;
import com.platzi.curso.persistence.entity.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> getAll();
    Optional<Product> getById(int idProduct);
    List<Product> getByCategory(int idCategory);
    Product save(Product product);
    void delete(int idProduct);
}
