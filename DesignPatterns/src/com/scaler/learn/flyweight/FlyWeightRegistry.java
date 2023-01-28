package com.scaler.learn.flyweight;

import java.util.HashMap;

public class FlyWeightRegistry {
  public HashMap<String, Flyweight> map = new HashMap<>();

  private static FlyWeightRegistry flyWeightRegistry;

  private FlyWeightRegistry(){
  }

  public void fillWith(String key, Flyweight val){
      map.put(key, val);
  }

  public static FlyWeightRegistry getInstance(){
      if(flyWeightRegistry == null) {
        synchronized (FlyWeightRegistry.class) {
          if (flyWeightRegistry == null)
              flyWeightRegistry = new FlyWeightRegistry();
        }
      }
      return flyWeightRegistry;
  }
}
