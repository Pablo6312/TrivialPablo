package io.keepcoding.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import io.keepcoding.questions.Answer;
import io.keepcoding.questions.Category;
import io.keepcoding.questions.Question;

public class FilesManager {
	
	/**
     * El array que devuelve es un array de categorias, que dentro 
     * lleva el array de cada categoria con todas sus preguntas 
     * 
     * @param fileName El nombre del directorio que contiene los archivos con las preguntas.
     * @return Una lista de objetos {@code Category}, cada uno con su nombre y sus preguntas asociadas.
     *         Retorna {@code null} si el directorio no existe.
     */
	public static ArrayList<Category> getQuestions (String fileName){
		
		ArrayList<Category> categories = new ArrayList<Category>();
		Scanner sc = new Scanner(System.in);
		
		File folder = new File(fileName);
		
		if (!folder.exists()) {
			System.out.println("El fichero indroducido no existe.");
			return null;
		} else {
			
			File[] fileList = folder.listFiles();
			
			for (File file : fileList) {
				
				String categoryName = file.getName().substring(0, file.getName().length() - 4);
				ArrayList<Question> questions = new ArrayList<Question>();
				
				if (categoryName.equals(".pro")) {
					
					//si entra aqui es porque eclipse ha creado el fichero .project y tiene 
					//que pasar de largo sin hacer nada al siguiente fichero
					
				} else {
					
					try {
						
						sc = new Scanner(file);
						
						while (sc.hasNextLine()) {
							
							//Leo la pregunta y las respuestas
							String question = sc.nextLine();
							String answerC = sc.nextLine();
							String answer2 = sc.nextLine();
							String answer3 = sc.nextLine();
							String answer4 = sc.nextLine();
							
							//Y las guardo
							ArrayList<Answer> answers = new ArrayList<Answer>();
							answers.add(new Answer(answerC, true));
							answers.add(new Answer(answer2, false));
							answers.add(new Answer(answer3, false));
							answers.add(new Answer(answer4, false));
							
							questions.add(new Question(question, answers));
							
						}
						
						categories.add(new Category(categoryName, questions));
						
					} catch (FileNotFoundException e){
						System.err.println("Error en el fichero." + e.getMessage());
					}
					
				}
				
			}
			
			return categories;
			
		}
		
	}
}
