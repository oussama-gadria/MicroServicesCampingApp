package tn.esprit.AvisCamping.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.AvisCamping.entities.Avis;

@Repository
public interface AvisRepository extends JpaRepository<Avis, Long> {

}