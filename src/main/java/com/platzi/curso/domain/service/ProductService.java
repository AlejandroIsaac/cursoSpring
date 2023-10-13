package com.platzi.curso.domain.service;

import com.platzi.curso.domain.Product;
import com.platzi.curso.domain.repository.ProductRepository;
import com.platzi.curso.persistence.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAll(){
        return productRepository.getAll();
    }

    public List<Product> getAllByCategory(int idCategoria){
        return productRepository.getByCategory(idCategoria);
    }

    public Optional<Product> getProduct(int idProduct){
        return productRepository.getById(idProduct);
    }

    public Product save(Product product){
        return productRepository.save(product);
    }

    public boolean delete(int idProduct){
        if(getProduct(idProduct).isPresent()){
            productRepository.delete(idProduct);
            return true;
        }else return false;

    }

}
