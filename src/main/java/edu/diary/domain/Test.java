package edu.diary.domain;

import java.util.Set;

public class Test extends BaseName {
	private Set<Question> question;
	private int passedScore = 60;
	
	public Set<Question> getQuestion() {
		return question;
	}
	public void setQuestion(Set<Question> question) {
		this.question = question;
	}
	public int getPassedScore() {
		return passedScore;
	}
	public void setPassedScore(int passedScore) {
		this.passedScore = passedScore;
	}
}
