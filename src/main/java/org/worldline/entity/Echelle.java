package org.worldline.entity;

import lombok.*;

import javax.persistence.*;

@Builder
@Data
@AllArgsConstructor @NoArgsConstructor @ToString
@Entity
public class Echelle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer valeur;

    private String libelle;

    private String description;

    @ManyToOne
    private Question question;
}
