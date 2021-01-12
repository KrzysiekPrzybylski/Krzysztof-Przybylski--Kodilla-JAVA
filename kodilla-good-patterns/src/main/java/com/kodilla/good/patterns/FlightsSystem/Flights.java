package com.kodilla.good.patterns.FlightsSystem;

public class Flights {

    private String departureAirport;
    private String arrivalAirport;

    public Flights(String departureAirport, String arrivalAirport) {
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Flights flights = (Flights) o;

        if (!departureAirport.equals(flights.departureAirport)) return false;
        return arrivalAirport.equals(flights.arrivalAirport);
    }

    @Override
    public int hashCode() {
        int result = departureAirport.hashCode();
        result = 31 * result + arrivalAirport.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return
                "departureAirport='" + departureAirport + '\'' +
                ", arrivalAirport='" + arrivalAirport + '\'';
    }
}
