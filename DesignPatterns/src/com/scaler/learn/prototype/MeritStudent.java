package com.scaler.learn.prototype;

public class MeritStudent extends Student{

  private boolean scholarship;

  public void setScholarship(boolean scholarship) {
    this.scholarship = scholarship;
  }

  //copy ctor
  public MeritStudent(MeritStudent s){
    super(s);
    this.scholarship = s.scholarship;
  }

  public MeritStudent(){

  }

  //merit student
  @Override
  public Student clone() {
    return new MeritStudent(this);
  }


}
