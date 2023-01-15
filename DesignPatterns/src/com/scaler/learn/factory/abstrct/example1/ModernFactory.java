package com.scaler.learn.factory.abstrct.example1;

public class ModernFactory extends FurnitureFactory{

  @Override
  public Furniture buildChair() {
    return new ModernChair(200, "modern chair");
  }

  @Override
  public Furniture buildTable() {
    return new ModernTable(100, "modern table");
  }
}
