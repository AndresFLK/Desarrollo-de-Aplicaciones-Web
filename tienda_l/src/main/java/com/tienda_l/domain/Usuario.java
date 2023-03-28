package com.tienda_l.domain;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario")
    private Long idUsuario;

    @NotEmpty
    private String username;

    @NotEmpty
    private String passowrd;

    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @OneToMany
    private List<Rol> roles;

}
