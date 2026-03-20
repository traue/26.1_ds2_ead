package br.mack.bikes;

import br.mack.bikes.controllers.RideController;
import br.mack.bikes.domain.Bike;
import br.mack.bikes.domain.Ride;
import br.mack.bikes.domain.User;

public class Principal {

    public static void main(String[] args) {

        User  user = new User();
        Bike  bike = new Bike();

        RideController rideController = new RideController();
        Ride ride = rideController.startRide(user, bike);

        bike.setPricePerMinute(0.25f);
        ride.setDurationMinutes(45);

        System.out.println(rideController.getRidePrice(ride));


    }


}
