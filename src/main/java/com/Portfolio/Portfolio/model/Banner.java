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
@Table(name = "banner")
public class Banner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "primera_descripcion")
    private String primera_descripcion;
    @Column(name = "segunda_descripcion")
    private String segunda_descripcion;
    @Column(name = "tercera_descripcion")
    private String tercera_descripcion;
    @Column(name = "direccion_imagen")
    private String direccion_imagen;

    public Banner() {

    }

    public Banner(Long id, String primera_descripcion, String segunda_descripcion, String tercera_descripcion, String direccion_imagen) {
        this.id = id;
        this.primera_descripcion = primera_descripcion;
        this.segunda_descripcion = segunda_descripcion;
        this.tercera_descripcion = tercera_descripcion;
        this.direccion_imagen = direccion_imagen;
    }
}
