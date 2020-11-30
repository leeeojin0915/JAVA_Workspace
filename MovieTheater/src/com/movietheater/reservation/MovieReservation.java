package com.movietheater.reservation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.OptionPaneUI;

import com.movietheater.admin.info.Movie;
import com.movietheater.info.MoviePoster;
import com.movietheater.main.MovieFrame;
import com.movietheater.main.MovieTheaterMain;

public class MovieReservation extends MovieFrame {
	JPanel date, theater, movie, time;
	JLabel[] la_time, la_theater, la_day;
	JLabel la_m;
	JButton bt_next;
	Image img;
	String[] theater_name = { "1관", "2관", "3관", "4관", "5관" };
	JButton[] bt_theater, bt_day, bt_time;

	ArrayList<MoviePoster> urlList;
	ArrayList<ReservationVo> reserList;
	Movie movieVo;
	ReservationVo reservationVo;
	MovieSeat movieSeat;


	public MovieReservation(MovieTheaterMain movieTheaterMain) {
		super(movieTheaterMain);
		date = new JPanel();
		theater = new JPanel();
		movie = new JPanel();
		time = new JPanel();
		bt_next = new JButton("다음");
		la_m = new JLabel("12월");

		theater.setLayout(new GridLayout(theater_name.length + 5, 1, 0, 5));
		this.setBackground(new Color(0x69bfcd));
		movie.setPreferredSize(new Dimension(movieTheaterMain.WIDTH - 610, movieTheaterMain.HEIGHT - 130));
		theater.setPreferredSize(new Dimension(movieTheaterMain.WIDTH - 610, movieTheaterMain.HEIGHT - 130));
		date.setPreferredSize(new Dimension(movieTheaterMain.WIDTH - 610, movieTheaterMain.HEIGHT - 130));
		time.setPreferredSize(new Dimension(movieTheaterMain.WIDTH - 610, movieTheaterMain.HEIGHT - 130));

		movie.setBackground(new Color(0x69bfcd));
		theater.setBackground(new Color(0x69bfcd));
		date.setBackground(new Color(0x69bfcd));
		time.setBackground(new Color(0x69bfcd));

		movie.setBorder(new TitledBorder(new LineBorder(new Color(0xb2dab8), 3, true), "영화"));
		theater.setBorder(new TitledBorder(new LineBorder(new Color(0xec6d71), 3, true), "상영관"));
		date.setBorder(new TitledBorder(new LineBorder(new Color(0x96d3de), 3, true), "상영날짜"));
		time.setBorder(new TitledBorder(new LineBorder(new Color(0xb2dab8), 3, true), "상영시간"));
		bt_next.setBackground(new Color(0xec6d71));
		la_m.setFont(new Font("돋움", Font.BOLD, 20));

		getMovie();
		movie.updateUI();

		this.add(movie);

		bt_theater = new JButton[theater_name.length];
		for (int i = 0; i < theater_name.length; i++) {
			bt_theater[i] = new JButton(theater_name[i]);
			bt_theater[i].setFont(new Font("고딕", Font.BOLD, 20));
			bt_theater[i].setBackground(new Color(0xb2dab8));
			bt_theater[i].setBorder(new TitledBorder(new LineBorder(new Color(0xec6d71), 2, true)));
			theater.add(bt_theater[i]);
		}
		this.add(theater);

		date.add(la_m);
		bt_day = new JButton[10];
		for (int i = 1; i < bt_day.length; i++) {
			bt_day[i] = new JButton(String.valueOf(i) + "일");
			bt_day[i].setPreferredSize(new Dimension(150, 30));
			bt_day[i].setFont(new Font("고딕", Font.BOLD, 20));
			bt_day[i].setBackground(new Color(0xb2dab8));
			bt_day[i].setBorder(new TitledBorder(new LineBorder(new Color(0xec6d71), 2, true)));
			date.add(bt_day[i]);
		}
		this.add(date);

		bt_time = new JButton[24];
		for (int i = 8; i < bt_time.length; i++) {
			if (i % 2 == 0) {
				bt_time[i] = new JButton(String.valueOf(i) + ":00");
				bt_time[i].setPreferredSize(new Dimension(80, 30));
				bt_time[i].setFont(new Font("Verdana", Font.BOLD, 20));
				bt_time[i].setBackground(new Color(0xb2dab8));
				bt_time[i].setBorder(new TitledBorder(new LineBorder(new Color(0xec6d71), 2, true)));
				time.add(bt_time[i]);
			}
		}
		this.add(time);
		this.add(bt_next);

		selectMovie(reservationVo);

		bt_next.addActionListener((e) -> {
			MovieSeat movieSeat=(MovieSeat) getMovieTheaterMain().getMoviePage().get(MovieTheaterMain.MOVIE_SEAT);
			getMovieTheaterMain().showPage(MovieTheaterMain.MOVIE_SEAT);
			movieSeat.choiceMovie(this.reservationVo,this.movieVo);
		});
	}

