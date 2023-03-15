package com.tienda_l.Services;

import java.util.List;

import com.tienda_l.domain.Categoria;

public interface categoriaServices {
    public List<Categoria> getCategorias(boolean activos);

    public Categoria geCategoria(Categoria categoria);

    public void save(Categoria categoria);

    public void delete(Categoria categoria);
}
