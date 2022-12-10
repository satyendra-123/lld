package com.parking;

public class ParkingSpot {
    int number;
    Vehicle vehicle;
    boolean isFree;

    ParkingSpot(int number){
        this.number = number;
        this.isFree = true;
    }

    public void assignSpot(Vehicle vehicle){
        if(isFree) {
            this.vehicle = vehicle;
            this.isFree = false;
        }
        else
            throw new RuntimeException("spot is not free");
    }

    public boolean isFree(){
        return isFree;
    }

    public void freeUpSpot(){
        if(!isFree) {
            this.vehicle = null;
            this.isFree = true;
        }
    }
}
