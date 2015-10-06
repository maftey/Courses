package edu.diary.domain;

public class Lesson extends AbstractUnit {
  private String text;
  private int moduleId;

  public int getModuleId() {
	return moduleId;
}

public void setModuleId(int moduleId) {
	this.moduleId = moduleId;
}

public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }
}
