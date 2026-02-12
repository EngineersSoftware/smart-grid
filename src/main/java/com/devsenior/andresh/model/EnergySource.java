package com.devsenior.andresh.model;

public abstract class EnergySource {

    private String id;
    protected double capacity; // Capacidad maxima en KW

    public EnergySource(String id, double capacity){
        this.id = id;
        this.capacity = capacity;
    }

    // Método abstracto: cada fuente genera energia de manera distinta
    public abstract double generateEnergy();

    public String getId() {
        return id;
    }

}
