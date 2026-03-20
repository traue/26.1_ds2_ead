package br.mack.bikes.domain;

import java.util.ArrayList;
import java.util.List;

public class User {

    private List<Ride> rides = new ArrayList<>();

    public Ride startRide(Bike bike) {
        Ride ride = new Ride(bike);
        rides.add(ride);
        return ride;
    }
}