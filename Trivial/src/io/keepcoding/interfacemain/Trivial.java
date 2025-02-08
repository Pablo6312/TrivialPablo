package io.keepcoding.interfacemain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

import io.keepcoding.game.Player;
import io.keepcoding.questions.Answer;
import io.keepcoding.questions.Category;
import io.keepcoding.questions.Question;
import io.keepcoding.utilities.FilesManager;

public class Trivial {
	
	public static ArrayList<Category> categories = new ArrayList<>();
	public static ArrayList<Player> players= new ArrayList<>();
	
	public static boolean continues = true;
	public static Random random = new Random();

	public static void main(String[] args) {
		
		//Los scanner que se usaran sc para los Strings y scInt para los numeros (las respuestas)
		Scanner sc = new Scanner(System.in);
		Scanner scInt = new Scanner(System.in);
		
		//Guardar las categorias con sus preguntas y estas con sus respuestas
		categories.addAll(FilesManager.getQuestions("questions"));
		//While para inicializar todos los players /Scanners
		String name = "";
		while(!name.equalsIgnoreCase("exit")){
			System.out.println("Introduce el nombre del equipo ('exit' para comenzar el juego)");
			name = sc.nextLine();
			if (name.equalsIgnoreCase("exit"))
				System.out.println("\nEl juego ha comenzado");
			else
				players.add(new Player(name, categories));
		}
		
		//While(true) para empezar el juego cada vez que reinicie el bucle pasa el juegador
		while (continues) {
			
			for (Player player : players) {
					
				title("Turno del equipo: " + player.getName());
				
				//Genero una categoria que no esta obtenida
				String categoryName = "";
				do {
					int randomNumber = random.nextInt(5);
					categoryName=categories.get(randomNumber).getName();
				
				} while(player.getPiePieces().get(categoryName)!=false);
		        
				//Saco las preguntas de la categoria selecionada
				ArrayList <Question> questions = new ArrayList<>();
				
				Category selectedCategory = null;
				for (Category c : categories) {
					if (c.getName().equals(categoryName)) {
						selectedCategory = c;
						break;
					}
				}
				questions.addAll(categories.get(categories.indexOf(selectedCategory)).getQuestions());
				
				//Mezclo las preguntas para que salga una aleatoria y saco una pregunta
				Collections.shuffle(questions);
				
				Question question = questions.get(0);
				//Lo mismo con las respuestas
				ArrayList <Answer> answers = new ArrayList<>();
				answers.addAll(question.getAnswers());
				Collections.shuffle(answers);
				
				title(categoryName);
				System.out.println(" - " + question.getText());
				System.out.println("1. " + answers.get(0).getText());
				System.out.println("2. " + answers.get(1).getText());
				System.out.println("3. " + answers.get(2).getText());
				System.out.println("4. " + answers.get(3).getText());
				System.out.println("Opcion elegida:");
				
				int answer = scInt.nextInt();
				while (answer < 1 || answer > 4) {
					System.out.println("Eligue una de las opciones '1-4");
					answer = scInt.nextInt();
				}
				answer--;
				
				Answer selectedAnswer = answers.get(answer);

				//Compruebo si la respuesta es correcta
				if (selectedAnswer.getCorrect()== true)  { 
					player.getPiePieces().put(categoryName, true);	
				}
				
				//muestro puntuaciones
				for (Player playerA : players) {
					playerA.showPoints();
				}
				
				//y compruebo el ganador y si es asi finaliza
				if (player.hasWon()) {
					continues=false;
					title("Fin del juego, gana el equipo: " + player.getName());
					break;
				} 
				
			}
			
		}
		
	}
	
	//Metodos ya dados, para typar el texto
	public static void title(String text) {
		int length = text.length();
		printHashtagLine(length + 4); // Bordes

        System.out.println("# " + text + " #");

        printHashtagLine(length + 4);
	}
	
	public static void printHashtagLine(int length) {
        for (int i = 0; i < length; i++) {
            System.out.print("#");
        }
        System.out.println();
    }

}
