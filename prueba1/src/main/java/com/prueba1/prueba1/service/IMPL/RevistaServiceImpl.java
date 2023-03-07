package com.prueba1.prueba1.service.IMPL;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prueba1.prueba1.domain.Revista;
import com.prueba1.prueba1.service.RevistaService;
import com.prueba1.prueba1.dao.RevistaDao;

@Service
public class RevistaServiceImpl implements RevistaService {

    private RevistaDao revistaDao;

    @Autowired
    public RevistaServiceImpl(RevistaDao revistaDao) {
        this.revistaDao = revistaDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Revista> getRevistaList() {
        return (List<Revista>) revistaDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Revista getRevista(Revista revista) {
        return revistaDao.findById(revista.getIdRevista()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Revista revista) {
        revistaDao.save(revista);
    }

    @Override
    public void delete(Revista revista) {
        revistaDao.delete(revista);
    }

}
