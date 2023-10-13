package com.platzi.curso.persistence.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="categorias")
public class Categoria implements Serializable {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "id_categoria")
     private Long idCategoria;

     private String descripcion;

     private Boolean estado;

     //relacion con Producto
     @OneToMany(mappedBy = "categoria")
     private List<Producto> productos;

     public Long getIdCategoria() {
          return idCategoria;
     }

     public void setIdCategoria(Long idCategoria) {
          this.idCategoria = idCategoria;
     }

     public String getDescripcion() {
          return descripcion;
     }

     public void setDescripcion(String descripcion) {
          this.descripcion = descripcion;
     }

     public Boolean getEstado() {
          return estado;
     }

     public void setEstado(Boolean estado) {
          this.estado = estado;
     }

     public List<Producto> getProductos() {
          return productos;
     }

     public void setProductos(List<Producto> productos) {
          this.productos = productos;
     }
}
