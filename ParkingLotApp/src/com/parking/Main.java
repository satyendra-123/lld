package com.parking;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
    	// write your code here
        buildParkingLot();
    }

    private static void buildParkingLot(){
        Address add = new Address("Pheonix ", "Bengaluru", "Bengaluru", 560016);
        ParkingFloor parkingFloor = new ParkingFloor("First");
        List<ParkingSpot> parkingSpotList = new ArrayList<>();
        for(int i=0; i<100; i++){
            parkingSpotList.add(new ParkingSpot(i));
        }
        parkingFloor.fillSpots(parkingSpotList, "motorcycle");
        parkingFloor.fillSpots(parkingSpotList, "car");
        parkingFloor.fillSpots(parkingSpotList, "bus");
        List<ParkingFloor> floors = new ArrayList<>();
        floors.add(parkingFloor);

        MallParkingFee fee = new MallParkingFee(10, 20, 50);
        MallParkingLot mpl = new MallParkingLot(add, floors, fee, 100, 80, 10);

        Vehicle vehicle = new Vehicle("KA-53-EV-4511", "motorcycle");

        ParkingTicket parkingTicket = mpl.parkVehicle(vehicle, LocalDateTime.now());
        mpl.unParkVehicle(vehicle, parkingTicket ,LocalDateTime.now());

        Vehicle vehicle2 = new Vehicle("KA-53-EV-4512", "bus");
        parkingTicket = mpl.parkVehicle(vehicle2, LocalDateTime.now());
        mpl.unParkVehicle(vehicle2, parkingTicket ,LocalDateTime.now());
    }
}
