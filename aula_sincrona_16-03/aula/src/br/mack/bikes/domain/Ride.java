package br.mack.bikes.domain;

public class Ride {
    private Bike bike;
    private int durationMinutes;

    public Ride(Bike bike) {
        this.bike = bike;
    }

    public double calculatePrice() {
        return durationMinutes * bike.getPricePerMinute();
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }
}
