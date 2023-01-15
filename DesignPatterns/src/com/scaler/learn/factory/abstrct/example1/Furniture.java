package com.scaler.learn.factory.abstrct.example1;

public abstract class Furniture {

  private FurnitureFactory factory;



  private int price;
  protected String name;

  public abstract void myUse();

  Furniture(int price){
    this.price = price;
  }

  public int getPrice() {
    return price;
  }

  public String getName(){
    return name;
  }

  public void setFactory(FurnitureFactory factory) {
    this.factory = factory;
  }

}
