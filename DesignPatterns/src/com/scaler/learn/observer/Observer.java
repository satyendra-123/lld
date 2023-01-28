package com.scaler.learn.observer;

/**
 * as soon as these services are up should be registered to publisher
 */
public interface Observer {
  public void orderCreated(Order order);
}
