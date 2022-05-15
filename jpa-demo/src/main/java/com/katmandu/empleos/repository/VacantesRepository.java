package com.katmandu.empleos.repository;

import com.katmandu.empleos.model.Vacante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacantesRepository extends JpaRepository<Vacante,Integer> {
}
