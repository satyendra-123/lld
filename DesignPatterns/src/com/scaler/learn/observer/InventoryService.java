package com.scaler.learn.observer;

/**
 *
 */
public class InventoryService implements Observer {
  public InventoryService() {
    Amazon amazon = Amazon.getAmazon();
    if (amazon == null)
      throw new RuntimeException("first publisher needs to be up");
    amazon.registerSubscriber(this);
  }

  @Override
  public void orderCreated(Order order) {
    System.out.println(" inventory service received " + order.getOrderId());
  }
}
