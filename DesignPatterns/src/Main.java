import com.scaler.learn.singleton.Singleton;
import com.scaler.learn.singleton.SingletonMultiThread;

public class Main {
  public static void main(String[] args) {
    //testSingleton();
    //testSingletonMultiThreaded();
    //testSingletonMultiThreadedV2();
    testSingletonMultiThreadedV3();
  }

  //fails for multi Threads
  private static void testSingleton(){

    Thread t1 = new Thread(() -> {
      Singleton s1 = Singleton.getInstance();
      System.out.println(s1.hashCode() );
      System.out.println(System.identityHashCode(s1) );

    });
    Thread t2 = new Thread(() -> {
      Singleton s2 = Singleton.getInstance();
      System.out.println(s2.hashCode() );
      System.out.println(System.identityHashCode(s2) );
    });
    t1.start();
    t2.start();
  }

  private static void testSingletonMultiThreaded(){
    Thread t1 = new Thread(() -> {
      SingletonMultiThread s1 = SingletonMultiThread.getInstance();
      System.out.println(s1.hashCode() );
      System.out.println(System.identityHashCode(s1) );

    });
    Thread t2 = new Thread(() -> {
      SingletonMultiThread s2 = SingletonMultiThread.getInstance();
      System.out.println(s2.hashCode() );
      System.out.println(System.identityHashCode(s2) );
    });
    t1.start();
    t2.start();
  }

  //failed
  private static void testSingletonMultiThreadedV2(){
    Thread t1 = new Thread(() -> {
      SingletonMultiThread s1 = SingletonMultiThread.getInstanceV2();
      System.out.println(s1.hashCode() );
      System.out.println(System.identityHashCode(s1) );

    });
    Thread t2 = new Thread(() -> {
      SingletonMultiThread s2 = SingletonMultiThread.getInstanceV2();
      System.out.println(s2.hashCode() );
      System.out.println(System.identityHashCode(s2) );
    });
    t1.start();
    t2.start();
  }

  private static void testSingletonMultiThreadedV3(){
    Thread t1 = new Thread(() -> {
      SingletonMultiThread s1 = SingletonMultiThread.getInstanceV3();
      System.out.println(s1.hashCode() );
      System.out.println(System.identityHashCode(s1) );

    });
    Thread t2 = new Thread(() -> {
      SingletonMultiThread s2 = SingletonMultiThread.getInstanceV3();
      System.out.println(s2.hashCode() );
      System.out.println(System.identityHashCode(s2) );
    });
    t1.start();
    t2.start();
  }
}