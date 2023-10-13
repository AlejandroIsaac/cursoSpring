package com.platzi.curso.web.controller;

import com.platzi.curso.domain.Purchase;
import com.platzi.curso.domain.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PostRemove;
import java.util.List;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    //inyeccion de dependencias Service
    @Autowired
    private PurchaseService purchaseService;

    @GetMapping
    ResponseEntity<List<Purchase>> getAll(){
        try {
            return new ResponseEntity<>(purchaseService.getAll(), HttpStatus.OK);
        }catch (RuntimeException ex){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/client/{idClient}")
    ResponseEntity<List<Purchase>> getByClient(@PathVariable("idClient") String idClient){
        return purchaseService.getAllByClient(idClient)
                .map(purchases -> new ResponseEntity<>(purchases, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @PostMapping
    ResponseEntity<Purchase> save(@RequestBody Purchase purchase){
        //try {
            return new ResponseEntity<>(purchaseService.save(purchase), HttpStatus.CREATED);
        //}catch (RuntimeException ex){
            //return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       // }

    }

}