	public ReservationVo selectMovie(ReservationVo vo) {
		reservationVo = new ReservationVo();

		for (MoviePoster moviePoster : urlList) {
			moviePoster.addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent e) {
					//String str = movieVo.getTitle();
					//movieVo.setTitle(urlList.get());
					//System.out.println(moviePoster.getName());
				}
			});
		}
		

		for (int i = 0; i < theater_name.length; i++) {
			int k = i;
			bt_theater[k].addActionListener((e) -> {
				if(bt_theater[k]==e.getSource()){
					bt_theater[k].setBackground(new Color(0x94715c));
					reservationVo.setTitle(bt_theater[k].getText());
					System.out.println(bt_theater[k].getText());
				}
			});
		}

		for(int i=1;i<bt_day.length;i++) {
			int k=i;
			bt_day[k].addActionListener((e)->{
				if(bt_day[k]==e.getSource()) {
					bt_day[k].setBackground(new Color(0x94715c));
					reservationVo.setDay(bt_day[k].getText());
					System.out.println(bt_day[k].getText());
				}
			});
		}

		for(int i=8;i<bt_time.length;i++) {
			int k=i;
			if(k%2==0) {
				bt_time[k].addActionListener((e)->{
					if(k%2==0) {
						if(bt_time[k]==e.getSource()) {
							bt_time[k].setBackground(new Color(0x94715c));
							reservationVo.setTime(bt_time[k].getText());
							System.out.println(bt_time[k].getText());
						}
					}
				});
			}
		}

		return reservationVo;
	}

	public void check(ReservationVo reservationVo) {
		if (reservationVo.getTitle().length() < 1) {
			JOptionPane.showConfirmDialog(this, "영화를 선택해주세요");
		}
	}

	public void getMovie() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select url,title from movie";

		try {
			pstmt = getMovieTheaterMain().getCon().prepareStatement(sql);
			rs = pstmt.executeQuery();
			urlList = new ArrayList<MoviePoster>();
			while (rs.next()) {
				movieVo = new Movie();
				reservationVo=new ReservationVo();
				movieVo.setUrl(rs.getString("url"));
				movieVo.setTitle(rs.getString("title"));
				urlList.add(getPoster(movieVo));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			getMovieTheaterMain().getMovieDBManager().close(pstmt, rs);
		}

	}

	// seat
	public void reserInfo() {
		movieSeat = (MovieSeat) getMovieTheaterMain().getMoviePage().get(MovieTheaterMain.MOVIE_SEAT);
		reservationVo = new ReservationVo();

		reservationVo.setTitle(movieVo.getTitle());
		for (int i = 0; i < bt_theater.length; i++) {
			reservationVo.setTheater(bt_theater[i].getText());
		}
		for (int i = 1; i < bt_day.length; i++) {
			reservationVo.setDay(bt_day[i].getText());
		}
		for (int i = 8; i < bt_time.length; i++) {
			if (i % 2 == 0) {
				reservationVo.setTime(bt_time[i].getText());
			}
		}
	
	}

	public MoviePoster getPoster(Movie vo) {
		MoviePoster moviePoster = new MoviePoster(vo, this);
		movie.add(moviePoster);
		return moviePoster;
	}

}
