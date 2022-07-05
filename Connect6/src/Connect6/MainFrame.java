package Connect6;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class MainFrame extends JFrame {
	String input = null;
	static int noStart; 
	JPanel mainPanel = new JPanel();
	JButton startButton = new JButton("Start");
	JButton resetButton = new JButton("Reset");
//	static JPanel status = new JPanel();
	Connect6_Panel panel;

	MainFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1200, 1000);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		MainFrame mainframe = new MainFrame();
		mainframe.createFrame();
	}

	public void createFrame() {
		mainPanel.setLayout(null);
	//	status.setBounds(1075, 650, 100, 100);
		startButton.setBounds(1075, 875, 100, 50);
		startButton.addActionListener(new MyListener());
		resetButton.setBounds(1075, 825, 100, 50);
		resetButton.addActionListener(new MyListener());
	//	mainPanel.add(status);
		mainPanel.add(startButton);
	//	mainPanel.add(resetButton);
		
		panel = new Connect6_Panel();

		mainPanel.add(panel);
		this.add(mainPanel);
		this.setVisible(true);
	}

	class MyListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String s = e.getActionCommand();
			if(s.equals("Start")) {
				input = JOptionPane.showInputDialog(null, "착수금지점의 개수: ", "");
				MainFrame.noStart = Integer.parseInt(input);
				panel.createPanel();
			}
//			else if(s.equals("Reset")) {
//				System.out.println("Reset");
//				panel.removeAll();
//				Connect6_Panel.list.clear();
//				input = JOptionPane.showInputDialog(null, "착수금지점의 개수: ", "");
//				MainFrame.noStart = Integer.parseInt(input);
//				panel.createPanel();
//			}
		}

	}
}
