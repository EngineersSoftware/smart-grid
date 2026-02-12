package com.devsenior.andresh.model.enums;

public enum WeatherCondition {
    SUNNY(1.0),
    CLOUDY(0.3),
    STORMY(0.1),
    WINDY(1.5);

    private final double factor;

    // Los ENUMS en Java pueden tener campos y constructores
    WeatherCondition(double factor) {
        this.factor = factor;
    }   

    public double getFactor() {
        return factor;
    }
}
