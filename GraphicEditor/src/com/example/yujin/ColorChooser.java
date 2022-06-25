package com.example.yujin;

import java.awt.Color;

import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.colorchooser.ColorSelectionModel;

public class ColorChooser extends JFrame implements ChangeListener{
   JColorChooser colorChooser = new JColorChooser();
   
   //ColorSelectionModel model = colorChooser.getSelectionModel();

   static boolean colorChange;
   static Color color;
   
   @Override
   public void stateChanged(ChangeEvent e) {
      // TODO Auto-generated method stub
      color = colorChooser.getColor();
      colorChange = true;
      //System.out.print("\""+Integer.toHexString(color.getRGB())+"\", ");
      MainFrame.button.setBorderPainted(false);
      MainFrame.button.setOpaque(true);
      MainFrame.button.setBackground(color);
   }
   
   public ColorChooser(){
      setTitle("색상 고르기");
      setLocation(400, 200);
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      
      colorChooser.getSelectionModel().addChangeListener(this);
      
      add(colorChooser);
      pack();
      setVisible(true);
   }

}