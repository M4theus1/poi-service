package com.desafio.poi_service.service;

import com.desafio.poi_service.model.Poi;
import com.desafio.poi_service.repository.PoiRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PoiService {
    private final PoiRepository repository;

    public PoiService(PoiRepository repository){
        this.repository = repository;
    }

    public Poi save(Poi poi){
        return repository.save(poi);
    }

    public List<Poi> findAll(){
        return repository.findAll();
    }

    public List<Poi> findNearby(int x, int y, double dMax) {
        return repository.findAll().stream()
                .filter(poi -> {
                    double dist = Math.sqrt(Math.pow(poi.getX() - x, 2) + Math.pow(poi.getY() - y, 2));
                    return dist <= dMax;
                })
                .collect(Collectors.toList());
    }

}
