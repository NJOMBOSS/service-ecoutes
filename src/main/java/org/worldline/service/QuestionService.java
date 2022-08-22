package org.worldline.service;

import org.worldline.dto.QuestionDTO;

import java.util.List;

public interface QuestionService {

   QuestionDTO save(QuestionDTO  questionDTO );

    QuestionDTO  findById(Integer id);

    List<QuestionDTO> findAll();

    void delete(Integer id);

}
