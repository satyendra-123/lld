package com.parking;

import java.util.List;
import java.util.Optional;

public class ParkingFloor {
    String floor;

    List<ParkingSpot> motorCycleParkingSpots;
    List<ParkingSpot> carParkingSpots;
    List<ParkingSpot> busParkingSpots;

    int availableMotorcycleSpot;
    int availableCarSpot;
    int availableBusTruckSpot;

    ParkingFloor(String floor){
        floor  = floor;
    }

    public void fillSpots(List<ParkingSpot> spot, String vehicleType){
        if(vehicleType.equalsIgnoreCase("motorcycle")) {
            this.motorCycleParkingSpots = spot;
            this.availableMotorcycleSpot = spot.size();
        }
        else if(vehicleType.equalsIgnoreCase("car")) {
            this.carParkingSpots = spot;
            this.availableCarSpot = spot.size();
        }
        else if(vehicleType.equalsIgnoreCase("bus")) {
            this.busParkingSpots = spot;
            this.availableBusTruckSpot = spot.size();
        }
    }

    public ParkingSpot getParkingSpots(Vehicle vehicle) {
        if(isFull(vehicle))
            throw new RuntimeException("parking spot is not available");
        Optional<ParkingSpot> optn = Optional.empty();
        if(vehicle.vehicleType.equalsIgnoreCase("motorcycle")){
            optn =  motorCycleParkingSpots.stream().filter(e-> e.isFree).findFirst();
            if(optn.isPresent()){
                availableMotorcycleSpot--;
            }
        }
        else if(vehicle.vehicleType.equalsIgnoreCase("car")){
             optn =  carParkingSpots.stream().filter(e-> e.isFree).findFirst();
            if(optn.isPresent()){
                availableCarSpot--;
            }

        }
        else if(vehicle.vehicleType.equalsIgnoreCase("bus")){
            optn =  busParkingSpots.stream().filter(e-> e.isFree).findFirst();
            if(optn.isPresent()){
                availableBusTruckSpot--;
            }
        }
        return optn.get();
    }


    private boolean isFull(Vehicle vehicle){
        if(vehicle.vehicleType.equalsIgnoreCase("motorcycle"))
            return availableMotorcycleSpot > 0 ? false : true;
        else if(vehicle.vehicleType.equalsIgnoreCase("car") || vehicle.vehicleType.equalsIgnoreCase("suv"))
            return availableCarSpot > 0 ? false : true;
        else if(vehicle.vehicleType.equalsIgnoreCase("bus") || vehicle.vehicleType.equalsIgnoreCase("truck"))
            return availableBusTruckSpot > 0 ? false : true;
        return true;
    }

}
