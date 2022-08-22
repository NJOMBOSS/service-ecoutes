package org.worldline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.worldline.entity.Echelle;
@Repository
public interface EchelleRepository extends JpaRepository<Echelle,Integer> {
}
