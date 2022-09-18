package com.Portfolio.Portfolio.service;

import com.Portfolio.Portfolio.model.Presentacion;
import java.util.List;

public interface IPresentacionService {

    public List<Presentacion> verPresentacion();

    public Presentacion crearPresentacion(Presentacion pres);

    public void borrarPresentacion(Long id);

    public Presentacion buscarPresentacion(Long id);
}
