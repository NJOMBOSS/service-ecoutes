package org.worldline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.worldline.controller.api.QuestionApi;
import org.worldline.dto.QuestionDTO;
import org.worldline.service.QuestionService;

import java.util.List;

@RestController
public class QuestionController implements QuestionApi {

    private QuestionService questionService;

    @Autowired
    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public QuestionDTO save(QuestionDTO questionDTO) {
        return questionService.save(questionDTO);
    }

    @Override
    public QuestionDTO findById(Integer idQuestion) {
        return questionService.findById(idQuestion);
    }

    @Override
    public List<QuestionDTO> findAll() {
        return questionService.findAll();
    }

    @Override
    public void delete(Integer id) {
       questionService.delete(id);
    }
}
