package com.scaler.learn.decorator;

public class Cone extends IceCream{

  public Cone(){
    super(6);
  }


  public String getDescription() {
    return "base cone";
  }
}
