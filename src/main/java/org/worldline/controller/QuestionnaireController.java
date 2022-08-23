package org.worldline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.worldline.controller.api.QuestionnaireApi;
import org.worldline.dto.QuestionnaireDTO;
import org.worldline.service.QuestionnaireService;

import java.util.List;

@RestController
public class QuestionnaireController implements QuestionnaireApi {

    private QuestionnaireService questionnaireService;

    @Autowired
    public QuestionnaireController(QuestionnaireService questionnaireService) {
        this.questionnaireService = questionnaireService;
    }

    @Override
    public QuestionnaireDTO save(QuestionnaireDTO questionnaireDTO) {
        return questionnaireService.save(questionnaireDTO);
    }

    @Override
    public QuestionnaireDTO findById(Integer idQuestionnaire) {
        return questionnaireService.findById(idQuestionnaire);
    }

    @Override
    public List<QuestionnaireDTO> findAll() {
        return questionnaireService.findAll();
    }

    @Override
    public void delete(Integer id) {
         questionnaireService.delete(id);
    }
}
