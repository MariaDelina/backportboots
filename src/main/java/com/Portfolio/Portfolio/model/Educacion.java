package com.Portfolio.Portfolio.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "educacion")
public class Educacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "certificaciones")
    private String certificaciones;
    @Column(name = "info_de_instituto")
    private String info_de_instituto;
    @Column(name = "url_logo_instituto")
    private String url_logo_instituto;
    @Column(name = "nombre_carrera")
    private String nombre_carrera;
    @Column(name = "desde_periodo_ano")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date desde_periodo_ano;
    @Column(name = "hasta_periodo_ano")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date hasta_periodo_ano;
    @Column(name = "direccion_imagen")
    private String direccion_imagen;
    public Educacion() {
    }

    public Educacion(Long id, String certificaciones, String info_de_instituto, String url_logo_instituto, String nombre_carrera, Date desde_periodo_ano, Date hasta_periodo_ano, String direccion_imagen) {
        this.id = id;
        this.certificaciones = certificaciones;
        this.info_de_instituto = info_de_instituto;
        this.url_logo_instituto = url_logo_instituto;
        this.nombre_carrera = nombre_carrera;
        this.desde_periodo_ano = desde_periodo_ano;
        this.hasta_periodo_ano = hasta_periodo_ano;
        this.direccion_imagen = direccion_imagen;
    }
}
