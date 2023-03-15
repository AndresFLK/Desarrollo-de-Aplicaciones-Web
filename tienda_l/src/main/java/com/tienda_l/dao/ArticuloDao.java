package com.tienda_l.dao;

import com.tienda_l.domain.Articulo;
import org.springframework.data.repository.CrudRepository;

public interface ArticuloDao extends CrudRepository<Articulo, Long> {

}
