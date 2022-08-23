package org.worldline.dto;

import lombok.Builder;
import lombok.Data;
import org.worldline.entity.Question;

import java.util.List;

@Builder
@Data
public class QuestionnaireDTO {

    private Integer id;

    private String titre;

    private String description;

    private String langue;

    private List<Question> questions;
}
