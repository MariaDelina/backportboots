package com.Portfolio.Portfolio.controller;

import com.Portfolio.Portfolio.model.Habilidades;
import com.Portfolio.Portfolio.repository.HabilidadesRepository;
import com.Portfolio.Portfolio.service.HabilidadesService;
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
@RequestMapping(path = "/api/habilidades")
public class HabilidadesController {

    @Autowired
    private HabilidadesService habServ;

    @Autowired
    private HabilidadesRepository habRepo;

    @GetMapping("/lista")
    @ResponseBody
    public List<Habilidades> verHabilidades() {
        return habServ.verHabilidades();
    }

    @GetMapping("/detail/{id}")
    @ResponseBody
    public Habilidades buscarHabilidades(@PathVariable Long id) {
        return habServ.buscarHabilidades(id);
    }

    @PostMapping("/create")
    public Habilidades agregarHabilidades(@RequestBody Habilidades exp) {

        return habServ.crearHabilidades(exp);
    }

    @DeleteMapping("/delete/{id}")
    public void borrarHabilidades(@PathVariable Long id) {
        habServ.borrarHabilidades(id);
    }

    @PutMapping("/actualizar")
    public void actualizarHabilidades(@RequestBody Habilidades hab) {
        habServ.actualizarHabilidades(hab);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Habilidades> updateHabilidades(@PathVariable("id") Long id, @RequestBody Habilidades habilidades) {
        Optional<Habilidades> habilidadesData = habRepo.findById(id);
        if (habilidadesData.isPresent()) {
            Habilidades _habilidades = habilidadesData.get();
            _habilidades.setPorcentaje_js(habilidades.getPorcentaje_js());
            _habilidades.setPorcentaje_java(habilidades.getPorcentaje_java());
            _habilidades.setPorcentaje_angular(habilidades.getPorcentaje_angular());
            _habilidades.setPorcentaje_mysql(habilidades.getPorcentaje_mysql());
            _habilidades.setDireccion_imagen(habilidades.getDireccion_imagen());
            return new ResponseEntity<>(habServ.crearHabilidades(_habilidades), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
