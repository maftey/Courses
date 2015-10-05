package edu.diary.domain;

public abstract class AbstractUnit extends BaseName {
  Test test;

  public Test getTest() {
    return test;
  }
  
  public void setTest(Test test) {
    this.test = test;
  }
}
