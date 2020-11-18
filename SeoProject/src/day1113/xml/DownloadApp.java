package day1113.xml;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

import day1103.thread.BarThread;

public class DownloadApp extends JFrame {
	JTextField t_url, t_name;
	JButton bt;
	JProgressBar bar;
	BarThread thread;

	URLConnection con;
	HttpURLConnection http;
	URL url;
	FileOutputStream fos;
	int time = 10;

	public DownloadApp() {
		t_url = new JTextField(50);
		t_name = new JTextField(20);
		bt = new JButton("다운로드");
		bar = new JProgressBar();
		thread = new BarThread(bar, time);

		t_url.setPreferredSize(new Dimension(30, 50));
		t_name.setPreferredSize(new Dimension(30, 50));
		bt.setPreferredSize(new Dimension(150, 50));
		bar.setPreferredSize(new Dimension(600, 100));

		setLayout(new FlowLayout());
		add(t_url);
		add(t_name);
		add(bt);
		add(bar);

		bt.addActionListener((e) -> {
			load();
			thread.start();
		});

		setSize(700, 280);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void load() {
		try {
			url = new URL(t_url.getText());

			con = url.openConnection();
			http = (HttpURLConnection) con;
			http.setRequestMethod("GET");

			InputStream is = http.getInputStream();
			File file = new File("D:/koreaIT/Workspace/java_workspace/SeoProject/res/" + t_name.getText());
			fos = new FileOutputStream(file);

			int data = -1;
			while (true) {
				data = is.read();
				if (data == -1)
					break;
				fos.write(data);
			}
			System.out.println("저장완료");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public static void main(String[] args) {
		new DownloadApp();
	}

}
