package com.prueba1.prueba1.domain;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "revista")
public class Revista implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idRevista;

    private String titulo;
    private Date fecha;
    private int paginasRevista;

    public Revista() {

    }

    public Revista(String titulo, Date fecha, int paginasRevista) {
        this.titulo = titulo;
        this.fecha = fecha;
        this.paginasRevista = paginasRevista;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getPaginasRevista() {
        return paginasRevista;
    }

    public void setPaginasRevista(int paginasRevista) {
        this.paginasRevista = paginasRevista;
    }

}
