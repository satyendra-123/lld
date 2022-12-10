package com.parking;

public class Vehicle {
    String regNumber;
    String vehicleType;
    ParkingTicket ticket;

    public Vehicle(String regNumber, String vehicleType) {
        this.regNumber = regNumber;
        this.vehicleType = vehicleType;
    }

    public void assignTicket(ParkingTicket ticket){
        this.ticket = ticket;
    }
}
