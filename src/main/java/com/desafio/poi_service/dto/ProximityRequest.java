package com.desafio.poi_service.dto;

import lombok.Data;

//gera gets e sets da entidade
@Data
public class ProximityRequest {
    private int x;
    private int y;
    private double dMax;
}

