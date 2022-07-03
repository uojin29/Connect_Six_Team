package Photoshop;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Button_3 extends JButton{
	Button_3(String s){
		super(s);
		createButton();
	}
	public void createButton() {
		this.setBounds(525, 50, 150, 80); 
	}
}