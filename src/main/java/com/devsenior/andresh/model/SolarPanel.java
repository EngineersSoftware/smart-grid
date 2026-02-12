package com.devsenior.andresh.model;

import com.devsenior.andresh.model.enums.WeatherCondition;

public class SolarPanel extends EnergySource {

    private WeatherCondition weather;

    public SolarPanel(String id, double capacity, WeatherCondition weather) {
        super(id, capacity);
        this.weather = weather;
    }

    @Override
    public double generateEnergy() {
        return capacity * weather.getFactor();
    }



}
