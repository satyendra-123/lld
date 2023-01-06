package com.scaler.learn.singleton;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SingletonMultiThread {
  private static SingletonMultiThread smt;
  private SingletonMultiThread() {

  }

  //does not work because every thread intially can enter in line 15 and only one thread will be allowed to create object but other thread will resume and
  //will still execute the object creation once the lock is released over the class by thread
  //or check once again if smt is already crated by any other thread now.
  public static SingletonMultiThread getInstance() {
    if (smt == null) {
      synchronized (SingletonMultiThread.class) {
        smt = new SingletonMultiThread();
      }
    }
    return smt;
  }

 //fails for the same reason as above
  public static SingletonMultiThread getInstanceV2() {
    if (smt == null) {
        Lock lock = new ReentrantLock();
        lock.lock();
        smt = new SingletonMultiThread();
        lock.unlock();
    }
    return smt;
  }

  //works fine as singleton
  public static SingletonMultiThread getInstanceV3() {
    if (smt == null) {
      synchronized (SingletonMultiThread.class) {
        if(smt == null)
          smt = new SingletonMultiThread();
      }
    }
    return smt;
  }
}
