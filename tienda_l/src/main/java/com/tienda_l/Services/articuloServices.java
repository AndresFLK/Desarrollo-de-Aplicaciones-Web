package com.tienda_l.Services;

import java.util.List;

import com.tienda_l.domain.Articulo;

public interface articuloServices {
    public List<Articulo> getArticulos(boolean activos);

    public Articulo geArticulo(Articulo articulo);

    public void save(Articulo articulo);

    public void delete(Articulo articulo);
}
