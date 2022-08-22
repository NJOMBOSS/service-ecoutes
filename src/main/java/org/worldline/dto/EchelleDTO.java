package org.worldline.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.worldline.entity.Question;

import javax.persistence.ManyToOne;

@Builder
@Data
public class EchelleDTO {

    private Integer id;

    private Integer valeur;

    private String libelle;

    private String description;

    private QuestionDTO questionDTO;


}
