package org.worldline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.worldline.entity.Questionnaire;

public interface QuestionnaireReppository extends JpaRepository<Questionnaire, Integer> {
}
