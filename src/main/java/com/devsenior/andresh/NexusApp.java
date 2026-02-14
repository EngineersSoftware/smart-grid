package com.devsenior.andresh;

import com.devsenior.andresh.model.EnergySource;
import com.devsenior.andresh.model.SolarPanel;
import com.devsenior.andresh.model.WindTurbine;
import com.devsenior.andresh.model.enums.WeatherCondition;
import com.devsenior.andresh.service.GridManager;

public class NexusApp {
    public static void main(String[] args) {

        // 1. Inicializamos el Cerebro del Sistema (El Gestor)
        GridManager nexusGrid = new GridManager();

        // 2. Creación de Activos Energéticos
        // Usamos Polimorfismo: La variable es de tipo EnergySource, el objeto es Solar o Wind
        EnergySource panelNorte = new SolarPanel("SOL-001", 500.0, WeatherCondition.SUNNY);
        EnergySource panelSur = new SolarPanel("SOL-002", 300.0, WeatherCondition.CLOUDY);
        EnergySource turbinaBosque = new WindTurbine("WND-001", 1200.0, 25.5); // Viento fuerte

        // 3. Registro en la Estructura de Datos (Map)
        nexusGrid.registerSource(panelNorte);
        nexusGrid.registerSource(panelSur);
        nexusGrid.registerSource(turbinaBosque);

        // 4. Operaciones de Consulta Senior
        displayGridStatus(nexusGrid);
    }

    /**
     * Un método estático auxiliar para no ensuciar el main. 
     * Simula un reporte de estado del sistema.
     */
    private static void displayGridStatus(GridManager manager) {
        System.out.println("========= NEXUS GRID STATUS REPORT =========");
        
        // Buscamos un dispositivo específico directamente (Ventaja del Map O(1))
        String searchId = "WND-001";
        EnergySource specific = manager.findSourceById(searchId);
        
        if (specific != null) {
            System.out.println("Dispositivo localizado: [" + searchId + "]");
            System.out.println("Generación actual del activo: " + specific.generateEnergy() + " kW");
        }

        System.out.println("-------------------------------------------");

        // Cálculo total de la red
        double total = manager.calculateTotalGeneration();
        System.out.println("PRODUCCIÓN TOTAL DE LA CIUDAD: " + total + " kW");
        
        System.out.println("============================================");

    }
}