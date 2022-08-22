package org.worldline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.worldline.entity.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {


}
