import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Body


{
	 private JFrame frame; 
	 private JLabel bodyPart; 
	 private ImageIcon image; 
	 private int b;
	 
	 
	 public Body(JFrame frame)
	 { 
		 this.frame=frame; 
		 
		 b=7;
		 image = new ImageIcon(new ImageIcon("hanging thing.jpg").getImage());
		 bodyPart=new JLabel(image);
		 frame.add(bodyPart); 
		 bodyPart.setLocation(100,70);
		 bodyPart.setSize(500,500); 
		 
		 setBody();
	 }
	 
	 //changes the body variable to set new image
	 public void setBody()
	 { 
		 b--;
		 
		 if(b==6)
		 { 
			 image = new ImageIcon(new ImageIcon("hanging thing.jpg").getImage());
			 bodyPart.setIcon(image);
			 frame.revalidate();
			 frame.repaint();  
		 }
		 
		 else if(b==5)
		 {
			 image = new ImageIcon(new ImageIcon("head.jpg").getImage());
			 bodyPart.setIcon(image);
			 frame.revalidate();
			 frame.repaint(); 
		 }
		 
		 else if(b==4)
		 {
			 image = new ImageIcon(new ImageIcon("body.jpg").getImage());
			 bodyPart.setIcon(image);
			 frame.revalidate();
			 frame.repaint();
		 }
		 
		 else if(b==3)
		 {	
			 image = new ImageIcon(new ImageIcon("right arm.jpg").getImage());
			 bodyPart.setIcon(image);
			 frame.revalidate();
			 frame.repaint();
		 }
		 
		 else if(b==2)
		 {
			 image = new ImageIcon(new ImageIcon("left arm.jpg").getImage());
			 bodyPart.setIcon(image);
			 frame.revalidate();
			 frame.repaint();
		 }
		 
		 else if(b==1)
		 {			
			 image = new ImageIcon(new ImageIcon("right leg.jpg").getImage());
			 bodyPart.setIcon(image);
			 frame.revalidate();
			 frame.repaint();
		 }
		 
		 else if(b==0)
		 {
			 image = new ImageIcon(new ImageIcon("left leg.jpg").getImage());
			 bodyPart.setIcon(image);
			 frame.revalidate();
			 frame.repaint();
		 } 

	 }
	 
	 public int getBody() 
	 {
		 return b;
	 }
	 
	 public void reset()
	 {
		 b = 7;
	 }
	 
}


