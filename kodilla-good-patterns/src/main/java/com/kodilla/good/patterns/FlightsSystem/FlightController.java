package com.kodilla.good.patterns.FlightsSystem;

import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;

public class FlightController {

    private Flights flights;

    public List<Flights> findFlightFrom(String departureFrom) {

        return FlightsRepository.listOfFlights().stream()
                .filter( n -> n.getDepartureAirport().equals(departureFrom))
                .collect(Collectors.toList());
    }
    public List<Flights> findFlightTo(String departureTo) {

        return FlightsRepository.listOfFlights().stream()
                .filter( n -> n.getArrivalAirport().equals(departureTo))
                .collect(Collectors.toList());
    }
    public List<Flights> findFlightVia(String departureFrom, String departureVia, String departureTo) {

        List<Flights> stepOne = FlightsRepository.listOfFlights().stream()
                .filter( n -> n.getDepartureAirport().equals(departureFrom))
                .filter( n -> n.getArrivalAirport().equals(departureVia))
                .collect(Collectors.toList());
        List<Flights> stepTwo = FlightsRepository.listOfFlights().stream()
                .filter( n -> n.getDepartureAirport().equals(departureVia))
                .filter( n -> n.getArrivalAirport().equals(departureTo))
                .collect(Collectors.toList());

        List <Flights> combinedLists = new ArrayList<>();
        combinedLists.addAll(stepOne);
        combinedLists.addAll(stepTwo);

        return combinedLists;

    }
}
