package com.parking;

public enum VehicleType {

    MOTORCYCLE("motorcycle"), CAR("car"), BUS("bus"), TRUCK("truck"), SUV("suv");

    private String value;

    VehicleType(String value) {
        this.value = value;
    }
}
