package com.platzi.curso.persistence;

import com.platzi.curso.domain.Purchase;
import com.platzi.curso.domain.repository.PurchaseRepository;
import com.platzi.curso.persistence.crud.CompraCrudRepository;
import com.platzi.curso.persistence.entity.Compra;
import com.platzi.curso.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository implements PurchaseRepository {

    //acceso a datos
    @Autowired
    private CompraCrudRepository compraCrudRepository;
    //convertir Compra a purchase
    @Autowired
    private PurchaseMapper mapper;

    @Override
    public List<Purchase> getAll() {
        List<Compra> compras = (List<Compra>) compraCrudRepository.findAll();
        return mapper.toPurchases(compras);
        //return mapper.toPurchases((List<Compra>) compraCrudRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getAllByClient(String idClient) {
        return compraCrudRepository.findByIdCliente(idClient)
                .map(compras -> mapper.toPurchases(compras));

    }

    @Override
    public Purchase save(Purchase purchase) {
        Compra compra = mapper.toCompra(purchase);

        compra.getProductos().forEach(producto -> producto.setCompra(compra));
        System.out.println("************************");
        return mapper.toPurchase(compraCrudRepository.save(compra));
    }
}
