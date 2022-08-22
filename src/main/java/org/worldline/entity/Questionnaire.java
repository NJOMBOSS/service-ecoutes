package org.worldline.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Questionnaire extends AbstractEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String titre;

    private String description;

    private String langue;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "questionnaire")
    private List<Question> questions;
}
