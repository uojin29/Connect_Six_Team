package Photoshop;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class Reset extends JButton{
	Reset(String s){
		super(s);
		createButton();
	}
	public void createButton() {
		this.setBounds(925, 50, 150, 80);
	}
} 
