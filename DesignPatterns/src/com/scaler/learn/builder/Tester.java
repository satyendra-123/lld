package com.scaler.learn.builder;

public class Tester {
  public static void main(String[] args) {
    //Student s = Student.getBuilder().setName()
    testBuilderPattern();
    testBuilderPatternV2();
  }


  //invalid phone number
  private static void testBuilderPattern(){
    try {
      Student s = Student.getBuilder().setName("satyendra").setId(123).setAge(31).setPhone(Long.valueOf("918971564768"))
          .build();
    }
    catch (Exception ex){
      System.out.println(ex);
    }
  }

  private static void testBuilderPatternV2(){
    try {
      Student s = Student.getBuilder().setName("satyendra").setId(123).setAge(31).setPhone(Long.valueOf("8971564768"))
          .build();
      System.out.println(s.getPhone());
    }
    catch (Exception ex){
      System.out.println(ex);
    }
  }


}
