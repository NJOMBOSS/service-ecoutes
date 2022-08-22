package org.worldline.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class QuestionnaireDTO {

    private Integer id;

    private String titre;

    private String description;

    private String langue;
}
