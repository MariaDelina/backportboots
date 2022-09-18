package com.Portfolio.Portfolio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "presentacion")
public class Presentacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nombre_y_apellido")
    private String nombre_y_apellido;
    @Column(name = "puesto")
    private String puesto;
    @Column(name = "linkedin")
    private String linkedin;
    @Column(name = "github")
    private String github;
    @Column(name = "direccion_imagen")
    private String direccion_imagen;

    public Presentacion() {
    }

    public Presentacion(Long id, String nombre_y_apellido, String puesto, String linkedin, String github, String direccion_imagen) {
        this.id = id;
        this.nombre_y_apellido = nombre_y_apellido;
        this.puesto = puesto;
        this.linkedin = linkedin;
        this.github = github;
        this.direccion_imagen = direccion_imagen;

    }

}
