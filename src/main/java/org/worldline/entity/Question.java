package org.worldline.entity;

import lombok.*;
import org.worldline.dto.EchelleDTO;


import javax.persistence.*;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nom;

    private String description;

    @ManyToOne
    private Questionnaire questionnaire;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "question")
    private List<Echelle> echelles;
}
