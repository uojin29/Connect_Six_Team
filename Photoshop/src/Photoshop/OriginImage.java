package Photoshop;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.*;

public class OriginImage extends JPanel{	
	OriginImage(){
		this.setBounds(75, 150, 500, 500);
	}
	public void paintComponent(Graphics g) { 
		Graphics2D g2=(Graphics2D)g;
		int imageProcessSize = 500;
		if(MainFrame.image!= null) {
			double ratio = 0.0;
	        int w = 0;
	        int h = 0;
	        System.out.println(MainFrame.image.getWidth(null));
	        System.out.println(MainFrame.image.getHeight(null));
			
	        if(MainFrame.image.getWidth(null) > MainFrame.image.getHeight(null)) {
	        	System.out.println("1");
	        	ratio = ((double)imageProcessSize)/((double)MainFrame.image.getWidth(null));
	        	w = (int)(MainFrame.image.getWidth(null) * ratio);
	        	h = (int)(MainFrame.image.getHeight(null) * ratio);
	        }else {
	        	System.out.println("2");
	        	ratio = ((double)imageProcessSize)/((double)MainFrame.image.getHeight(null));
	        	w = (int)(MainFrame.image.getWidth(null) * ratio);
	        	h = (int)(MainFrame.image.getHeight(null) * ratio);
	        }
	        Image resizeImage = MainFrame.image.getScaledInstance(w, h, Image.SCALE_SMOOTH);      
	        BufferedImage newImage = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
	        if(MainFrame.image.getWidth(null) >  MainFrame.image.getHeight(null)) {
	        	g2.drawImage(resizeImage,0,imageProcessSize/2 - h/2,this);            
	        }else {
	        	g2.drawImage(resizeImage,imageProcessSize/2 - w/2,0,this);   
	        }
		}
	}
}
