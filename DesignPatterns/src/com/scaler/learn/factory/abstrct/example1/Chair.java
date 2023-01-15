package com.scaler.learn.factory.abstrct.example1;

public class Chair extends Furniture {

  Chair(int price, String name) {
    super(price);
    this.name = name;
  }

  public void myUse() {
    System.out.println(getName()+" is used for sitting");
  }
}
