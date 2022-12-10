package com.parking;

import java.time.LocalDateTime;

public class ParkingTicket {
    static int ticketNumber;
    static int receiptNumber;
    LocalDateTime entryDateTime;
    boolean active;
    LocalDateTime exitDateTime;
    int fee;

    public ParkingTicket(LocalDateTime entryDateTime) {
        this.entryDateTime = entryDateTime;
        this.active = true;
        ticketNumber++;
    }

    public void discardTicket(LocalDateTime exitDateTime, int fee){
        this.active = false;
        this.exitDateTime = exitDateTime;
        this.fee = fee;
        receiptNumber++;
    }

    public void printReciept(){
        System.out.println("Parking Receipt ");
        System.out.println(receiptNumber+ " \n "+ "Entry Date Time "+ entryDateTime+ " \n "+ "Exit Date Time "+exitDateTime +" \n "+ " Fee "+fee);
    }

    public void printTicket(int spotNumber){
        System.out.println("Parking Ticket ");
        System.out.println(ticketNumber+ " \n "+ "Entry Date Time "+ entryDateTime+ " \n "+ "Spot Number "+ spotNumber);
    }

}
