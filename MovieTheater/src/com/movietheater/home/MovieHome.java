package com.movietheater.home;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.movietheater.admin.info.Movie;
import com.movietheater.info.MoviePoster;
import com.movietheater.main.MovieFrame;
import com.movietheater.main.MovieTheaterMain;
import com.movietheater.member.Member;

public class MovieHome extends MovieFrame {
	JPanel p_can, p_login;
	JLabel la_title, la_member,la_ment;
	JButton bt_logout;
	Member member;

	public MovieHome(MovieTheaterMain movieTheaterMain) {
		super(movieTheaterMain);

		p_can = new JPanel();
		p_login = new JPanel();

		la_title = new JLabel("MOVIE");
		la_member = new JLabel();
		la_ment=new JLabel("님 반갑습니다.");
		bt_logout = new JButton("로그아웃");
		
		this.setBackground(new Color(0x69bfcd));
		p_can.setPreferredSize(new Dimension(movieTheaterMain.WIDTH - 230, movieTheaterMain.HEIGHT - 240));
		p_can.setBorder(new TitledBorder(new LineBorder(new Color(0xb2dab8), 3,true)));
		p_login.setPreferredSize(new Dimension(movieTheaterMain.WIDTH - 600, movieTheaterMain.HEIGHT - 100));
		p_login.setBorder(new TitledBorder(new LineBorder(new Color(0xec6d71), 3, true)));
		la_member.setFont(new Font("굴림",Font.BOLD,25));
		la_ment.setFont(new Font("굴림",Font.BOLD,15));
		p_can.setBackground(new Color(0x69bfcd));
		p_login.setBackground(new Color(0x69bfcd));
		bt_logout.setBackground(new Color(0xec6d71));
		la_title.setFont(new Font("Verdana", Font.BOLD, 45));
		p_login.add(la_title);
		p_login.add(la_member);
		p_login.add(la_ment);
		p_login.add(bt_logout);

		add(p_can);
		add(p_login);

		p_can.updateUI();

		bt_logout.addActionListener((e) -> {
			getMovieTheaterMain().showPage(MovieTheaterMain.MOVIE_LOGIN);
			getMovieTheaterMain().setHasSession(false);
		});

	}
	public void receive(Member member) {
		this.member=member;
		
		la_member.setText(member.getName());
	}

}
