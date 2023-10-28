package com.offrePlat.offrePlat.services.Iservices;

import com.offrePlat.offrePlat.entities.OffrePlat;
import com.offrePlat.offrePlat.entities.PlatType;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface IOffrePlatService {

    List<OffrePlat> retrieveAllOffrePlats();
    OffrePlat addOffrePlat(MultipartFile file, String nom, String description, float prix, int nbPersonnes, PlatType type);

    void deleteOffrePlat(Long id);

    OffrePlat updateOffrePlat(Long id,MultipartFile file, String nom, String description, float prix, int nbPersonnes, PlatType type);

    OffrePlat retrieveOffrePlat(Long id);
}
