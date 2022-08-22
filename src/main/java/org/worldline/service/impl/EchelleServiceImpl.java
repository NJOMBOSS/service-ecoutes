package org.worldline.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.worldline.dto.EchelleDTO;
import org.worldline.exception.EntityNotFoundException;
import org.worldline.exception.ErrorCodes;
import org.worldline.exception.InvalidEntityException;
import org.worldline.mapper.EchelleMapper;
import org.worldline.repository.EchelleRepository;
import org.worldline.service.EchelleService;
import org.worldline.validator.EchelleValidator;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EchelleServiceImpl implements EchelleService {

    private EchelleRepository echelleRepository;
    //private QuestionRepository questionRepository;

    @Autowired
    public EchelleServiceImpl(EchelleRepository echelleRepository) {
        this.echelleRepository = echelleRepository;
    }


    @Override
    public EchelleDTO save(EchelleDTO echelleDTO) {

        List<String> errors = EchelleValidator.validate(echelleDTO);
        if (!errors.isEmpty()) {
            log.error(" Echelle non valide {}", echelleDTO);
            throw new InvalidEntityException("L'article n'est pas valide", ErrorCodes.ECHELLE_NOT_VALID, errors);
        }

        return EchelleMapper.fromEntity(
                echelleRepository.save(
                        EchelleMapper.toEntity(echelleDTO)
                )
        );
    }

    @Override
    public EchelleDTO findById(Integer id) {
        if (id == null) {
            log.error("L'echelle est nulle");
            return null;
        }

        return echelleRepository.findById(id).map(EchelleMapper::fromEntity).orElseThrow(() ->
                new EntityNotFoundException(
                        "Aucune" +
                                " echelle avec l'ID = " + id + " n' a été trouvé dans la BDD",
                        ErrorCodes.ECHELLE_NOT_FOUND)
        );
    }

    @Override
    public List<EchelleDTO> findAll() {
        return echelleRepository.findAll().stream()
                .map(EchelleMapper::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {

        if (id == null) {
            log.error("L'echelle est nulle");
            return;
        }
      /*List<Question> questions = questionRepository.findAllByEchelleId(id);
        if (!questions.isEmpty()) {
            throw new InvalidOperationException("Impossible de supprimer cette categorie qui est deja utilise",
                    ErrorCodes.ECHELLE_ALREADY_IN_USE);
        }*/
        echelleRepository.deleteById(id);
    }
}
