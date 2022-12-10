package com.parking;

import java.time.LocalDateTime;
import java.util.List;

public class MallParkingLot extends ParkingLot{

    int car_suv_spot;
    int bus_truck_spot;

    public MallParkingLot(Address address, List<ParkingFloor> parkingFloors, ParkingFee parkingFee,
                          int totalMotorcycleSpot, int car_suv_spot, int bus_truck_spot) {
        this.address = address;
        this.parkingFloors = parkingFloors;
        this.parkingFee = parkingFee;
        this.totalMotorcycleSpot = totalMotorcycleSpot;
        this.car_suv_spot = car_suv_spot;
        this.bus_truck_spot = bus_truck_spot;
    }

    @Override
    public ParkingTicket parkVehicle(Vehicle vehicle, LocalDateTime parkingTime) {
       ParkingFloor floor = getAvailableFloor(vehicle);
       ParkingSpot spot = floor.getParkingSpots(vehicle);
       if(spot == null)
           throw new RuntimeException("no parking spot available");
       spot.assignSpot(vehicle);
       ParkingTicket ticket = new ParkingTicket(parkingTime);
       ticket.printTicket(spot.number);
       return ticket;
    }

    @Override
    public void unParkVehicle(Vehicle vehicle, ParkingTicket parkingTicket, LocalDateTime unparkTime) {
        if(parkingTicket.active){
            int fee = calculateFee(vehicle, parkingTicket, unparkTime);
            parkingTicket.discardTicket(unparkTime, fee);
            parkingTicket.printReciept();
        }
    }

    private int calculateFee(Vehicle vehicle, ParkingTicket ticket, LocalDateTime unParkTime){
        System.out.println("calculate fee for a vehicle");
        if (parkingFee instanceof MallParkingFee mfp) {
            if(vehicle.vehicleType.equalsIgnoreCase("motorcycle"))
                return mfp.motorCyclePerHourRate;
            else if(vehicle.vehicleType.equalsIgnoreCase("car"))
                return mfp.carSuvPerHourRate;
            else if(vehicle.vehicleType.equalsIgnoreCase("bus"))
                return mfp.busTruckPerHourRate;
        }
        return 0;
    }

    private ParkingFloor getAvailableFloor(Vehicle vehicle){
          if(vehicle.vehicleType.equalsIgnoreCase("motorcycle"))
             return parkingFloors.stream().filter(d-> d.availableMotorcycleSpot > 0).findFirst().get();
          else if(vehicle.vehicleType.equalsIgnoreCase("car"))
                return  parkingFloors.stream().filter(d-> d.availableCarSpot > 0).findFirst().get();
          else if(vehicle.vehicleType.equalsIgnoreCase("truck") || vehicle.vehicleType.equalsIgnoreCase("bus"))
             return parkingFloors.stream().filter(d-> d.availableBusTruckSpot > 0).findFirst().get();
          throw new RuntimeException("no parking floor available");
    }

}
