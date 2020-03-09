/*
 * this class creates the instructions frame
 * the frame explains how Hangman works
 * there is a button that goes back to the opening screen
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Instructions {

	private JFrame rules;
	private JLabel title;
	private JLabel inst1;
	private JLabel inst2;
	private JLabel inst3;
	private JLabel inst4;
	private JButton goBack;
	
	public Instructions()
	{
		rules = new JFrame("Hangman");
		rules.setLocation(700, 500);
		rules.setSize(900, 900);
		rules.getContentPane().setBackground(Color.LIGHT_GRAY);
		rules.setResizable(false);
		rules.setVisible(true);
		rules.setLayout(null);
		setVisible(true);
		
		
		//title label
		title = new JLabel();
		title.setLocation(100, 10);
		title.setSize(600, 100);
		title.setText("Hangman Instructions");
		title.setForeground(Color.black);
		title.setFont(new Font("TimesRoman", Font.ITALIC, 60));
		rules.add(title);
		
		//instruction 1 label
		inst1 = new JLabel();
		inst1.setLocation(120, 100);
		inst1.setSize(600, 100);
		inst1.setText("<html> 1. Begin the game with guessing a letter. </html>");
		inst1.setForeground(Color.black);
		inst1.setFont(new Font("SansSerif", Font.BOLD, 25));
		rules.add(inst1);
		
		//instruction 2 label
		inst2 = new JLabel();
		inst2.setLocation(120, 150);
		inst2.setSize(600, 100);
		inst2.setText("<html> 2. If you guessed correctly, the letter will appear on one or more of the small lines. </html>");
		inst2.setForeground(Color.black);
		inst2.setFont(new Font("SansSerif", Font.BOLD, 25));
		rules.add(inst2);
		
		//instruction 3 label
		inst3 = new JLabel();
		inst3.setLocation(120, 230);
		inst3.setSize(600, 100);
		inst3.setText("<html> 3. If you guessed incorrectly, the letter will appear in the incorrect letter list, "
				+ "and a body part will be added to the hangman. </html>");
		inst3.setForeground(Color.black);
		inst3.setFont(new Font("SansSerif", Font.BOLD, 25));
		rules.add(inst3);
		
		//instruction 4 label
		inst4 = new JLabel();
		inst4.setLocation(120, 310);
		inst4.setSize(600, 100);
		inst4.setText("<html> 4. Until solved or the hangman is pronounced dead, continue the game. </html>");
		inst4.setForeground(Color.black);
		inst4.setFont(new Font("SansSerif", Font.BOLD, 25));
		rules.add(inst4);
		
		//begin button that goes to the game
		goBack = new JButton("Menu");
		goBack.setLocation(300, 700);
		goBack.setSize(300, 100);	
		goBack.setBackground(Color.gray);
		goBack.setFont(new Font("SansSerif", Font.BOLD, 34));
		rules.add(goBack);
				
		goBack.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) { 
				OpeningScreen back = new OpeningScreen();
				back.setVisible(true);
				rules.setVisible(false);
			
			} 
			
			
		} );
		
		
	}
	
	//boolean makes frames visible or invisible
	void setVisible(boolean b) 
	{
		b = true;
	}
	
}


