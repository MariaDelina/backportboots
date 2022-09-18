package com.Portfolio.Portfolio.service;

import com.Portfolio.Portfolio.model.Experiencia;
import java.util.List;

public interface IExperienciaService {

    public List<Experiencia> verExperiencia();

    public Experiencia crearExperiencia(Experiencia expe);

    public void borrarExperiencia(Long id);

    public Experiencia buscarExperiencia(Long id);
}
