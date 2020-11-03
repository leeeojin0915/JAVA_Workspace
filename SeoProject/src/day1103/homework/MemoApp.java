package day1103.homework;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class MemoApp extends JFrame{
	JTextField t_input;
	//JTextArea area;
	InputStream is;
	InputStreamReader reader;
	BufferedReader buffer_read;
	BufferedWriter buffer_write;
	Class getClass;
	
	int data;
	String str=null;
	public MemoApp() {
		t_input=new JTextField(15);
		
		//setLayout(new FlowLayout());
		add(t_input);
		
		//t_input.setPreferredSize(new Dimension(300,70));
		t_input.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				is=System.in;
				reader=new InputStreamReader(is);//바이트
				buffer_read=new BufferedReader(reader);//문자열		
				
				try {
					while(true) {
						str=buffer_read.readLine();						
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		getClass=this.getClass();
		URL url=getClass.getClassLoader().getResource("res/memo.txt");
		try {
			buffer_write=new BufferedWriter(buffer_write);
		} catch (Exception e1) {
		}
		
		
		setSize(300,70);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new MemoApp();

	}

}
