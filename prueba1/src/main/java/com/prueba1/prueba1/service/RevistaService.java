package com.prueba1.prueba1.service;

import java.util.List;

import com.prueba1.prueba1.domain.Revista;

public interface RevistaService {
    public List<Revista> getRevistaList();

    public Revista getRevista(Revista revista);

    public void save(Revista revista);

    public void delete(Revista revista);
}
