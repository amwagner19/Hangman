import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

public class Setting {
	
	private static JFrame game;
	private JButton goBack;
	private Body body; 
	private JLabel showWord; 
	
	public Setting() throws IOException
	{
		//hangman game frame
		game = new JFrame("Hangman");
		game.setLocation(700, 500);
		game.setSize(900, 900);
		game.getContentPane().setBackground(Color.white);
		game.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.setResizable(false);
		game.setVisible(true);
		game.setLayout(null);
		setVisible(true);
		new Letters(game); 
		body = new Body(game); 
		
		showWord=new JLabel(); 
		showWord.setLocation(320, 10);
		showWord.setSize(400, 100);
		showWord.setText("Here is your word:");
		showWord.setForeground(Color.black);
		showWord.setFont(new Font("TimesRoman", Font.ITALIC, 30));
		game.add(showWord); 
		//go back to the main menu button
		goBack = new JButton("Menu");
		goBack.setLocation(300, 700);
		goBack.setSize(300, 100);	
		goBack.setBackground(Color.gray);
		goBack.setFont(new Font("SansSerif", Font.BOLD, 34));
		game.add(goBack);
		
		goBack.addActionListener(new ActionListener() 
		{ 
			public void actionPerformed(ActionEvent e) 
			{ 
				OpeningScreen back = new OpeningScreen();
				back.setVisible(true);
				game.setVisible(false);
				showWord.setVisible(false);
				
			} 
		} );
		
	}

	void setVisible(boolean b) 
	{
		b = true;
	}
	
	public static JFrame getFrame()
	{
		return game; 
	}

	public Body getBody() 
	{
		return body;
	}
	
	public static void endGame()
	{
		game.setVisible(false);
	}


}
