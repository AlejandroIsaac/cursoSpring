package com.platzi.curso.domain.service;

import com.platzi.curso.domain.Purchase;
import com.platzi.curso.domain.repository.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PurchaseService {

    //Acceso al repositorio
    @Autowired
    private PurchaseRepository purchaseRepository;

    public List<Purchase> getAll(){
        return purchaseRepository.getAll();
    }

    public Optional<List<Purchase>> getAllByClient(String idClient){
        return purchaseRepository.getAllByClient(idClient);
    }

    public Purchase save(Purchase purchase){
        return purchaseRepository.save(purchase);
    }



}
