package com.scaler.learn.factory.abstrct.example1;

public class ChairFurniture extends FurnitureShop{

  @Override
  public Furniture getFurniture() {
    return getFactory().buildChair();
  }
}
