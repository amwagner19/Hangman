/*
 * This class reads from the text file, Word.txt.
 * the random word method goes through the text file and picks a random word from the file for the Hangman game.
 */

import java.util.ArrayList;
import java.util.Random;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class RandomWord {
	
	//creates an array list
	private ArrayList<String>allWords = new ArrayList<String>();
	
	public RandomWord() 
	{		
		 String name = "Word";
		 String line = null;
		
		 
		 try 
		 {
			 FileReader fileReader = new FileReader(name);
			 
			 BufferedReader read = new BufferedReader(fileReader);
			 
			 //the while loop adds the each word, which is on
			 //its own line to the array list
			 while((line = read.readLine()) != null )
			 {
				 allWords.add(line);
				
			 }
			 
			read.close();   
		 }
		 
		 catch(FileNotFoundException ex)
		 {
			 System.out.println("File not found: " + name);
		 }
		 
		 catch(IOException ex)
		 {
			 System.out.println("Error reading " + name);
		 }
		
	}
	
	//this method gets the random word from the text file
	public String getRandomWord() 
	{
		String name = "Word";
		
		//gets random number
		Random random = new Random();
		//must use allWords.size to get the number of the 
		//lines to be associated with the words
		int randomNum = random.nextInt(allWords.size());
		
		try 
		 {
			//reads the file
			 FileReader fileReader = new FileReader(name);
			 
			 BufferedReader read = new BufferedReader(fileReader);
			 int lineNum = 0;
			 
			 //the while loop goes through the the lines of the text file
			 //as long as the line number value is lower than the random number
			 //and name isn't null
			 while((lineNum < randomNum) && (name != null) )
			 {
				 lineNum++;
			 }
			 
			 read.close(); 
			 
		 }
		catch(IOException ex)
		 {
			 System.out.println("Error reading " + name);
		 }
		
		return allWords.get(randomNum);
	}
	
	
	
}



