package com.platzi.curso.persistence;

import com.platzi.curso.domain.Product;
import com.platzi.curso.domain.repository.ProductRepository;
import com.platzi.curso.persistence.crud.ProductoCrudRepository;
import com.platzi.curso.persistence.entity.Producto;
import com.platzi.curso.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository implements ProductRepository {

    //instancia para operar la DB
    @Autowired
    private ProductoCrudRepository productoCrudRepository;
    //instancia para convertir Producto a Product
    @Autowired
    private ProductMapper mapper;

    @Override
    public List<Product> getAll() {
        List<Producto> productos= (List<Producto>) productoCrudRepository.findAll();

        return mapper.toProducts(productos);
    }

    @Override
    public Optional<Product> getById(int idProduct) {
        Long id = Long.valueOf(idProduct);
        Optional<Producto> producto = productoCrudRepository.findById(id);
        return producto.map(producto1 -> mapper.toProduct(producto1));
    }

    @Override
    public List<Product> getByCategory(int idCategory) {
        Long id = Long.valueOf(idCategory);
        List<Producto> productos= productoCrudRepository.findByIdCategoria(id);
        return mapper.toProducts(productos);
    }

    @Override
    public Product save(Product product) {
        Producto producto = mapper.toProducto(product);
        Producto productoCreado =productoCrudRepository.save(producto);
        return mapper.toProduct(productoCreado);
    }

    @Override
    public void delete(int idProduct) {
        Long id = Long.valueOf(idProduct);
        productoCrudRepository.deleteById(id);

    }


    /*private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll(){
        return (List<Producto>) productoCrudRepository.findAll();
    }

    public Optional<Producto> getById(Long id){
        return productoCrudRepository.findById(id);
    }

    public List<Producto> getByCategoria(Long idCategoria){
        return productoCrudRepository.findByIdCategoria(idCategoria);
    }
    public Producto save(Producto producto){
        return productoCrudRepository.save(producto);
    }

    public void delete(Long idProducto){
         productoCrudRepository.deleteById(idProducto);
    }*/

}
