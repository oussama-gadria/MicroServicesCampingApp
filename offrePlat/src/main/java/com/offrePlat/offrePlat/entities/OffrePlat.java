package com.offrePlat.offrePlat.entities;




import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class OffrePlat implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idOffrePlat;
    String nom;
    String description;
    @Lob
    private String image;
    float prix;
    int nbPersonnes;

    @Enumerated(EnumType.STRING)
    PlatType type;




}
