package com.scaler.learn.factory.abstrct.example1;
/**
 Imagine that you’re creating a furniture shop simulator. Your code consists of classes that represent:

 A family of related products, say: Chair + Sofa + CoffeeTable.

 Several variants of this family. For example, products Chair + Sofa + CoffeeTable are available in these variants: Modern, Victorian, ArtDeco.

    FurnitureShop
        |
 Chair  Sofa  CoffeeTable
   |      |      |
 M V A   M V A   M V A

it might cause class explosion

 * */
public abstract class FurnitureShop{

   public abstract Furniture getFurniture();

   private FurnitureFactory factory;

  public void setFactory(FurnitureFactory factory) {
    this.factory = factory;
  }

  public FurnitureFactory getFactory() {
    return factory;
  }
}