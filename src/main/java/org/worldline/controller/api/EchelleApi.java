package org.worldline.controller.api;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import org.worldline.dto.EchelleDTO;


import java.util.List;

import static org.worldline.utils.Constants.APP_ROOT;

@RequestMapping(APP_ROOT + "/echelles")
@Tag(name = "ECHELLES")
public interface EchelleApi {

    @PostMapping("/create")
    EchelleDTO save(@RequestBody EchelleDTO echelleDTO);


    @GetMapping("/{idEchelle}")
    EchelleDTO findById(@PathVariable("idEchelle") Integer idEchelle);


    @GetMapping("/all")
    List<EchelleDTO> findAll();


    @DeleteMapping("/delete/{idEchelle}")
    void delete(@PathVariable("idEchelle") Integer id);


}
