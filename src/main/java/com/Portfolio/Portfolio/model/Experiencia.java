package com.Portfolio.Portfolio.model;

import com.fasterxml.jackson.annotation.JsonFormat;
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
@Table(name = "experiencia")
public class Experiencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "lugar_de_trabajo")
    private String lugar_de_trabajo;
    @Column(name = "titulo_del_puesto")
    private String titulo_del_puesto;
    @Column(name = "url_logo_empresa")
    private String url_logo_empresa;
    @Column(name = "descripcion_de_actividades")
    private String descripcion_de_actividades;
    @Column(name = "fecha_de_actividad")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha_de_actividad;
    @Column(name = "direccion_imagen")
    private String direccion_imagen;

    public Experiencia() {
    }

    public Experiencia(Long id, String lugar_de_trabajo, String titulo_del_puesto, String url_logo_empresa, String descripcion_de_actividades, Date fecha_de_actividad, String direccion_imagen) {
        this.id = id;
        this.lugar_de_trabajo = lugar_de_trabajo;
        this.titulo_del_puesto = titulo_del_puesto;
        this.url_logo_empresa = url_logo_empresa;
        this.descripcion_de_actividades = descripcion_de_actividades;
        this.fecha_de_actividad = fecha_de_actividad;
        this.direccion_imagen = direccion_imagen;
    }

}
