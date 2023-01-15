package com.scaler.learn.factory.abstrct.example1;

public class Table extends Furniture{

  Table(int price, String name) {
    super(price);
    this.name = name;
  }

  public void myUse() {
    System.out.println(getName()+" is used for working");
  }
}
