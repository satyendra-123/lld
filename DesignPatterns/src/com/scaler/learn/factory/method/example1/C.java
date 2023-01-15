package com.scaler.learn.factory.method.example1;

public class C extends A {

  @Override
  protected D getD() {
    return new D2("D2");
  }
}
