package com.Portfolio.Portfolio.service;

import com.Portfolio.Portfolio.model.Habilidades;
import java.util.List;

public interface IHabilidadesService {

    public List<Habilidades> verHabilidades();

    public Habilidades crearHabilidades(Habilidades hab);

    public void borrarHabilidades(Long id);

    public Habilidades buscarHabilidades(Long id);

    public void actualizarHabilidades(Habilidades hab);

    public void updateHabilidades(Habilidades hab);
}
