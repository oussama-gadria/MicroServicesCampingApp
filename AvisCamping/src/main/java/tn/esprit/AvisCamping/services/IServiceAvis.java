package tn.esprit.AvisCamping.services;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.AvisCamping.entities.Avis;

import java.util.Date;
import java.util.List;

public interface IServiceAvis {

    List<Avis> getAllAvis();

    Avis getAvisById(Long id);


     Avis createAvis(String titre, String description, Date dateDePublication,int note, MultipartFile imageFile);

        Avis updateAvis(Long id, String titre, String description, Date dateDePublication,int note, MultipartFile imageFile);

    void deleteAvis(Long id);
}
