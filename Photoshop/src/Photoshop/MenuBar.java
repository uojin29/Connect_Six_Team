package Photoshop;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.filechooser.*;

public class MenuBar extends JMenuBar{
	JMenu file = new JMenu("File");//Sketch라는 클래스를 호출하여 "Sketch"라는 이름으로 인스턴스화 함 
	private JMenuItem load = new JMenuItem("Load");
	JMenuItem save = new JMenuItem("Save");
	
	
	public MenuBar(){ 
		createMenus();
	}
	
	public void createMenus() {//3가지 메뉴아이템을 이 메뉴바에 붙임 
		file.add(load);
		file.add(save);
		this.add(file);
	}

	public JMenu getFile() {
		return file;
	}

	public void setFile(JMenu file) {
		this.file = file;
	}

	public JMenuItem getLoad() {
		return load;
	}

	public void setLoad(JMenuItem load) {
		this.load = load;
	}

	public JMenuItem getSave() {
		return save;
	}

	public void setSave(JMenuItem save) {
		this.save = save;
	}
}