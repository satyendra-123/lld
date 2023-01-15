package com.scaler.learn.builder;

/**
 *   student should not be allowed to create as half baked
 *   pass all validations only then it should be allowed
 *   eg: phone should be min and max 10 digits
 *   eg: age should be only number
 *   name should not contain any numerical value
 */
public class Student {
  private int age;
  private String name;
  private int id;

  private long phone;

  public int getAge() {
    return age;
  }

  public String getName() {
    return name;
  }

  public int getId() {
    return id;
  }

  public long getPhone() {
    return phone;
  }

  private Student(Builder b) {
    this.age = b.age;
    this.name = b.name;
    this.id = b.id;
    this.phone = b.phone;
  }

  static class Builder {
    private int age;
    private String name;
    private int id;

    private long phone;

    public Builder setAge(int age) {
      this.age = age;
      return this;
    }

    public Builder setId(int id) {
      this.id = id;
      return this;
    }

    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    public Builder setPhone(long phone) throws RuntimeException {
      if (String.valueOf(phone).length() != 10)
          throw new RuntimeException("invalid phone number");
      this.phone = phone;
      return this;
    }

    public Student build(){
      return new Student(this);
    }

  }

  //why it need to be static because to getBuilder itself we need a student object first
  public static Builder getBuilder(){
    return new Builder();
  }
}
