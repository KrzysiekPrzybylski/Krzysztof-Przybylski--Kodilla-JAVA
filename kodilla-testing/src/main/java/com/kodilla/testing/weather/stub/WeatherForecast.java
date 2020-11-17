package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {

    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature : temperatures.getTemperature().entrySet()) {

            resultMap.put(temperature.getKey(), temperature.getValue() + 1.0);
        }
        return resultMap;
    }

    public double calculateAverageTemperature(Temperatures temperatures) {
        double sumOfTemperature = 0;
        for (Map.Entry<String, Double> averageTemperature : temperatures.getTemperature().entrySet()) {
            sumOfTemperature += averageTemperature.getValue();
        }
        return sumOfTemperature / temperatures.getTemperature().size();
    }
    public  double calculateMedianaTemperature(Temperatures temperatures) {
        List<Double> values = new LinkedList<>();
        for (Map.Entry<String, Double> temperature: temperatures.getTemperature().entrySet()) {
            values.add(temperature.getValue());
        }
        Collections.sort(values);
        if (values.size() % 2 == 0) {
            return (values.get(values.size()/2) + values.get(values.size()/2-1)) /2;
        } else {
            return (values.get(values.size()/2));
        }
    }
}