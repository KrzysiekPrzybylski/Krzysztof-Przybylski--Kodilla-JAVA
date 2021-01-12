package com.kodilla.good.patterns.FlightsSystem;

public class Application {

    public static void main(String[] args) {
        FlightController flightController = new FlightController();
        System.out.println(flightController.findFlightFrom("WAW")+"\n");
        System.out.println(flightController.findFlightTo("KRK")+"\n");
        System.out.println(flightController.findFlightVia("WAW", "KRK", "POZ"));
    }
}
