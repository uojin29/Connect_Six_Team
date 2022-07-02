package Photoshop;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class GrayScaleButton extends JButton{
	GrayScaleButton(String s){
		super(s);
		createButton();
	}
	public void createButton() {
		this.setBounds(125, 50, 150, 80);
	}
}
 