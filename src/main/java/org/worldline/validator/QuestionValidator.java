package org.worldline.validator;

import org.springframework.util.StringUtils;
import org.worldline.dto.QuestionDTO;

import java.util.ArrayList;
import java.util.List;

public class QuestionValidator {

    public static List<String> validate(QuestionDTO dto) {
        List<String> errors = new ArrayList<>();

        if (dto == null) {
            errors.add("Veuillez renseigner le champ nom");
            errors.add("Veuillez renseigner le champ description");

            return errors;
        }

        if (!StringUtils.hasLength(dto.getNom())) {
            errors.add("Veuillez renseigner le champ nom");
        }

        return errors;
    }
}
