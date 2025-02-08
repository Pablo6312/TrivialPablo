package io.keepcoding.game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import io.keepcoding.questions.Category;

public class Player {
	
	String name;
	
	/*
	 * Este HashMap hace referencía a las categorias pero no de la misma forma,
	 * que la clase Category, ya que, esa son solo las categorías con las preguntas,
	 * que su objeto no se modificará ni se añadira a otro para no crear 10 arrays entre
	 * categorias preguntas y respuestas cada vez que se quiere crear un player,
	 * y este sirve para ir contando que categorías va consiguiendo el jugador.
	 * Y es un HashMap para poder guardar el nombre y saber cuales son las obtenidas.
	*/
	private HashMap<String, Boolean> piePieces;
	
	 /**
	 * Verifica si el jugador ha ganado, lo que significa que todas las categorías han sido acertadas.
	 *
	 * @return true si todas las categorías en piePieces son true, false de lo contrario.
	 */
	public boolean hasWon() {
		return !piePieces.containsValue(false);
	}
	
	/**
     * Muestra el nombre del jugador junto con el estado de cada categoría en piePieces.
     * Imprime el nombre del jugador seguido de cada categoría y su estado (true o false).
     */
	public void showPoints() {
		System.out.println(this.name);
		for (var p : piePieces.entrySet()) {
			System.out.println(" - " + p.getKey() + ": " + p.getValue());
		}
		
	}

	////////////////////////////////////////////////////////////////////////
	//Constructor
	public Player(String name, ArrayList<Category> Categories) {
		
		this.name = name;
		
		//Inicializo directamente los 5 puntos sin obtener(false) que serian las categorias de los quesitos
		this.piePieces = new HashMap<>();
		
		//Con este for no hace falta poner los nombres otra vez, los saco del array ya creado estatico
		for (Category category : Categories) {
			piePieces.put(category.getName(), false);
		}
		
	}
	
	//GETTERS AND SETTERS
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public HashMap<String, Boolean> getPiePieces() {
		return piePieces;
	}

	public void setPiePieces(HashMap<String, Boolean> piePieces) {
		this.piePieces = piePieces;
	}
	
}
