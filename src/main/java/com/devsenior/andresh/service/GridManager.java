package com.devsenior.andresh.service;

import java.util.HashMap;
import java.util.Map;

import com.devsenior.andresh.model.EnergySource;

public class GridManager {

    private Map<String, EnergySource> energyMap;

    public GridManager(){
        energyMap = new HashMap<>();
    }

    public void registerSource(EnergySource source){
        // Al usar Map, evitamos duplicados por ID automáticamente
        energyMap.put(source.getId(), source);
    }

    public double calculateTotalGeneration(){
        double total = 0;
        //Recorremos los valores del mapa
        for (EnergySource source : energyMap.values()) {
            total += source.generateEnergy();
        }
        return total;
    }

    // Venataja Senior: Acceso directo por ID
    public EnergySource findSourceById(String id){
        return energyMap.get(id); 
    }

}
