/*
 * The OpeningScreen class creates the game's greeting screen
 * the frame has a button that leads to the Setting class, which is where the game graphics is
 * there is also a button that leads to the Instructions class, which is where the game instructions are
 * the opening frame closes by the set visible boolean 
 */


import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;

public class OpeningScreen {

	private JFrame opening;
	private JLabel title;
	private JLabel start;
	private JLabel rulesLabel;
	private JButton beginButton;
	private JButton instructBut;
	private Setting set;

	public OpeningScreen(){
		
		//frame
		opening = new JFrame("Opening Screen");
		opening.setLocation(700, 500);
		opening.setSize(900, 500);
		opening.getContentPane().setBackground(Color.black);
		opening.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		opening.setResizable(false);
		opening.setVisible(true);
		opening.setLayout(null);
		
		//title label
		title = new JLabel();
		title.setLocation(320, 10);
		title.setSize(600, 100);
		title.setText("Hangman");
		title.setForeground(Color.white);
		title.setFont(new Font("TimesRoman", Font.ITALIC, 60));
		opening.add(title);
		

		//start description label
		start = new JLabel();
		start.setLocation(100, 200);
		start.setSize(500, 300);
		start.setText("Start Game with this button!");
		start.setForeground(Color.magenta);
		start.setFont(new Font("SansSerif", Font.BOLD, 15));
		opening.add(start);

		//begin button that goes to the game
		beginButton = new JButton("Start");
		beginButton.setLocation(75, 200);
		beginButton.setSize(300, 100);	
		beginButton.setBackground(Color.gray);
		beginButton.setFont(new Font("SansSerif", Font.BOLD, 50));
		opening.add(beginButton);
		
		beginButton.addActionListener(new ActionListener() 
		{ 
			public void actionPerformed(ActionEvent e) 
			{ 
				try {
					set = new Setting();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				set.setVisible(true);
				opening.setVisible(false);				
			} 
		} );
		
		//instructions label
		rulesLabel = new JLabel();
		rulesLabel.setLocation(500, 200);
		rulesLabel.setSize(500, 300);
		rulesLabel.setText("Click this button if you don't know how to play!");
		rulesLabel.setForeground(Color.red);
		rulesLabel.setFont(new Font("SansSerif", Font.BOLD, 15));
		opening.add(rulesLabel);

		//instruction button that goes to the game instructions
		instructBut = new JButton("Instructions");
		instructBut.setLocation(500, 200);
		instructBut.setSize(300, 100);
		instructBut.setBackground(Color.gray);
		instructBut.setFont(new Font("SansSerif", Font.BOLD, 45));
		instructBut.addActionListener(new ActionListener() 
		{ 
			public void actionPerformed(ActionEvent e) 
			{ 
				Instructions inst = new Instructions();
				inst.setVisible(true);
				opening.setVisible(false);
			} 
		} );
		opening.add(instructBut);
		
		
	}
	
	//boolean that can be called to make the opening, the instrucitons class, and the setting class visible or close it
	void setVisible(boolean b) 
	{
		b = true;
	}
	
	public Body getBody() {
		if (set != null)
			return set.getBody();
		return null;
	}
	
	public void updateSet(Setting setting)
	{
		set=setting; 
	}
}



