package tn.esprit.AvisCamping.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import tn.esprit.AvisCamping.entities.Avis;
import tn.esprit.AvisCamping.repositories.AvisRepository;

import java.io.IOException;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class ServiceAvis implements IServiceAvis {

    @Autowired
    AvisRepository avisRepository;


    @Override
    public List<Avis> getAllAvis() {
        return avisRepository.findAll();
    }

    @Override
    public Avis getAvisById(Long id) {
        return avisRepository.findById(id).orElse(null);
    }

    @Override
    public Avis createAvis(String titre, String description, Date dateDePublication, int note, MultipartFile imageFile) {
        Avis avis = new Avis();
        avis.setTitre(titre);
        avis.setDescription(description);
        avis.setNote(note);
        avis.setDateDePublication(dateDePublication);

        try {
            String fileName = StringUtils.cleanPath(imageFile.getOriginalFilename());
            if (fileName.contains("..")) {
                // Gestion de l'erreur si le nom de fichier est invalide
                throw new IllegalArgumentException("Le nom de fichier n'est pas valide");
            }

            // Encodage de l'image en Base64
            avis.setImage(Base64.getEncoder().encodeToString(imageFile.getBytes()));
        } catch (IOException e) {
            // Gestion de l'erreur en cas de problème avec le fichier
            throw new RuntimeException("Erreur lors de la gestion du fichier image", e);
        }
        avisRepository.save(avis);


        return avis;

    }




    /*public Avis updateAvis(Long id, Avis avis) {
        Optional<Avis> existingAvisOptional = avisRepository.findById(id);
        if (existingAvisOptional.isPresent()) {
            Avis existingAvis = existingAvisOptional.get();
            existingAvis.setTitre(avis.getTitre());
            existingAvis.setDescription(avis.getDescription());
            existingAvis.setNote(avis.getNote());
            existingAvis.setDateDePublication(avis.getDateDePublication());
            // Mettez à jour l'image si nécessaire (ajoutez la logique appropriée)

            return avisRepository.save(existingAvis);
        } else {
            return null; // Ou vous pouvez lever une exception si l'avis n'est pas trouvé
        }
    } */
    @Override
    public Avis updateAvis(Long id, String titre, String description, Date dateDePublication,int note, MultipartFile imageFile)
                           {

        Avis avis = avisRepository.findById(id).get();

        String fileName = StringUtils.cleanPath(imageFile.getOriginalFilename());
        if (fileName.contains("..")) {
            System.out.println("not a a valid file");
        }

        try {
            avis.setImage(Base64.getEncoder().encodeToString(imageFile.getBytes()));
        } catch (IOException e) {
            throw new RuntimeException("Erreur lors de la gestion du fichier image", e);

        }

                               avis.setTitre(titre);
                               avis.setDescription(description);
                               avis.setNote(note);
                               avis.setDateDePublication(dateDePublication);
        return avisRepository.save(avis);
    }


    public void deleteAvis(Long id) {

        Optional<Avis> avisOptional = avisRepository.findById(id);
        if (avisOptional.isPresent()) {
            // Supprimer l'avis s'il existe
            avisRepository.deleteById(id);
        } else {
            // Gérer le cas où l'avis n'existe pas, par exemple, en lançant une exception
            throw new RuntimeException("Avis non trouvé pour l'ID : " + id);
        }
    }
}