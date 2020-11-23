package com.movietheater.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.movietheater.db.MovieDBManager;
import com.movietheater.home.MovieHome;
import com.movietheater.info.MovieInfo;
import com.movietheater.info.MovieInfoDetail;
import com.movietheater.member.MovieRegist;
import com.movietheater.reservation.MovieReservation;

public class MovieTheaterMain extends JFrame {
	public static final int WIDTH = 1200;
	public static final int HEIGHT = 600;
	public static final int MOVIE_HOME = 0;
	public static final int MOVIE_INFO = 1;
	public static final int MOVIE_RESER = 2;
	
	public static final int MOVIE_INFO_DETAIL = 3;
	public static final int MOVIE_HOME_REGIST = 4;

	MovieDBManager movieDBManager;
	Connection con;

	JPanel bigContainer;// 사용자,관리자 영역
	JPanel container;// 페이지 붙일영역
	JPanel p_menu;// 버튼메뉴
	String[] bt = { "홈", "영화정보", "예매" };
	JButton[] button = new JButton[bt.length];

	ArrayList<MovieFrame> moviePage = new ArrayList<MovieFrame>();
	// MovieFrame[] moviePage = new MovieFrame[3];

	public MovieTheaterMain() {
		movieDBManager = new MovieDBManager();
		bigContainer = new JPanel();
		container = new JPanel();
		p_menu = new JPanel();

		con = movieDBManager.connection();
		if (con == null) {
			JOptionPane.showMessageDialog(this, "연결실패");
			System.exit(0);
		} else {
			this.setTitle("어서오세요");
		}

		bigContainer.setPreferredSize(new Dimension(WIDTH, HEIGHT - 50));
		bigContainer.setBackground(Color.WHITE);
		// p_menu.setPreferredSize(new Dimension(WIDTH, 50));

		for (int i = 0; i < bt.length; i++) {
			button[i] = new JButton(bt[i]);
			p_menu.add(button[i]);
		}

		moviePage.add(new MovieHome(this));
		moviePage.add(new MovieInfo(this));
		moviePage.add(new MovieReservation(this));
		moviePage.add(new MovieInfoDetail(this));
		moviePage.add(new MovieRegist(this));

		for (int i = 0; i < moviePage.size(); i++) {
			container.add(moviePage.get(i));
		}
//		moviePage[0] = new MovieHome(this);
//		moviePage[1] = new MovieInfo(this);
//		moviePage[2] = new MovieReservation(this);

		bigContainer.setLayout(new BorderLayout());
		bigContainer.add(p_menu, BorderLayout.NORTH);
//		for (int i = 0; i < moviePage.length; i++) {
//			container.add(moviePage[i]);
//		}
		for (int i = 0; i < moviePage.size(); i++) {
			container.add(moviePage.get(i));
		}
		bigContainer.add(container);
		this.add(bigContainer);

		setSize(WIDTH, HEIGHT);
		setVisible(true);
		setLocationRelativeTo(null);

		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				movieDBManager.disConnect(con);
				System.exit(0);
			}
		});

		for (int i = 0; i < button.length; i++) {
			button[i].addActionListener((e) -> {
				Object obj = e.getSource();
				if (obj == button[0]) {
					showPage(MOVIE_HOME);
				} else if (obj == button[1]) {
					showPage(MOVIE_INFO);
				} else if (obj == button[2]) {
					showPage(MOVIE_RESER);
				}

			});
		}
	}

	public void showPage(int index) {
		for (int i = 0; i < moviePage.size(); i++) {
			if (i == index) {
				moviePage.get(i).setVisible(true);
			} else {
				moviePage.get(i).setVisible(false);
			}
		}
	}

	public static void main(String[] args) {
		new MovieTheaterMain();
	}

}
