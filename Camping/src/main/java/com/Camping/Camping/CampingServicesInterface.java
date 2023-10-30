package com.Camping.Camping;

import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

public interface CampingServicesInterface {
     List<Camping> getAllCamping();
     Camping addCamping(String titre,String description,Integer capacity,float price,Date dateCamping,MultipartFile image);
     void deleteCamping(Integer campingId);
     Camping updateCamping(Integer campingId, String titre, String description, Integer capacity, float price, Date dateCamping, MultipartFile image);
     Camping getCampingById(Integer campingId);
}
