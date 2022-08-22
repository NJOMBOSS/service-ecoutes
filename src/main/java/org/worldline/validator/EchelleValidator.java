package org.worldline.validator;

import org.springframework.util.StringUtils;
import org.worldline.dto.EchelleDTO;

import java.util.ArrayList;
import java.util.List;

public class EchelleValidator {

    public static List<String> validate(EchelleDTO dto) {
        List<String> errors = new ArrayList<>();

        if (dto == null) {
            errors.add("Veuillez renseigner le champ valeur");
            errors.add("Veuillez renseigner le champ libelle");
            errors.add("Veuillez renseigner le champ description");

            return errors;
        }

        if(dto.getValeur() == null){
          errors.add("Veuillez renseigner le champ valeur");
        }

        if (!StringUtils.hasLength(dto.getLibelle())) {
            errors.add("Veuillez renseigner le champ libelle");
        }

        return errors;
    }
}
