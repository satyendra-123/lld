package com.parking;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

public class StadiumParkingLot extends ParkingLot{

    int car_suv_spot;

    int availableMotorcycleSpot;
    int availableCarSpot;

    public StadiumParkingLot(Address address, List<ParkingFloor> parkingFloors, ParkingFee parkingFee,
                             int totalMotorcycleSpot, int car_suv_spot) {
        this.address = address;
        this.parkingFloors = parkingFloors;
        this.parkingFee = parkingFee;
        this.totalMotorcycleSpot = totalMotorcycleSpot;
        this.car_suv_spot = car_suv_spot;
    }


    @Override
    public ParkingTicket parkVehicle(Vehicle vehicle, LocalDateTime parkingTime) {
        return null;
    }

    @Override
    public void unParkVehicle(Vehicle vehicle, ParkingTicket parkingTicket, LocalDateTime unparkTime) {

    }

    private boolean isFull(Vehicle vehicle){
        if(vehicle.vehicleType.equalsIgnoreCase("motorcycle"))
            return availableMotorcycleSpot > 0 ? false : true;
        else if(vehicle.vehicleType.equalsIgnoreCase("car") || vehicle.vehicleType.equalsIgnoreCase("suv"))
            return availableCarSpot > 0 ? false : true;
        return true;
    }
}
