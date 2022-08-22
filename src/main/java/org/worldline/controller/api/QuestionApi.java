package org.worldline.controller.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import org.worldline.dto.QuestionDTO;

import java.util.List;

import static org.worldline.utils.Constants.APP_ROOT;

@RequestMapping(APP_ROOT + "/questions")
@Tag(name = "QUESTIONS")
public interface QuestionApi {

    @PostMapping("/create")
    QuestionDTO save(@RequestBody QuestionDTO questionDTO);


    @GetMapping("/{idQuestion}")
    QuestionDTO findById(@PathVariable("idQuestion") Integer idQuestion);


    @GetMapping("/all")
    List<QuestionDTO> findAll();


    @DeleteMapping("/delete/{idQuestion}")
    void delete(@PathVariable("idQuestion") Integer id);



}
