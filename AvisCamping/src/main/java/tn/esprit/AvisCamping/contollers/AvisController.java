package tn.esprit.AvisCamping.contollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import tn.esprit.AvisCamping.entities.Avis;
import tn.esprit.AvisCamping.services.IServiceAvis;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/avis")
public class AvisController {

    @Autowired
     IServiceAvis serviceAvis;


    @GetMapping("/listavis")
    public List<Avis> getAllAvis() {
        return serviceAvis.getAllAvis();
    }

    @GetMapping("/{id}")
    public Avis getAvisById(@PathVariable Long id) {
        return serviceAvis.getAvisById(id);
    }

    /*@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Avis createAvis(@RequestBody Avis avis) {
        return serviceAvis.createAvis(avis);
    } */

    @PostMapping("/addAvis")
    @ResponseStatus(HttpStatus.CREATED)
    public Avis createAvis(@RequestParam("image") MultipartFile image, @RequestParam("titre") String titre, @RequestParam("note") int note,@RequestParam("description") String description, @RequestParam("dateDePublication") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateDePublication) {

        return serviceAvis.createAvis(titre, description, dateDePublication, note,image);
       // productService.saveProductToDB(file, name, desc, price);
    }


/*    @PutMapping("/{id}")
    public Avis updateAvis(@PathVariable Long id, @RequestBody Avis avis) {
        Avis updatedAvis = serviceAvis.updateAvis(id, avis);
        if (updatedAvis == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Avis non trouvé");
        }
        return updatedAvis;
    } */
/*@PutMapping("/{id}")
public Avis updateAvis(@PathVariable Long id, @RequestBody Avis avis) {
    Avis updatedAvis = serviceAvis.updateAvis(id, avis);
    if (updatedAvis == null) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Avis non trouvé");
    }
    return updatedAvis;
}*/
    @PutMapping("/updateAvis/{id}")
    public Avis updateAvis(@PathVariable Long id, @RequestParam("image") MultipartFile image, @RequestParam("titre") String titre, @RequestParam("note") int note,@RequestParam("description") String description, @RequestParam("dateDePublication") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateDePublication) {
        return serviceAvis.updateAvis(id, titre, description, dateDePublication, note,image);
    }

    @DeleteMapping("deleteAvis/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAvis(@PathVariable Long id) {
        serviceAvis.deleteAvis(id);
    }
}

