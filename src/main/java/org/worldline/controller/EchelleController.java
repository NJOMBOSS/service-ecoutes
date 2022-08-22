package org.worldline.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.worldline.controller.api.EchelleApi;
import org.worldline.dto.EchelleDTO;
import org.worldline.service.EchelleService;

import java.util.List;

@RestController
public class EchelleController implements EchelleApi {

    private EchelleService echelleService;

    @Autowired
    public EchelleController(EchelleService echelleService) {
        this.echelleService = echelleService;
    }

    @Override
    public EchelleDTO save(EchelleDTO echelleDTO) {
        return echelleService.save(echelleDTO);
    }

    @Override
    public EchelleDTO findById(Integer idEchelle) {
        return echelleService.findById(idEchelle);
    }

    @Override
    public List<EchelleDTO> findAll() {
        return echelleService.findAll();
    }

    @Override
    public void delete(Integer id) {
       echelleService.delete(id);
    }
}
