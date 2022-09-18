package com.Portfolio.Portfolio.controller;

import com.Portfolio.Portfolio.model.Experiencia;
import com.Portfolio.Portfolio.repository.ExperienciaRepository;
import com.Portfolio.Portfolio.service.IExperienciaService;
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
@RequestMapping(path = "/api/experiencia")
public class ExperienciaController {

    @Autowired
    private IExperienciaService expeServ;

    @Autowired
    private ExperienciaRepository expRepo;

    @GetMapping("/lista")
    @ResponseBody
    public List<Experiencia> verExperiencia() {
        return expeServ.verExperiencia();
    }

    @GetMapping("/detail/{id}")
    @ResponseBody
    public Experiencia buscarExperiencia(@PathVariable Long id) {
        return expeServ.buscarExperiencia(id);
    }

    @PostMapping("/create")
    public void agregarExperiencia(@RequestBody Experiencia exp) {
        expeServ.crearExperiencia(exp);
    }

    @DeleteMapping("/delete/{id}")
    public void borrarExperiencia(@PathVariable Long id) {
        expeServ.borrarExperiencia(id);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Experiencia> updateExperiencia(@PathVariable("id") Long id, @RequestBody Experiencia experiencia) {
        Optional<Experiencia> experienciaData = expRepo.findById(id);
        if (experienciaData.isPresent()) {
            Experiencia _experiencia = experienciaData.get();
            _experiencia.setLugar_de_trabajo(experiencia.getLugar_de_trabajo());
            _experiencia.setTitulo_del_puesto(experiencia.getTitulo_del_puesto());
            _experiencia.setUrl_logo_empresa(experiencia.getUrl_logo_empresa());
            _experiencia.setDescripcion_de_actividades(experiencia.getDescripcion_de_actividades());
            _experiencia.setFecha_de_actividad(experiencia.getFecha_de_actividad());
            _experiencia.setDireccion_imagen(experiencia.getDireccion_imagen());
            return new ResponseEntity<>(expeServ.crearExperiencia(_experiencia), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
