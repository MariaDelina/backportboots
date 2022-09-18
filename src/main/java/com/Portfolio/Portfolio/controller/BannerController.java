
package com.Portfolio.Portfolio.controller;


import com.Portfolio.Portfolio.model.Banner;
import com.Portfolio.Portfolio.repository.BannerRepository;
import com.Portfolio.Portfolio.service.IBannerService;
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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.PATCH})
@RequestMapping(path="/api/banner")
public class BannerController {
    
    @Autowired
    private IBannerService baneServ;
    @Autowired
    private BannerRepository baneRepo;
       
    @GetMapping("/lista")
    @ResponseBody
    public List<Banner> verBanner(){
        return baneServ.verBanner();
    }
    
    @GetMapping("/detail/{id}")
    @ResponseBody
    public Banner buscarBanner(@PathVariable Long id){
       return baneServ.buscarBanner(id);
    }
         
    @PostMapping("/create")
    public void agregarBanner(@RequestBody Banner bane){
        baneServ.crearBanner(bane);
    }
    @DeleteMapping("/delete/{id}")
    public void borrarBanner(@PathVariable Long id){
        baneServ.borrarBanner(id);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<Banner> updateBanner(@PathVariable("id") Long id, @RequestBody Banner banner){
        Optional<Banner> bannerData = baneRepo.findById (id);
        if(bannerData.isPresent()){
            Banner _banner = bannerData.get();
            _banner.setPrimera_descripcion(banner.getPrimera_descripcion());
            _banner.setSegunda_descripcion(banner.getSegunda_descripcion());
            _banner.setTercera_descripcion(banner.getTercera_descripcion());
            _banner.setDireccion_imagen(banner.getDireccion_imagen());
            return new ResponseEntity<> (baneServ.crearBanner( _banner), HttpStatus.OK);
                    }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
