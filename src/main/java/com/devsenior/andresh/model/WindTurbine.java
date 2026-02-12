package com.devsenior.andresh.model;

public class WindTurbine extends EnergySource {

    private double windSpeed;

    public WindTurbine(String id, double capacity, double windSpeed) {
        super(id, capacity);
        this.windSpeed = windSpeed;
    }

    @Override
    public double generateEnergy() {
        if (windSpeed < 5) return 0; // No genera energía si el viento es muy débil
        return capacity * (windSpeed / 20.0); // Genera más energía con vientos más fuertes, hasta un máximo de capacidad
    }

}
