package edu.diary.domain;

import java.util.Set;

public class Tests extends BaseName implements Comparable<Tests> {
	
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

	@Override
	public int compareTo(Tests other) {
		return getId() - other.getId();
	}
	@Override
	public String toString(){
		return " Tests{" 
				+ "id= " + getId() + ", name: " + getName()
				+ ", startDate: " + formatDate(getStartDate()) 
				+ ", endDate: " + formatDate(getEndDate())
				+ ", enabled: " + isEnabled() 
				+ ", passedScore: "+ getPassedScore()
				+ "}";
	}
}
