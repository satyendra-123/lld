package com.parking;

import java.util.HashMap;

public class StadiumParkingFee extends ParkingFee{

    HashMap<String, Integer> motorCycleRate;
    HashMap<String, Integer> carSuvRate;

    public StadiumParkingFee(HashMap<String, Integer> motorCycleRate, HashMap<String, Integer> carSuvRate) {
        this.motorCycleRate = motorCycleRate;
        this.carSuvRate = carSuvRate;
    }
}
