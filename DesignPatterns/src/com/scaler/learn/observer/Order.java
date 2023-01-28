package com.scaler.learn.observer;

public class Order {
  private int orderId;
  private String description;

  public int getOrderId() {
    return orderId;
  }

  public String getDescription() {
    return description;
  }

  Order(int orderId, String description){
      this.orderId = orderId;
      this.description = description;
  }
}
