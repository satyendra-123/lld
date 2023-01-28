package com.scaler.learn.decorator;

public class ButterscotchScoop extends IceCream{

  private IceCream iceCream;

  public
  ButterscotchScoop(IceCream iceCream){
    super(10);
    if(iceCream == null)
      throw new RuntimeException("invalid");
    this.iceCream = iceCream;
  }

  @Override
  public int getPrice() {
    return this.iceCream.getPrice()+this.price;
  }

  public String getDescription() {
    return iceCream.getDescription() +" with butterscotch scoop";
  }
}
