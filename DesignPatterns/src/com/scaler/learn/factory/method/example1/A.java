package com.scaler.learn.factory.method.example1;

/**
 *
 *
 * */

public abstract class A {

  //here D depends upon two different type of dependency as per the user need
  //if we use here if conditions to switch between the dependency then it will violate OCP in SOLID
  //hence we cant provide until there is a default depedency to be provided declare the method abstract
  protected abstract D getD();

  public void doSomething(){
    D d = getD();
    //use d here in common method to do somthing
    System.out.println(" using "+d.getName()+" to do something");
  }
}
