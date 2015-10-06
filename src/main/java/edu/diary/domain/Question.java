package edu.diary.domain;

public class Question extends Base{
  String text;
  int score;
  int testId;

 public String getText() {
    return text;
  }
  


public void setText(String text) {
    this.text = text;
  }
  
  public int getScore() {
    return score;
  }
  
  public void setScore(int score) {
    this.score = score;
  }
  
  public int getTestId() {
	return testId;
  }

  public void setTestId(int testId) {
	this.testId = testId;
  }
}
