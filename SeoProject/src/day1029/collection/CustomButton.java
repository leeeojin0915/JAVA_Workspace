package day1029.collection;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import java.awt.Color;

public class CustomButton extends JButton implements ActionListener{
	public CustomButton() {
		this.addActionListener(this); //나(버튼)와 리스너(나)와 연결
	}
	public void actionPerformed(ActionEvent e) {
		this.setBackground(Color.GREEN);
		
	}
}
