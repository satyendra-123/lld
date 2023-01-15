package com.scaler.learn.factory.method.example1;

public class B extends A {

  //based on type provide B
  @Override
  protected D getD() {
    return new D1("D1");
  }
}
