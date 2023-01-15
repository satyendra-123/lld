package com.scaler.learn.prototype;

/**
 * Scenario
 * when we need a student with very few properties to be chagned rest all can be copied from existing template
 */
public class Student implements Prototype<Student> {
  public int getAge() {
    return age;
  }

  public int getId() {
    return id;
  }

  public long getPhoneNumber() {
    return phoneNumber;
  }

  public String getInstructor() {
    return instructor;
  }

  private int age;
  private int id;
  private long phoneNumber;

  private String instructor;

  public void setInstructor(String instructor) {
    this.instructor = instructor;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setPhoneNumber(long phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  //copy constructor
  //it can copy the properties from provided object into current object
  public Student(Student s) {
    this.instructor = s.instructor;
  }

  public Student() {
  }

  @Override
  public Student clone() {
    return new Student(this);
  }
}
