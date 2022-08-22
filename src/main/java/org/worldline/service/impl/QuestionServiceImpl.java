package org.worldline.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.worldline.dto.QuestionDTO;
import org.worldline.exception.EntityNotFoundException;
import org.worldline.exception.ErrorCodes;
import org.worldline.exception.InvalidEntityException;
import org.worldline.mapper.QuestionMapper;
import org.worldline.repository.QuestionRepository;
import org.worldline.service.QuestionService;
import org.worldline.validator.QuestionValidator;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class QuestionServiceImpl implements QuestionService {

    private QuestionRepository questionRepository;

    @Autowired
    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public QuestionDTO save(QuestionDTO questionDTO) {
        List<String> errors = QuestionValidator.validate(questionDTO);
        if (!errors.isEmpty()) {
            log.error(" Question non valide {}", questionDTO);
            throw new InvalidEntityException("La question n'est pas valide", ErrorCodes.QUESTION_NOT_VALID, errors);
        }

        return QuestionMapper.fromEntity(
                questionRepository.save(
                        QuestionMapper.toEntity(questionDTO)
                )
        );
    }

    @Override
    public QuestionDTO findById(Integer id) {
        if (id == null) {
            log.error("La question est nulle");
            return null;
        }

        return questionRepository.findById(id).map(QuestionMapper::fromEntity).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucune" +
                                " question avec l'ID = " + id + " n' a été trouvé dans la BDD",
                        ErrorCodes.QUESTION_NOT_FOUND)
        );
    }

    @Override
    public List<QuestionDTO> findAll() {
        return questionRepository.findAll().stream()
                .map(QuestionMapper::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {

        if (id == null) {
            log.error("La question est nulle");
            return;
        }
      /*List<Question> questions = questionRepository.findAllByEchelleId(id);
        if (!questions.isEmpty()) {
            throw new InvalidOperationException("Impossible de supprimer cette categorie qui est deja utilise",
                    ErrorCodes.ECHELLE_ALREADY_IN_USE);
        }*/
        questionRepository.deleteById(id);
    }
}
