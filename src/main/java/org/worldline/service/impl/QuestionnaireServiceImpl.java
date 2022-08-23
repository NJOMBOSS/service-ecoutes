package org.worldline.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.worldline.dto.QuestionnaireDTO;
import org.worldline.exception.ErrorCodes;
import org.worldline.exception.InvalidEntityException;
import org.worldline.mapper.QuestionMapper;
import org.worldline.mapper.QuestionnaireMapper;
import org.worldline.repository.QuestionnaireRepository;
import org.worldline.service.QuestionnaireService;
import org.worldline.validator.QuestionnaireValidator;

import java.util.List;

@Service
@Slf4j
public class QuestionnaireServiceImpl implements QuestionnaireService {

    private QuestionnaireRepository questionnaireRepository;

    @Autowired
    public QuestionnaireServiceImpl(QuestionnaireRepository questionnaireRepository) {
        this.questionnaireRepository = questionnaireRepository;
    }

    @Override
    public QuestionnaireDTO save(QuestionnaireDTO questionnaireDTO) {
        List<String> errors = QuestionnaireValidator.validate(questionnaireDTO);
        if (!errors.isEmpty()) {
            log.error(" Questionnaire non valide {}", questionnaireDTO);
            throw new InvalidEntityException("La questionnaire n'est pas valide", ErrorCodes.QUESTIONNAIRE_NOT_VALID, errors);
        }

        return QuestionnaireMapper.fromEntity(
                questionnaireRepository.save(
                        QuestionnaireMapper.toEntity(questionnaireDTO)
                )
        );
    }

    @Override
    public QuestionnaireDTO findById(Integer id) {
        return null;
    }

    @Override
    public List<QuestionnaireDTO> findAll() {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
