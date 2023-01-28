package com.scaler.learn.flyweight;

/**
 * if we are building  a game and we need to make 1000s of player objects for different types
 * where certain prperties are extrinsic and a few are intrinsic (remains same for all)
 * here the memory required for these objects can be huge. to reduce it we need to have the objects with intrinsic attributes
 * seprately
 */
public class Player {
  private String name;
  private int currentAmo;
  private int currentHealth;
  private Flyweight flyweight;

  public String getName() {
    return name;
  }

  public int getCurrentAmo() {
    return currentAmo;
  }

  public int getCurrentHealth() {
    return currentHealth;
  }

  public Flyweight getFlyweight() {
    return flyweight;
  }

  private Player(String name, int currentAmo, int currentHealth, Flyweight flyweight) {
    this.name = name;
    this.currentAmo = currentAmo;
    this.currentHealth = currentHealth;
    this.flyweight = flyweight;
  }

  static class Builder {
    private String name;
    private int currentAmo;
    private int currentHealth;
    private Flyweight flyweight;

    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    public Builder setCurrentAmo(int currentAmo) {
      this.currentAmo = currentAmo;
      return this;
    }

    public Builder setCurrentHealth(int currentHealth) {
      this.currentHealth = currentHealth;
      return this;
    }

    public Builder setFlyweight(Flyweight flyweight) {
      this.flyweight = flyweight;
      return this;
    }

    Player build() {
      return new Player(this.name, this.currentAmo, this.currentHealth, this.flyweight);
    }
  }

  static Builder builder() {
    return new Builder();
  }
}
