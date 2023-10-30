package com.Camping.Camping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class CampingServices implements CampingServicesInterface {

    @Autowired
    private CampingRepository campingRepository;

    @Override
    public List<Camping> getAllCamping() {
        return campingRepository.findAll();
    }

    @Override
    public Camping addCamping(String titre, String description, Integer capacity, float price, Date dateCamping,  MultipartFile image) {
            Camping camping = new Camping();
        saveImage(image, camping);
        camping.setTitre(titre);
        camping.setDescription(description);
        camping.setCapacity(capacity);
        camping.setPrice(price);
        camping.setDateComping(dateCamping);
        return campingRepository.save(camping);
    }

    @Override
    public void deleteCamping(Integer campingId) {
        campingRepository.deleteById(campingId);
    }

    @Override
    public Camping updateCamping(Integer campingId, String titre, String description, Integer capacity, float price, Date dateCamping, MultipartFile image) {
        Camping camping1=campingRepository.findById(campingId).get();
        saveImage(image, camping1);
        camping1.setDescription(description);
        camping1.setCapacity(capacity);
        camping1.setPrice(price);
        camping1.setTitre(titre);
        camping1.setDateComping(dateCamping);
        campingRepository.save(camping1);
        return camping1;
    }

    private void saveImage(MultipartFile image, Camping camping1) {
        String fileName= StringUtils.cleanPath(image.getOriginalFilename());
        if (fileName.contains("..")) {
            System.out.println("not valid image");
        }
        try {
            camping1.setImage(Base64.getEncoder().encodeToString(image.getBytes()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Camping getCampingById(Integer campingId) {
        return campingRepository.findById(campingId).get();
    }
}
