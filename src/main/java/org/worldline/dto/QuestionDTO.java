package org.worldline.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
public class QuestionDTO {

    private Integer id;

    private String nom;

    private String description;

    @JsonIgnore
    private List<EchelleDTO> echelleDTOList;
}
