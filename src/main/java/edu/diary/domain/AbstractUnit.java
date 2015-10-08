package edu.diary.domain;

public abstract class AbstractUnit extends BaseName {
  Tests test;

  public Tests getTest() {
    return test;
  }
  
  public void setTest(Tests test) {
    this.test = test;
  }
}
