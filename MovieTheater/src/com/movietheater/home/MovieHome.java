package com.movietheater.home;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.movietheater.main.MovieFrame;
import com.movietheater.main.MovieTheaterMain;

public class MovieHome extends MovieFrame{
	JPanel p_can,p_login;
	JLabel la_title,la_id,la_pass;
	JTextField t_id,t_pass;
	JButton bt_regist,bt_login;
	
	public MovieHome(MovieTheaterMain movieTheaterMain) {
		super(movieTheaterMain);
		p_can=new JPanel();
		p_login=new JPanel();
		la_title=new JLabel("MOVIE");
		la_id=new JLabel("아이디");
		la_pass=new JLabel("비밀번호");
		bt_regist=new JButton("회원가입");
		bt_login=new JButton("로그인");
		t_id=new JTextField();
		t_pass=new JTextField();
		
		p_can.setPreferredSize(new Dimension(movieTheaterMain.WIDTH-300, movieTheaterMain.HEIGHT-100));
		p_login.setPreferredSize(new Dimension(movieTheaterMain.WIDTH-950, movieTheaterMain.HEIGHT-100));
		p_can.setBackground(Color.CYAN);
		p_login.setBackground(Color.GREEN);
		la_title.setFont(new Font("Verdana",Font.BOLD,60));
		t_id.setPreferredSize(new Dimension(150, 20));
		t_pass.setPreferredSize(new Dimension(150,20));
		
		add(p_can);
		p_login.add(la_title);
		p_login.add(la_id);
		p_login.add(t_id);
		p_login.add(la_pass);
		p_login.add(t_pass);
		p_login.add(bt_regist);
		p_login.add(bt_login);
		add(p_login);
		
		bt_regist.addActionListener((e)->{
			getMovieTheaterMain().showPage(MovieTheaterMain.MOVIE_HOME_REGIST);
		});
		
	}

}
