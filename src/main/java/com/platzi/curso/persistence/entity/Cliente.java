package com.platzi.curso.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {

    //Id no sera consecutivo automatigo
    @Id
    @Getter
    private String id;

    @Getter @Setter
    private String nombre;

    @Getter @Setter
    private String apellidos;

    @Getter @Setter
    private Long celular;

    @Getter @Setter
    private String direccion;

    @Getter @Setter
    @Column(name = "correo_electronico")
    private String correoElectronico;

    //Relacion con Compras
    @OneToMany(mappedBy = "cliente")
    @Getter @Setter
    private List<Compra> compras;
}
