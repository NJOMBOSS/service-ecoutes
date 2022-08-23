package org.worldline.mapper;

import org.worldline.dto.QuestionDTO;
import org.worldline.dto.QuestionnaireDTO;
import org.worldline.entity.Question;
import org.worldline.entity.Questionnaire;

public class QuestionnaireMapper {

    public static QuestionnaireDTO fromEntity(Questionnaire questionnaire) {
        if (questionnaire == null) {
            return null;
        }
        return QuestionnaireDTO.builder()
                .id(questionnaire.getId())
                .titre(questionnaire.getTitre())
                .description(questionnaire.getDescription())
                .langue(questionnaire.getLangue())
                .build();
    }

    public static Questionnaire toEntity(QuestionnaireDTO questionnaireDTO) {
        if (questionnaireDTO == null) {
            return null;
        }
        Questionnaire questionnaire = new Questionnaire();
        questionnaire.setId(questionnaireDTO.getId());
        questionnaire.setTitre(questionnaireDTO.getTitre());
        questionnaire.setDescription(questionnaireDTO.getDescription());
        questionnaire.setLangue(questionnaireDTO.getLangue());
        questionnaire.setQuestions(questionnaireDTO.getQuestions());
        return questionnaire;
    }

}
