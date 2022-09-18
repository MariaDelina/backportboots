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
@Table(name = "proyectos")
public class Proyectos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    
    @Column(name = "nombre_de_proyecto")
    private String nombre_de_proyecto;
    @Column(name = "fecha_de_realizacion")
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fecha_de_realizacion;
    @Column(name = "descripcion_del_proyecto")
    private String descripcion_del_proyecto;
    @Column(name = "link_de_evidencia")
    private String link_de_evidencia;
    @Column(name = "direccion_imagen")
    private String direccion_imagen;

    public Proyectos() {
    }

    public Proyectos(Long id, String nombre_de_proyecto, Date fecha_de_realizacion, String descripcion_del_proyecto, String link_de_evidencia, String direccion_imagen) {
        this.id = id;
        this.nombre_de_proyecto = nombre_de_proyecto;
        this.fecha_de_realizacion = fecha_de_realizacion;
        this.descripcion_del_proyecto = descripcion_del_proyecto;
        this.link_de_evidencia = link_de_evidencia;
        this.direccion_imagen = direccion_imagen;

    }
}
