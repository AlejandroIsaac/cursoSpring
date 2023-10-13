package com.platzi.curso.web.controller;

import com.platzi.curso.domain.Product;
import com.platzi.curso.domain.service.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    @ApiOperation("Get all products")
    @ApiResponse(code=  200, message = "OK")
    public ResponseEntity<List<Product>> getAll(){
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/category/{idCategory}")
    public ResponseEntity<List<Product>>  getByCategory(@PathVariable("idCategory") int idCategory){
        return new ResponseEntity<>(productService.getAllByCategory(idCategory), HttpStatus.OK);
    }

    @GetMapping("/{idProduct}")
    public ResponseEntity<Product> getById(@PathVariable("idProduct") int idProduct){
        return productService.getProduct(idProduct)
                .map(product -> new ResponseEntity<>(product, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    public ResponseEntity<Product> save(@RequestBody Product product){
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }

    @DeleteMapping("/{idProduct}")
    public ResponseEntity delete(@PathVariable("idProduct") int idProduct){

        return productService.delete(idProduct)
                ? new ResponseEntity(HttpStatus.OK) : new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
