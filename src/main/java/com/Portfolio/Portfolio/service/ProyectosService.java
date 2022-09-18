package com.Portfolio.Portfolio.service;

import com.Portfolio.Portfolio.model.Proyectos;
import com.Portfolio.Portfolio.repository.ProyectosRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProyectosService implements IProyectosService {

    @Autowired
    private ProyectosRepository proyRepo;

    @Override
    public List<Proyectos> verProyectos() {
        return proyRepo.findAll();
    }

    @Override
    public Proyectos crearProyectos(Proyectos proy) {
        return proyRepo.save(proy);
    }

    @Override
    public void borrarProyectos(Long id) {
        proyRepo.deleteById(id);
    }

    @Override
    public Proyectos buscarProyectos(Long id) {
        return proyRepo.findById(id).orElse(null);
    }

}
