package org.worldline.mapper;

import org.worldline.dto.EchelleDTO;
import org.worldline.dto.QuestionDTO;
import org.worldline.entity.Echelle;

public class EchelleMapper {
    public static EchelleDTO fromEntity(Echelle echelle) {
        if (echelle == null) {
            return null;
        }
        return EchelleDTO.builder()
                .id(echelle.getId())
                .valeur(echelle.getValeur())
                .libelle(echelle.getLibelle())
                .description(echelle.getDescription())
                .questionDTO(QuestionMapper.fromEntity(echelle.getQuestion()))
                .build();
    }

    public static Echelle toEntity(EchelleDTO echelleDTO) {
        if (echelleDTO == null) {
            return null;
        }
        Echelle echelle = new Echelle();
        echelle.setId(echelleDTO.getId());
        echelle.setValeur(echelleDTO.getValeur());
        echelle.setLibelle(echelleDTO.getLibelle());
        echelle.setDescription(echelleDTO.getDescription());
        echelle.setQuestion(QuestionMapper.toEntity(echelleDTO.getQuestionDTO()));
        return echelle;
    }
}
