package com.platzi.curso.persistence.mapper;

import com.platzi.curso.domain.Category;
import com.platzi.curso.persistence.entity.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    /*metodo que convierte Categoria a Category*/
    @Mappings({
            @Mapping(source = "idCategoria", target = "idCategory"),
            @Mapping(source = "descripcion", target = "description"),
            @Mapping(source = "estado", target = "active")
    })
    Category toCategory(Categoria categoria);

    /*metodo que convierte Category a Categoria*/
    @InheritInverseConfiguration//
    @Mapping(target = "productos", ignore = true)
    Categoria toCategoria(Category category);
}
