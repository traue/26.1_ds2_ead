package br.mack.bikes.controllers;

import br.mack.bikes.domain.Bike;
import br.mack.bikes.domain.Ride;
import br.mack.bikes.domain.User;

public class RideController {

    public Ride startRide(User user, Bike bike) {
        return user.startRide(bike);
    }

    public double getRidePrice(Ride ride) {
        return ride.calculatePrice();
    }


}
