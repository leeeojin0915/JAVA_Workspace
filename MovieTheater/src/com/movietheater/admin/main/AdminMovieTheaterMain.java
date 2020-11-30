package com.movietheater.admin.main;

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

import com.movietheater.admin.home.AdminMovieHome;
import com.movietheater.admin.info.AdminMovieInfo;
import com.movietheater.admin.info.AdminMovieInfoModi;
import com.movietheater.admin.info.AdminMovieInfoRegist;
import com.movietheater.admin.member.AdminMyMoviePage;
import com.movietheater.db.MovieDBManager;

public class AdminMovieTheaterMain extends JFrame {
	public static final int WIDTH = 1200;
	public static final int HEIGHT = 700;
	public static final int AD_MOVIE_HOME = 0;
	public static final int AD_MOVIE_INFO = 1;
	public static final int AD_MOVIE_MEMBER = 2;

	public static final int AD_MOVIE_INFO_REGIST = 3;
	public static final int AD_MOVIE_INFO_MODI = 4;

	private MovieDBManager movieDBManager;
	private Connection con;

	JPanel bigContainer;// 사용자,관리자 영역
	JPanel container;// 페이지 붙일영역
	JPanel p_menu;// 버튼메뉴
	String[] bt = { "홈관리", "영화정보관리", "회원관리" };
	JButton[] button = new JButton[bt.length];

	private ArrayList<AdminMovieFrame> moviePage = new ArrayList<AdminMovieFrame>();
	// MovieFrame[] moviePage = new MovieFrame[3];

	public AdminMovieTheaterMain() {
		movieDBManager = new MovieDBManager();
		bigContainer = new JPanel();
		container = new JPanel();
		p_menu = new JPanel();

		con = movieDBManager.connection();
		if (con == null) {
			JOptionPane.showMessageDialog(this, "연결실패");
			System.exit(0);
		} else {
			this.setTitle("관리자모드");
		}

		bigContainer.setPreferredSize(new Dimension(WIDTH, HEIGHT - 50));
		bigContainer.setBackground(Color.WHITE);
		// p_menu.setPreferredSize(new Dimension(WIDTH, 50));

		for (int i = 0; i < bt.length; i++) {
			button[i] = new JButton(bt[i]);
			p_menu.add(button[i]);
		}

		moviePage.add(new AdminMovieHome(this));
		moviePage.add(new AdminMovieInfo(this));
		moviePage.add(new AdminMyMoviePage(this));
		moviePage.add(new AdminMovieInfoRegist(this));
		moviePage.add(new AdminMovieInfoModi(this));

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
					showPage(AD_MOVIE_HOME);
				} else if (obj == button[1]) {
					showPage(AD_MOVIE_INFO);

				} else if (obj == button[2]) {
					showPage(AD_MOVIE_MEMBER);
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

	public MovieDBManager getMovieDBManager() {
		return movieDBManager;
	}

	public Connection getCon() {
		return con;
	}
	

	public ArrayList<AdminMovieFrame> getMoviePage() {
		return moviePage;
	}

	public static void main(String[] args) {
		new AdminMovieTheaterMain();
	}

}
