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
@Table(name = "habilidades")
public class Habilidades {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "porcentaje_js")
    private int porcentaje_js;
    @Column(name = "porcentaje_java")
    private int porcentaje_java;
    @Column(name = "porcentaje_angular")
    private int porcentaje_angular;
    @Column(name = "porcentaje_mysql")
    private int porcentaje_mysql;
    @Column(name = "direccion_imagen")
    private String direccion_imagen;

    public Habilidades() {

    }

    public Habilidades(Long id, int porcentaje_js, int porcentaje_java, int porcentaje_angular, int porcentaje_mysql, String direccion_imagen) {
        this.id = id;
        this.porcentaje_js = porcentaje_js;
        this.porcentaje_java = porcentaje_java;
        this.porcentaje_angular = porcentaje_angular;
        this.porcentaje_mysql = porcentaje_mysql;
        this.direccion_imagen = direccion_imagen;
    }
}
