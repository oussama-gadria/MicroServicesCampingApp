package com.offrePlat.offrePlat.controllers;


import com.offrePlat.offrePlat.entities.OffrePlat;
import com.offrePlat.offrePlat.entities.PlatType;
import com.offrePlat.offrePlat.services.Iservices.IOffrePlatService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/microservice/offrePlat")
@AllArgsConstructor
public class OffrePlatController {

    @Autowired
    private IOffrePlatService offrePlatService;

    @GetMapping("/listOfferPlat")
    List<OffrePlat> retrieveAllOffrePlat(){
        return offrePlatService.retrieveAllOffrePlats();
    }

    @PostMapping("/addOffrePlat")
    OffrePlat addOffrePLat(@RequestParam("file") MultipartFile file, @RequestParam("nom") String nom,@RequestParam("description") String description,@RequestParam("prix") float prix,
            @RequestParam("nbPersonnes") int nbPersonnes,@RequestParam("type") PlatType type)
    {
        return offrePlatService.addOffrePlat(file,nom,description,prix,nbPersonnes,type);
    }

    @DeleteMapping("/deleteOffrePlat/{id}")
    void deleteOffrePlat(@PathVariable Long id){
        offrePlatService.deleteOffrePlat(id);
    }

    @PutMapping("/updateOffrePlat/{id}")
    OffrePlat updateOffrePlat(@PathVariable Long id,@RequestParam("file") MultipartFile file, @RequestParam("nom") String nom,@RequestParam("description") String description,@RequestParam("prix") float prix, @RequestParam("nbPersonnes") int nbPersonnes,@RequestParam("type") PlatType type){
        return offrePlatService.updateOffrePlat(id,file,nom,description,prix,nbPersonnes,type);
    }

    @GetMapping("/offrePlat/{id}")
    OffrePlat retrieveOffrePlat(@PathVariable Long id){
        return offrePlatService.retrieveOffrePlat(id);
    }



}
