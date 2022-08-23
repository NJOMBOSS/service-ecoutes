package org.worldline.controller.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import org.worldline.dto.QuestionnaireDTO;

import java.util.List;

import static org.worldline.utils.Constants.APP_ROOT;

@RequestMapping(APP_ROOT + "/questionnaires")
@Tag(name = "QUESTIONNAIRES")
public interface QuestionnaireApi {

    @PostMapping("/create")
    QuestionnaireDTO save(@RequestBody QuestionnaireDTO questionnaireDTO);


    @GetMapping("/{idQuestionnaire}")
    QuestionnaireDTO findById(@PathVariable("idQuestionnaire") Integer idQuestionnaire);


    @GetMapping("/all")
    List<QuestionnaireDTO> findAll();


    @DeleteMapping("/delete/{idQuestionnaire}")
    void delete(@PathVariable("idQuestionnaire") Integer id);

}
