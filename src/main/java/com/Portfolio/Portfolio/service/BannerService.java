package com.Portfolio.Portfolio.service;

import com.Portfolio.Portfolio.model.Banner;
import com.Portfolio.Portfolio.repository.BannerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BannerService implements IBannerService {

    @Autowired
    private BannerRepository banRepo;

    @Override
    public List<Banner> verBanner() {
        return banRepo.findAll();
    }

    @Override
    public Banner crearBanner(Banner ban) {
        return banRepo.save(ban);
    }

    @Override
    public void borrarBanner(Long id) {
        banRepo.deleteById(id);
    }

    @Override
    public Banner buscarBanner(Long id) {
        return banRepo.findById(id).orElse(null);
    }

    @Override
    public Banner findBanner(Long id) {
        Banner banner = banRepo.findById(id).orElse(null);
        return banner;
    }

}
