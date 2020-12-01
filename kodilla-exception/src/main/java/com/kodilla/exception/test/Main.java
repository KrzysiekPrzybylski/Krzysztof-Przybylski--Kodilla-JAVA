package com.kodilla.exception.test;

public class Main {
    public static void main(String[] args) {
        Flight flight = new Flight("Washington", "Warsaw");
        FlightSearchEngine flightSearchEngine = new FlightSearchEngine();

        try{
            FlightSearchEngine.findFlight(flight);
        } catch (RouteNotFoundException e) {
            System.out.println("The flight is not exist. Please take some other");
        } finally {
            System.out.println("You can always ride a bike");
        }

    }
}
