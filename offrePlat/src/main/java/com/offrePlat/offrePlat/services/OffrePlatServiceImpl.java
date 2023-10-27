package com.offrePlat.offrePlat.services;


import com.offrePlat.offrePlat.entities.OffrePlat;
import com.offrePlat.offrePlat.entities.PlatType;
import com.offrePlat.offrePlat.repositories.OffrePlatRepository;
import com.offrePlat.offrePlat.services.Iservices.IOffrePlatService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@Service
@AllArgsConstructor
@RequiredArgsConstructor
public class OffrePlatServiceImpl implements IOffrePlatService {
    @Value("${app.nfs.path:/tmp}")
    private String nfsPath;
    @Autowired
    private OffrePlatRepository offrePlatRepository;

    @Override
    public List<OffrePlat> retrieveAllOffrePlats() {
        return offrePlatRepository.findAll();
    }
    @Override
    public OffrePlat  addOffrePlat(MultipartFile file, String nom, String description, float prix, int nbPersonnes, PlatType type)
    {
        OffrePlat offrePlat = new OffrePlat();
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if(fileName.contains(".."))
        {
            System.out.println("not a a valid file");
        }
        try {
            offrePlat.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        offrePlat.setDescription(description);
        offrePlat.setPrix(prix);
        offrePlat.setType(type);
        offrePlat.setNom(nom);
        offrePlat.setNbPersonnes(nbPersonnes);
        return offrePlatRepository.save(offrePlat);
    }
    @Override
    public void deleteOffrePlat(Long id) {
        offrePlatRepository.deleteById(id);
    }

    @Override
    public OffrePlat updateOffrePlat(Long id,MultipartFile file, String nom, String description, float prix, int nbPersonnes, PlatType type) {
        OffrePlat offrePlat = offrePlatRepository.findById(id).get();
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if(fileName.contains(".."))
        {
            System.out.println("not a a valid file");
        }
        try {
            offrePlat.setImage(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        offrePlat.setDescription(description);
        offrePlat.setPrix(prix);
        offrePlat.setType(type);
        offrePlat.setNom(nom);
        offrePlat.setNbPersonnes(nbPersonnes);
        return offrePlatRepository.save(offrePlat);
    }

    @Override
    public OffrePlat retrieveOffrePlat(Long id) {

        return offrePlatRepository.findById(id).get();
    }
}
