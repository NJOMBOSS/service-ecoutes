package org.worldline.mapper;

import org.worldline.dto.QuestionDTO;
import org.worldline.entity.Question;

public class QuestionMapper {

    public static QuestionDTO fromEntity(Question question) {
        if (question == null) {
            return null;
        }
        return QuestionDTO.builder()
                .id(question.getId())
                .nom(question.getNom())
                .description(question.getDescription())
                .build();
    }

    public static Question toEntity(QuestionDTO questionDTO) {
        if (questionDTO == null) {
            return null;
        }
        Question question= new Question();
        question.setId(questionDTO.getId());
        question.setNom(questionDTO.getNom());
        question.setDescription(questionDTO.getDescription());
        return question;
    }
}
