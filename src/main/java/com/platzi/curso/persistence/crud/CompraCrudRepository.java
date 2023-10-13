package com.platzi.curso.persistence.crud;

import com.platzi.curso.persistence.entity.Compra;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CompraCrudRepository extends CrudRepository<Compra, Long> {

    //query method
    Optional<List<Compra>> findByIdCliente(String idCliente);
}
