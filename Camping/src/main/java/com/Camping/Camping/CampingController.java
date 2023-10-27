package com.Camping.Camping;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import javax.ws.rs.PathParam;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/camping")
public class CampingController {
    @Autowired
    private CampingServices campingServices;

    @PostMapping("/create")
    public Camping addCamping(@PathParam("titre") String titre , @PathParam("description") String description ,@PathParam("price") float price ,@PathParam("capacity") Integer capacity , @PathParam("dateCamping") Date dateCamping , @RequestParam("image") MultipartFile image){
        return campingServices.addCamping(titre,description,capacity,price,dateCamping,image);
    }

    @GetMapping
    public List<Camping> getAllCamping(){
        return campingServices.getAllCamping();
    }

    @GetMapping("/getCampingById/{id}")
    public Camping getCampingById(@PathVariable("id") Integer id){
        return campingServices.getCampingById(id);
    }

    @PutMapping("/update/{id}")
    public Camping updateCamping(@PathVariable("id") Integer id , @PathParam("titre") String titre , @PathParam("description") String description ,@PathParam("price") float price ,@PathParam("capacity") Integer capacity , @PathParam("dateCamping") Date dateCamping , @RequestParam("image") MultipartFile image){
        return campingServices.updateCamping(id,titre,description,capacity,price,dateCamping,image);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteCamping(@PathVariable Integer id){
         campingServices.deleteCamping(id);
    }
}
