package com.parking;

public class MallParkingFee extends ParkingFee{
     int motorCyclePerHourRate;
     int carSuvPerHourRate;
     int busTruckPerHourRate;

    public MallParkingFee(int motorCyclePerHourRate, int carSuvPerHourRate, int busTruckPerHourRate) {
        this.motorCyclePerHourRate = motorCyclePerHourRate;
        this.carSuvPerHourRate = carSuvPerHourRate;
        this.busTruckPerHourRate = busTruckPerHourRate;
    }
}


