import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.*;

public class Letters 
{
	  private JFrame frame;
      
      private static JButton[] buttonsArray = new JButton[26];
       
      private static String sendButton; 
      
      private static boolean buttonUsed; 
     
      public Letters(JFrame game) throws IOException
      {
             // set up frame
    	     buttonUsed=false; 
             frame = game; 
             
             //make buttons
             for(int i = 0; i<26; i++) 
             { 
                    String buttonLetter = String.valueOf(Character.toChars(65+i));
                    JButton button = new JButton(buttonLetter);
                    buttonsArray[i] = button;
                    button.setName(buttonLetter);
                    button.addActionListener(new ActionListener() 
                    {
                  public void actionPerformed(ActionEvent e) 
                  { 
                                 button.setVisible(false); 
                                 sendButton=button.getName(); 
                                 
                                 try {
                        
                                	HangmanMain.gamePlay2(); 
                                	frame.revalidate(); 
                                	frame.repaint(); 
                                	 
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								} 
                               
                  }
                    }
                    );
                    if(i<13) 
                    {
                          button.setLocation(15, (10 + (55*i)));
                          frame.add(button); 
                    }
                    else 
                    {
                          int invertI = i - 13;
                          button.setLocation(75, (10 + (55*invertI)));
                          frame.add(button);
                    }
                    button.setSize(50,50); 
             }
      }  
      
      public static String getLetter()
      {
    	  return sendButton; 
      }
      
      public static void playAgain()
      {
    	  for(int i = 0; i<26; i++)
    	  {
    		  buttonsArray[i].setVisible(true); 
    		  buttonUsed=false; 
    	  }
      }
      
      
}
