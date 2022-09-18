package com.Portfolio.Portfolio.controller;

import com.Portfolio.Portfolio.model.Educacion;
import com.Portfolio.Portfolio.repository.EducacionRepository;
import com.Portfolio.Portfolio.service.IEducacionService;
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
@RequestMapping(path = "/api/educacion")
public class EducacionController {

    @Autowired
    private IEducacionService educServ;

    @Autowired
    private EducacionRepository eduRepo;

    @GetMapping("/lista")
    @ResponseBody
    public List<Educacion> verEducacion() {
        return educServ.verEducacion();
    }

    @GetMapping("/detail/{id}")
    @ResponseBody
    public Educacion buscarEducacion(@PathVariable Long id) {
        return educServ.buscarEducacion(id);
    }

    @PostMapping("/create")
    public void agregarEducacion(@RequestBody Educacion educ) {
        educServ.crearEducacion(educ);
    }

    @DeleteMapping("/delete/{id}")
    public void borrarEducacion(@PathVariable Long id) {
        educServ.borrarEducacion(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Educacion> updateEducacion(@PathVariable("id") Long id, @RequestBody Educacion educacion) {
        Optional<Educacion> educacionData = eduRepo.findById(id);
        if (educacionData.isPresent()) {
            Educacion _educacion = educacionData.get();
            _educacion.setCertificaciones(educacion.getCertificaciones());
            _educacion.setInfo_de_instituto(educacion.getInfo_de_instituto());
            _educacion.setUrl_logo_instituto(educacion.getUrl_logo_instituto());
            _educacion.setNombre_carrera(educacion.getNombre_carrera());
            _educacion.setDesde_periodo_ano(educacion.getDesde_periodo_ano());
            _educacion.setHasta_periodo_ano(educacion.getHasta_periodo_ano());
            _educacion.setDireccion_imagen(educacion.getDireccion_imagen());
            return new ResponseEntity<>(educServ.crearEducacion(_educacion), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
