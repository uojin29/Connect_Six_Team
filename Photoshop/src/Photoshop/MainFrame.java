package Photoshop;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.*; 

public class MainFrame extends JFrame{
	static BufferedImage image;
	static BufferedImage image2;
	JPanel origin;
	JPanel changed;
	static String imgPath = null;
	JPanel mainPanel = new JPanel();
	JButton grayButton;
	JButton b2;
	JButton b3;
	JButton b4;
	JButton reset;
	
	MainFrame(){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1200,800);
		this.setBackground(Color.WHITE);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		MainFrame mainFrame = new MainFrame();
		mainFrame.createMainFrame();
	}
	
	private void createMainFrame() {
		MenuBar menubar = new MenuBar();
		menubar.getLoad().addActionListener(new MyActionListener());
		
		this.setJMenuBar(menubar);
		origin = new OriginImage();
		changed = new ChangedImage();
		
		grayButton = new GrayScaleButton("Gray Scale");
		b2 = new Edge("Edge");
		b3 = new Button_3("Button 3");
		b4 = new Button_4("Button 4");
		reset = new Reset("Reset");
		
		grayButton.addActionListener(new MyActionListener());
		b2.addActionListener(new MyActionListener());
		b3.addActionListener(new MyActionListener());
		b4.addActionListener(new MyActionListener());
		reset.addActionListener(new MyActionListener());		
		
		mainPanel.setLayout(null);
		mainPanel.add(origin);
		mainPanel.add(changed);
		mainPanel.add(grayButton);
		mainPanel.add(b2);
		mainPanel.add(b3);
		mainPanel.add(b4);
		mainPanel.add(reset);
		
		this.add(mainPanel);
		this.setVisible(true);
	}
	class MyActionListener implements ActionListener{
		static public JFileChooser filechooser = new JFileChooser();
		@Override
		public void actionPerformed(ActionEvent e) {
			
			String s = e.getActionCommand();
			if(s.equals("Gray Scale")) {
				System.out.println("Gray Scale");
				for(int y = 0; y < MainFrame.image2.getHeight(); y++) {
					   for(int x = 0; x < MainFrame.image2.getWidth(); x++) {
					       Color colour = new Color(MainFrame.image2.getRGB(x, y));
					       int Y = (int) (0.2126 * colour.getRed() + 0.7152 * colour.getGreen() + 0.0722 * colour.getBlue());
					       MainFrame.image2.setRGB(x, y, new Color(Y, Y, Y).getRGB());
					   }
				}
				MainFrame.this.changed.repaint();
			}
			else if(s.equals("Edge")) {
				System.out.println("Edge");
			}
			else if(s.equals("Button 3")) {
				System.out.println("Button 3");
			}
			else if(s.equals("Button 4")) {
				System.out.println("Button 4");
			}
			else if(s.equals("Reset")) {
				try {
					MainFrame.image2 = ImageIO.read(filechooser.getSelectedFile());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				MainFrame.this.origin.repaint();
				MainFrame.this.changed.repaint();
				System.out.println("reset");
			}
			
			else if(s.equals("Load")) {
				System.out.println("load pressed");
				if(filechooser.showOpenDialog(MainFrame.this) == JFileChooser.APPROVE_OPTION){
	            	System.out.println("filePath"+filechooser.getSelectedFile().toString());
	            	MainFrame.imgPath = filechooser.getSelectedFile().toString();
	           	    try {
	           	    	MainFrame.image = ImageIO.read(filechooser.getSelectedFile());
	           	    	MainFrame.image2 = ImageIO.read(filechooser.getSelectedFile());
	           	    } catch (IOException ex) {
	           	        ex.printStackTrace();
	           	    }
	            	MainFrame.this.origin.repaint();
	            	MainFrame.this.changed.repaint();
	            }
			}
			else if(s.equals("Save")) {
				//ImageIO.write(MainFrame.resizeImage, "jpg", new File("C:/save/새 사진파일명.jpg"));
				System.out.println("Save");
			}
		}
	}
}
