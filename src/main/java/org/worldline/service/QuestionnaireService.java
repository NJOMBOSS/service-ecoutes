package org.worldline.service;

import org.worldline.dto.QuestionDTO;
import org.worldline.dto.QuestionnaireDTO;

import java.util.List;

public interface QuestionnaireService {

    QuestionnaireDTO save( QuestionnaireDTO  questionnaireDTO );

    QuestionnaireDTO  findById(Integer id);

    List< QuestionnaireDTO> findAll();

    void delete(Integer id);
}
