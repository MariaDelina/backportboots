package com.Portfolio.Portfolio.controller;

import com.Portfolio.Portfolio.model.Presentacion;
import com.Portfolio.Portfolio.repository.PresentacionRepository;
import com.Portfolio.Portfolio.service.IPresentacionService;
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
@RequestMapping(path = "/api/presentacion")
public class PresentacionController {

    @Autowired
    private IPresentacionService presServ;

    @Autowired
    private PresentacionRepository presRepo;

    @GetMapping("/lista")
    @ResponseBody
    public List<Presentacion> verPresentacion() {
        return presServ.verPresentacion();
    }

    @GetMapping("/detail/{id}")
    @ResponseBody
    public Presentacion buscarPresentacion(@PathVariable Long id) {
        return presServ.buscarPresentacion(id);
    }

    @PostMapping("/create")
    public void agregarPresentacion(@RequestBody Presentacion pre) {
        presServ.crearPresentacion(pre);
    }

    @DeleteMapping("/delete/{id}")
    public void borrarPresentacion(@PathVariable Long id) {
        presServ.borrarPresentacion(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Presentacion> updatePresentacion(@PathVariable("id") Long id, @RequestBody Presentacion presentacion) {
        Optional<Presentacion> presentacionData = presRepo.findById(id);
        if (presentacionData.isPresent()) {
            Presentacion _presentacion = presentacionData.get();
            _presentacion.setNombre_y_apellido(presentacion.getNombre_y_apellido());
            _presentacion.setPuesto(presentacion.getPuesto());
            _presentacion.setLinkedin(presentacion.getLinkedin());
            _presentacion.setGithub(presentacion.getGithub());
            _presentacion.setDireccion_imagen(presentacion.getDireccion_imagen());
            return new ResponseEntity<>(presServ.crearPresentacion(_presentacion), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
