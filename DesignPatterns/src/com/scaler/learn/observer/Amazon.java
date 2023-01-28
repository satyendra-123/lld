package com.scaler.learn.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * amazon is an online shop
 * when some order is placed there need to be multiple action needs to be notified about order
 * - update inventory
 * - send email
 * - send sms
 * - seller needs to be notified
 * <p>
 * Brute Force:
 * create amazon and when createOrder is called invoke facade to take actions
 * <p>
 * Observer Pattern
 * - publish and subscriber model
 * - all subscribers get registered to publisher when they are up
 * - subscribers can get the notifications eg: if amazon publishes some message about order all subscribers can get the order information and use it
 * - to send notifications to these subscribers
 */
public class Amazon {
  List<Observer> observers = new ArrayList<>();

  private static Amazon amazon;

  public static Amazon getAmazon() {
    if (amazon == null) {
      synchronized (Amazon.class) {
        if (amazon == null)
          amazon = new Amazon();
      }
    }
    return amazon;
  }

  public void placeOrder() {
    for (Observer observer : observers) {
      observer.orderCreated(new Order(123, "order placed"));
    }
  }

  public void registerSubscriber(Observer observer) {
    this.observers.add(observer);
  }
}
