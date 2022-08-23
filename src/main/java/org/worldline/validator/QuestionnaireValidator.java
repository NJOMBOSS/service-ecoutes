package org.worldline.validator;

import org.springframework.util.StringUtils;
import org.worldline.dto.QuestionDTO;
import org.worldline.dto.QuestionnaireDTO;

import java.util.ArrayList;
import java.util.List;

public class QuestionnaireValidator {
    public static List<String> validate(QuestionnaireDTO dto) {
        List<String> errors = new ArrayList<>();

        if (dto == null) {
            errors.add("Veuillez renseigner le champ titre");
            errors.add("Veuillez renseigner le champ langue");

            return errors;
        }

        if (!StringUtils.hasLength(dto.getTitre())) {
            errors.add("Veuillez renseigner le champ titre");
        }

        if (!StringUtils.hasLength(dto.getLangue())) {
            errors.add("Veuillez renseigner le champ langue");
        }

        return errors;
    }
}
