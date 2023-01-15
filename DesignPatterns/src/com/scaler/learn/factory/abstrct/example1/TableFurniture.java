package com.scaler.learn.factory.abstrct.example1;

public class TableFurniture extends FurnitureShop{
  @Override
  public Furniture getFurniture() {
    return getFactory().buildTable();
  }
}
