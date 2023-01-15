package com.scaler.learn.prototype;

import java.util.HashMap;

public class Registry {

  private static Registry registryObj;

  private HashMap<String, Student> registry;

  public HashMap<String, Student> createRegistry(){
    return new HashMap<>();
  }

  private Registry(){

  }

  public static Registry getInstance(){
    if(registryObj == null){
        synchronized (Registry.class){
          if(registryObj == null)
              registryObj = new Registry();
        }
    }
    return registryObj;
  }
}
