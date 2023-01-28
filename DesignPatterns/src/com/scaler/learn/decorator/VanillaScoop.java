package com.scaler.learn.decorator;

/**
 * we should not allow to give vanilla scoop as a icecream
 * */
public class VanillaScoop extends IceCream{

  private IceCream iceCream;

  public VanillaScoop(IceCream iceCream){
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
    return iceCream.getDescription() +" with vanilla scoop";
  }
}
