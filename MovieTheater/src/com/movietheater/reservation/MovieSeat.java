package com.movietheater.reservation;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.movietheater.admin.info.Movie;
import com.movietheater.main.MovieFrame;
import com.movietheater.main.MovieTheaterMain;

public class MovieSeat extends MovieFrame {
	JPanel west, center, screen;
	JLabel la_name, la_theater, la_day, la_time, la_screen, la_people;
	JButton bt_reser, bt_cancel;
	Choice choice;
	String[] seat_name = { "A", "B", "C", "D", "E", "F", "H", "I", "J", "K" };
	int[] seat_num= {1,2,3,4,5,6,7,8,9,10};
	Movie movie;
	ReservationVo reservationVo;

	public MovieSeat(MovieTheaterMain movieTheaterMain) {
		super(movieTheaterMain);
		west = new JPanel();
		center = new JPanel();
		screen = new JPanel();
		la_name = new JLabel("aa");
		la_theater = new JLabel("1관");
		la_day = new JLabel("1일");
		la_time = new JLabel("10시");
		la_people = new JLabel("인원");
		la_screen = new JLabel("스크린");
		bt_reser = new JButton("예매하기");
		bt_cancel = new JButton("취소");
		choice = new Choice();
		choice.add("1");
		choice.add("2");
		choice.add("3");

		west.setPreferredSize(new Dimension(movieTheaterMain.WIDTH - 600, movieTheaterMain.HEIGHT - 100));
		west.setBorder(new TitledBorder(new LineBorder(new Color(0xec6d71), 2, true), "예매정보"));
		west.setBackground(new Color(0x69bfcd));
		center.setPreferredSize(new Dimension(movieTheaterMain.WIDTH - 230, movieTheaterMain.HEIGHT - 100));
		center.setBorder(new TitledBorder(new LineBorder(new Color(0xb2dab8), 2, true), "좌석"));
		center.setBackground(new Color(0x96d3de));
		screen.setLayout(new GridLayout(10, 10, 2, 2));
		screen.setPreferredSize(new Dimension(movieTheaterMain.WIDTH - 250, movieTheaterMain.HEIGHT - 200));
		screen.setBackground(new Color(0xb2dab8));
		bt_reser.setBackground(new Color(0xec6d71));
		bt_cancel.setBackground(new Color(0xec6d71));
		la_name.setFont(new Font("고딕", Font.BOLD, 30));
		la_theater.setFont(new Font("고딕", Font.BOLD, 30));
		la_day.setFont(new Font("고딕", Font.BOLD, 30));
		la_time.setFont(new Font("고딕", Font.BOLD, 30));
		la_people.setFont(new Font("고딕", Font.BOLD, 30));

		west.add(la_name);
		west.add(la_theater);
		west.add(la_day);
		west.add(la_time);
		west.add(la_people);
		west.add(choice);
		this.add(west);
		JButton[][] seat = new JButton[seat_name.length][seat_num.length];
		for (int i = 0; i < seat_name.length; i++) {
			for (int j = 0; j < seat_num.length; j++) {
				seat[i][j] = new JButton(seat_name[i]+seat_num[j]);
				seat[i][j].setBackground(new Color(0x94715c));
				seat[i][j].setFont(new Font("고딕", Font.BOLD, 10));
				screen.add(seat[i][j]);
			}
		}
		center.add(la_screen);
		center.add(screen);
		center.add(bt_reser);
		center.add(bt_cancel);
		this.add(center);

		for (int i = 0; i < seat_name.length; i++) {
			for (int j = 0; j < seat_num.length; j++) {
				int k = i;
				int m=j;
				seat[k][m].addActionListener((e) -> {
					if (seat[k][m] == e.getSource()) {
						seat[k][m].setBackground(new Color(0xec6d71));
						System.out.println(seat[k][m].getText());
					}
				});
			}
		}
	}

	public void choiceMovie(ReservationVo reservationVo, Movie movie) {
		this.reservationVo = reservationVo;
		this.movie = movie;
		la_name.setText(movie.getTitle());
		la_theater.setText(reservationVo.getTheater());
		la_day.setText(reservationVo.getDay());
		la_time.setText(reservationVo.getTime());
	}

}
