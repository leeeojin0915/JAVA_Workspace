package com.movietheater.info;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.movietheater.main.MovieFrame;
import com.movietheater.main.MovieTheaterMain;

public class MovieInfoDetail extends MovieFrame{
	
	JPanel p_content,p_can,p_movieInfo,p_table;
	JTextField t_review;
	JTable table;
	JScrollPane scroll;
	JButton bt_reser,bt_review;
	MovieReview movieReview;
	
	public MovieInfoDetail(MovieTheaterMain movieTheaterMain) {
		super(movieTheaterMain);
		p_content=new JPanel();
		p_can=new JPanel();
		p_movieInfo=new JPanel();
		p_table=new JPanel();
		t_review=new JTextField();
		table=new JTable(movieReview=new MovieReview());
		scroll=new JScrollPane(table);
		bt_reser=new JButton("예매");
		bt_review=new JButton("등록");
		
		//스타일
		p_can.setPreferredSize(new Dimension(400,600));
		p_can.setBackground(Color.PINK);
		p_content.setPreferredSize(new Dimension(780,600));
		p_movieInfo.setPreferredSize(new Dimension(800,300));
		p_movieInfo.setBackground(Color.RED);
		p_table.setPreferredSize(new Dimension(800,150));
		scroll.setPreferredSize(new Dimension(700,100));
		t_review.setPreferredSize(new Dimension(600,30));
	

		add(p_can);
		p_content.add(p_movieInfo);
		p_table.add(scroll);
		p_content.add(p_table);
		p_content.add(t_review);
		p_content.add(bt_review);
		p_content.add(bt_reser);
		add(p_content);
		
		
	}

}
