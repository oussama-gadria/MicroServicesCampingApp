package tn.esprit.AvisCamping.entities;



import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Avis implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAvis;
    private String titre;
    private String description;
    private int note;

    //@Temporal(value = TemporalType.DATE)
   @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateDePublication;


    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private String image;


}
