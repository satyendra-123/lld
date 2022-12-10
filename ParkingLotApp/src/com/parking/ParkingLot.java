package com.parking;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

public abstract class ParkingLot {
    Address address;
    List<ParkingFloor> parkingFloors;
    ParkingFee parkingFee;

    //feeCalculator

    int totalMotorcycleSpot;

    //assigns vehicle to a parking spot and puts the allocated time on ticket gives out the ticket.
    public abstract ParkingTicket parkVehicle(Vehicle vehicle, LocalDateTime parkingTime);


    //takes the receipt and un parks the vehicle. removes the spot (free up the spot)
    // as per the current time checks the duration and apply charges on ticket for ticket vehicle type
    public abstract void unParkVehicle(Vehicle vehicle, ParkingTicket parkingTicket, LocalDateTime unparkTime);

    public void createParkingSpot(ParkingSpot parkingSpot){
        System.out.println("creating spot for "+parkingSpot);
    }

}
