package com.scaler.learn.observer;

public class EmailService implements Observer{

  public EmailService(){
      Amazon amazon = Amazon.getAmazon();
      if(amazon == null)
        throw new RuntimeException("first publisher needs to be up");
      amazon.registerSubscriber(this);
  }

  @Override
  public void orderCreated(Order order) {
    System.out.println("email service received "+ order.getOrderId());
  }
}
