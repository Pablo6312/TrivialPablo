package io.keepcoding.questions;

import java.util.ArrayList;

public class Question {

	private String text;
	private ArrayList<Answer> answers;
	
	/**
	 * Verifica si la opción en el índice proporcionado es correcta.
	 * 
	 * @param index El indice de la opción de respuesta que se verificará.
	 * @return true si la opción en el índice proporcionado es correcta, false de lo contrario.
	 */
	public boolean isCorrect (int index) {
		return answers.get(index-1).getCorrect();
	}

	
	////////////////////////////////////////////////////////////
	//Constructor
	public Question(String text, ArrayList<Answer> answers) {
		super();
		this.text = text;
		this.answers = answers;
	}

	//Getters and Setters
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public ArrayList<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(ArrayList<Answer> answers) {
		this.answers = answers;
	}
	
	
	
}
