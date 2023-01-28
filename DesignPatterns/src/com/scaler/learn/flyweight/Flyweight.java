package com.scaler.learn.flyweight;

public class Flyweight {
  private int avatar;
  private int initialAmo;
  private int initialHealth;

  public int getAvatar() {
    return avatar;
  }

  public int getInitialAmo() {
    return initialAmo;
  }

  public int getInitialHealth() {
    return initialHealth;
  }

  private Flyweight(int avatar, int initialAmo, int initialHealth){
      this.avatar = avatar;
      this.initialAmo = initialAmo;
      this.initialHealth = initialHealth;
  }

  static class Builder{
    private int avatar;
    private int initialAmo;
    private int initialHealth;

    public Builder setAvatar(int avatar) {
      this.avatar = avatar;
      return this;
    }

    public Builder setInitialAmo(int initialAmo) {
      this.initialAmo = initialAmo;
      return this;
    }

    public Builder setInitialHealth(int initialHealth) {
      this.initialHealth = initialHealth;
      return this;
    }

    Flyweight build(){
      return new Flyweight(this.avatar, this.initialAmo, this.initialHealth);
    }
  }

  static Builder builder(){
    return new Builder();
  }


}
