package day1102.event;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class WindowApp extends JFrame {

	public WindowApp() {
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.out.println("windowClosing");
				System.exit(0);// 프로세스 종료
			}
		});
		setSize(300, 400);
		setVisible(true);
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new WindowApp();
	}
}
