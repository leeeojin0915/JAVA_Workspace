package day1027.gui;

import java.awt.Button;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Test extends JFrame{
	JButton bt;
	//생성자도 손으로 일일이 입력하지말고, 빈공간에  ctrl + space 
	public Test() {
		bt = new JButton("나버튼");
		add(bt);
		setVisible(true);
		setSize(300, 400);
	}
	//main 입력 후 ctrl + space 
	public static void main(String[] args) {
		new Test();
	}
} 
