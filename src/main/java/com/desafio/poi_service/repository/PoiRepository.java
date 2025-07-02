package com.desafio.poi_service.repository;

import com.desafio.poi_service.model.Poi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PoiRepository extends JpaRepository<Poi, Long> {
}
