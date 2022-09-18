package com.Portfolio.Portfolio.controller;

import com.Portfolio.Portfolio.model.Proyectos;
import com.Portfolio.Portfolio.repository.ProyectosRepository;
import com.Portfolio.Portfolio.service.IProyectosService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.PATCH})
@RequestMapping(path = "/api/proyectos")
public class ProyectosController {

    @Autowired
    private IProyectosService proServ;

    @Autowired
    private ProyectosRepository proyRepo;

    @GetMapping("/lista")
    @ResponseBody
    public List<Proyectos> verProyectos() {
        return proServ.verProyectos();
    }

    @GetMapping("/detail/{id}")
    @ResponseBody
    public Proyectos buscarProyectos(@PathVariable Long id) {
        return proServ.buscarProyectos(id);
    }

    @PostMapping("/create")
    public void agregarProyectos(@RequestBody Proyectos pro) {
        proServ.crearProyectos(pro);
    }

    @DeleteMapping("/delete/{id}")
    public void borrarProyectos(@PathVariable Long id) {
        proServ.borrarProyectos(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Proyectos> updateProyectos(@PathVariable("id") Long id, @RequestBody Proyectos proyectos) {
        Optional<Proyectos> proyectosData = proyRepo.findById(id);
        if (proyectosData.isPresent()) {
            Proyectos _proyectos = proyectosData.get();
            _proyectos.setNombre_de_proyecto(proyectos.getNombre_de_proyecto());
            _proyectos.setFecha_de_realizacion(proyectos.getFecha_de_realizacion());
            _proyectos.setDescripcion_del_proyecto(proyectos.getDescripcion_del_proyecto());
            _proyectos.setLink_de_evidencia(proyectos.getLink_de_evidencia());
            _proyectos.setDireccion_imagen(proyectos.getDireccion_imagen());
            return new ResponseEntity<>(proServ.crearProyectos(_proyectos), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
