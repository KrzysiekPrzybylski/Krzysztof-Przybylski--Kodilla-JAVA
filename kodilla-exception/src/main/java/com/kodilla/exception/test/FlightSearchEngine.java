package com.kodilla.exception.test;

import java.util.HashMap;
import java.util.Map;

public class FlightSearchEngine {


    public static void findFlight(Flight flight) throws RouteNotFoundException {

        Map<String, Boolean> flightMap = new HashMap<>();

        flightMap.put("Warsaw", true);
        flightMap.put("Berlin", true);
        flightMap.put("Sydney", false);
        flightMap.put("Krakow", false);
        flightMap.put("NewYork", true);

        for (Map.Entry<String, Boolean> entry : flightMap.entrySet())
            if (flightMap.containsKey(flight.getDepartureAirport())) {
                flightMap.get(flight.getDepartureAirport());
            } else {
                throw new RouteNotFoundException("Please choose another Airport");
            }
        flightMap.get(flightMap.entrySet().contains(flight.getDepartureAirport()));
    }
}


