package com.scaler.learn.decorator;

/**
 * create a ice cream which can provide a base cone
 * a layer of syrup then we can add some scoops of different types eg: vanilla, strawberry, butterscotch
 * additionally user can add choco chip, cherry on top as add on
 * constraint:
 * - icecream must have a base (cone)
 */
public abstract class IceCream {

  public int getPrice() {
    return price;
  }

  protected int price;

  IceCream(int price) {
    this.price = price;
  }

  public abstract String getDescription();
}
