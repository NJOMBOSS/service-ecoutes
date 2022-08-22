package org.worldline.service;

import org.worldline.dto.EchelleDTO;

import java.util.List;

public interface EchelleService {

    EchelleDTO save(EchelleDTO echelleDTO);

    EchelleDTO  findById(Integer id);

    List<EchelleDTO> findAll();

    void delete(Integer id);
}
