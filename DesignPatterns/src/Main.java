import java.util.HashMap;

import com.scaler.learn.adapter.BankApi;
import com.scaler.learn.adapter.PhonePe;
import com.scaler.learn.adapter.YesBankAdapter;
import com.scaler.learn.decorator.ButterscotchScoop;
import com.scaler.learn.decorator.Cone;
import com.scaler.learn.decorator.IceCream;
import com.scaler.learn.decorator.VanillaScoop;
import com.scaler.learn.factory.abstrct.example1.ChairFurniture;
import com.scaler.learn.factory.abstrct.example1.Furniture;
import com.scaler.learn.factory.abstrct.example1.FurnitureShop;
import com.scaler.learn.factory.abstrct.example1.ModernFactory;
import com.scaler.learn.factory.abstrct.example1.TableFurniture;
import com.scaler.learn.factory.method.example1.A;
import com.scaler.learn.factory.method.example1.B;
import com.scaler.learn.factory.method.example1.C;
import com.scaler.learn.observer.Amazon;
import com.scaler.learn.observer.EmailService;
import com.scaler.learn.observer.InventoryService;
import com.scaler.learn.prototype.MeritStudent;
import com.scaler.learn.prototype.Registry;
import com.scaler.learn.prototype.Student;
import com.scaler.learn.singleton.Singleton;
import com.scaler.learn.singleton.SingletonMultiThread;

public class Main {
  public static void main(String[] args) {
    //testSingleton();
    //testSingletonMultiThreaded();
    //testSingletonMultiThreadedV2();
    //testSingletonMultiThreadedV3();
   // testProtoType();
    //testFactoryMethod();
   // testAbstractFactoryPattern();
   // testDecorator();
    testObserver();
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


  //Builder Pattern Tester


  //Prototype Pattern Tester
  private static void testProtoType(){
    Registry registry = Registry.getInstance();
    HashMap<String, Student> map = registry.createRegistry();
    Student st = new Student();
    st.setInstructor("sumeet");
    map.put("student", st);

    MeritStudent mst = new MeritStudent();
    mst.setInstructor("sumeet");
    mst.setScholarship(true);
    map.put("merit-student", mst);


    Student s2 = map.get("student").clone();
    Student s3 = map.get("student").clone();
    Student s4 = map.get("student").clone();

    System.out.println(System.identityHashCode(s2)+" "+System.identityHashCode(s3)+ " " +System.identityHashCode(s4));

    assert(s2.getInstructor()).equals(s3.getInstructor());
    assert(s3.getInstructor()).equals(s4.getInstructor());

  }

  /**
   * factory method
   */
  private static void testFactoryMethod(){
      //here we can inject any type of dependency based on the object
     //it is ocp but we usually inject depdency in spring kind of frameworks by identifying the class
    A a = new B();
    a.doSomething();
    a = new C();
    a.doSomething();
  }


  private static void testAbstractFactoryPattern(){
    //here we can inject any type of dependency based on the object
    //it is ocp but we usually inject depdency in spring kind of frameworks by identifying the class
    //user wants to buy a modern chair from a furniture shop
    ModernFactory mf = new ModernFactory();
    FurnitureShop fs = new ChairFurniture();
    fs.setFactory(mf);
    Furniture furniture = fs.getFurniture();
    furniture.myUse();
    System.out.println(furniture.getName());


    //modern table
    fs = new TableFurniture();
    fs.setFactory(mf);
    furniture = fs.getFurniture();
    furniture.myUse();
    System.out.println(furniture.getName());
  }


  //adapter
  private void testAdapter(){
    BankApi yb = new YesBankAdapter();
    PhonePe p = new PhonePe(yb);
    p.checkBalance();
  }

  //test decorator
  private static void testDecorator(){
    IceCream iceCream = new Cone();
    VanillaScoop vs = new VanillaScoop(iceCream);
    ButterscotchScoop bs = new ButterscotchScoop(vs);
    System.out.println(bs.getPrice());
    System.out.println(bs.getDescription());
  }

  //test observer
  private static void testObserver(){
    Amazon amazon = Amazon.getAmazon();
    new EmailService();
    new InventoryService();
    amazon.placeOrder();
  }
}