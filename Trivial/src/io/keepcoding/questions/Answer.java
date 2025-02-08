package io.keepcoding.questions;

public class Answer {
	
	private String text;
	private boolean correct;
	
	
	
	//Constructor
	public Answer(String text, boolean correct) {
		super();
		this.text = text;
		this.correct = correct;
	}
	
	//Getters and Setters
	public boolean getCorrect() {
		return correct;
	}

	public void setCorrect(boolean correct) {
		this.correct = correct;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
}
