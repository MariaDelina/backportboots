package com.Portfolio.Portfolio.service;

import com.Portfolio.Portfolio.model.Proyectos;
import java.util.List;

public interface IProyectosService {

    public List<Proyectos> verProyectos();

    public Proyectos crearProyectos(Proyectos pro);

    public void borrarProyectos(Long id);

    public Proyectos buscarProyectos(Long id);
}
