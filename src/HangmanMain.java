/*
 * the HangmanMain class is the main for the Hangman game
 * the opening screen is opened, which can lead to the game or the instructions
 * the main goes through the randomWord method in the RandomWord class
 * It picks the random word, and then, the uses loops to go through the word as the person picks letters
 * the dashes are replaced when the letters are correct
 * if the word is completely guessed correctly, the game says the user won
 */

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class HangmanMain {

	public static char yesOrNo;
	public static String randomWord;
	public static boolean over;
	public static String lettersGuessed;
	public static String letterAttempt;
	public static char letterGuess;
	public static StringBuffer dashLetters;
	public static Body body;
	public static OpeningScreen screen;
	public static Scanner wordFile;
	public static Scanner keyboard;
	public static RandomWord word;
	public static JFrame playAgainFrame;
	public static JLabel question;
	public static JButton yes;
	public static JButton no;
	public static JFrame game;
	public static JLabel showWord;
	public static JLabel winOrLoss;
	public static JLabel theWordWas; 

	public static void main(String[] args) throws IOException 
	{
		screen = new OpeningScreen();
		word = new RandomWord();
		randomWord = word.getRandomWord();
		System.out.println(randomWord); //must delete
		dashLetters = dashesWord(randomWord);
		lettersGuessed = "";
		showWord = new JLabel();
		
	}
	
	public static StringBuffer dashesWord(String word) 
	{
		StringBuffer dashLetters = new StringBuffer(word.length());
		
		// this goes the word and makes dashes for the letters
		for (int i = 0; i < word.length(); i++) 
		{
			dashLetters.append('-');
		}
		
		System.out.println("The letter count is " + word.length());
		return dashLetters;
	}

	public static void wordMatch(String randomWord, StringBuffer dashLetters, char letterGuess) 
	{

		for (int i = 0; i < randomWord.length(); i++) 
		{
			if (randomWord.charAt(i) == letterGuess) 
			{
				dashLetters.setCharAt(i, letterGuess);
			}
		}
		
	}


	public static void gamePlay2() throws IOException 
	{
		
		keyboard = new Scanner(System.in);
		wordFile = new Scanner(new FileReader("Word"));

		yesOrNo = 'N';
		body = screen.getBody();

		game = Setting.getFrame();
		game.remove(showWord);
		
		//showWord = new JLabel();
		

		// shows the right and wrong letters guessed
		System.out.println("These are the letters you guessed: " + lettersGuessed);

		letterAttempt = Letters.getLetter().toLowerCase();
		letterGuess = letterAttempt.charAt(0);
		lettersGuessed += letterGuess;
		
		wordMatch(randomWord, dashLetters, letterGuess);
		
		showWord.setLocation(320, 10);
		showWord.setSize(400, 100);
		showWord.setText("Here is your word:" + dashLetters);
		showWord.setForeground(Color.black);
		showWord.setFont(new Font("TimesRoman", Font.ITALIC, 30));
		
		game.add(showWord);
		game.remove(showWord);
		game.add(showWord);
		game.repaint();
		
		if (!randomWord.contains(letterAttempt)) 
		{
			body = screen.getBody();
			body.setBody();
		}

		if (body != null && body.getBody() == 0) 
		{
			winOrLoss = new JLabel();
			winOrLoss.setLocation(808, 100);
			winOrLoss.setSize(400, 100);
			winOrLoss.setText("You Lost!");
			winOrLoss.setForeground(Color.black);
			winOrLoss.setFont(new Font("TimesRoman", Font.ITALIC, 20));
			game.add(winOrLoss);

			game.add(showWord);
			game.repaint();
			
			theWordWas = new JLabel();
			theWordWas.setLocation(608,200);
			theWordWas.setSize(600,100);
			theWordWas.setText("The word was: " + randomWord);
			theWordWas.setForeground(Color.black);
			theWordWas.setFont(new Font("TimesRoman", Font.ITALIC, 20));
			game.add(theWordWas);
			
			game.add(showWord);
			game.repaint();

		}

		if (randomWord.equals(dashLetters.toString())) 
		{
			winOrLoss = new JLabel();
			winOrLoss.setLocation(808, 100);
			winOrLoss.setSize(400, 100);
			winOrLoss.setText("You Won!");
			winOrLoss.setForeground(Color.black);
			winOrLoss.setFont(new Font("TimesRoman", Font.ITALIC, 20));
			game.add(winOrLoss);

			game.add(showWord);
			game.repaint();
		}
	}
	
	public static StringBuffer getDashLetters()
	{
		return dashLetters; 
	}

	
	
}




