package com.Portfolio.Portfolio.service;

import com.Portfolio.Portfolio.model.Habilidades;
import com.Portfolio.Portfolio.repository.HabilidadesRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HabilidadesService implements IHabilidadesService {

    @Autowired
    private HabilidadesRepository habrepo;

    @Override
    public List<Habilidades> verHabilidades() {
        return habrepo.findAll();
    }

    @Override
    public Habilidades crearHabilidades(Habilidades hab) {
        return habrepo.save(hab);
    }

    @Override
    public void borrarHabilidades(Long id) {
        habrepo.deleteById(id);
    }

    @Override
    public Habilidades buscarHabilidades(Long id) {
        return habrepo.findById(id).orElse(null);
    }

    @Override
    public void actualizarHabilidades(Habilidades hab) {
        habrepo.save(hab);
    }

    @Override
    public void updateHabilidades(Habilidades hab) {
        habrepo.save(hab);
    }

}
