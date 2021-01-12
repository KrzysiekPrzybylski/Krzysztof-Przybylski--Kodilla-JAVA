package com.kodilla.good.patterns.FlightsSystem;

import java.util.ArrayList;
import java.util.List;

public class FlightsRepository {



    public static List<Flights> listOfFlights() {
        List<Flights> flights = new ArrayList<>();
        flights.add(new Flights("WAW","WRC"));
        flights.add(new Flights("KAT","SZC"));
        flights.add(new Flights("WAW","KRK"));
        flights.add(new Flights("LDZ","KAT"));
        flights.add(new Flights("SZC","RZE"));
        flights.add(new Flights("KRK","POZ"));
        flights.add(new Flights("GDA","WAW"));

        return flights;
    }



}
