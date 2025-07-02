package com.desafio.poi_service.controller;

import com.desafio.poi_service.dto.ProximityRequest;
import com.desafio.poi_service.model.Poi;
import com.desafio.poi_service.service.PoiService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pois")
public class PoiController {
    private final PoiService service;

    public PoiController(PoiService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Poi> createPoi(@RequestBody Poi poi){
        return ResponseEntity.ok(service.save(poi));
    }

    @GetMapping
    public ResponseEntity<List<Poi>> getAllPois(){
        return ResponseEntity.ok(service.findAll());
    }

    @PostMapping("/nearby")
    public ResponseEntity<List<Poi>> getNearbyPois(@RequestBody ProximityRequest request) {
        return ResponseEntity.ok(service.findNearby(request.getX(), request.getY(), request.getDMax()));
    }


}
