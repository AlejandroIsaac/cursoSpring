package com.platzi.curso.domain.repository;

import com.platzi.curso.domain.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {
    List<Purchase> getAll();
    Optional<List<Purchase>> getAllByClient(String idClient);
    Purchase save(Purchase purchase);
}
