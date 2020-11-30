package com.movietheater.info;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.movietheater.admin.info.Movie;
import com.movietheater.main.MovieFrame;
import com.movietheater.main.MovieTheaterMain;

public class MovieInfoDetail extends MovieFrame {

	JPanel p_content, p_can, p_movieInfo, p_table;
	JPanel[] j_la_con = new JPanel[5];
	JLabel la_title, la_genre, la_rating, la_date, la_story;
	JTextField t_review;
	JTextArea t_story;
	JTable table;
	JScrollPane scroll,s1;
	JButton bt_reser, bt_review;
	MovieReview movieReview;

	MovieInfo movieInfo;
	Movie movie;
	GenreVO genreVO;
	RatingVO ratingVO;

	ArrayList<MoviePoster> movieList;
	Image img;

	public MovieInfoDetail(MovieTheaterMain movieTheaterMain) {
		super(movieTheaterMain);
		movieInfo = new MovieInfo(movieTheaterMain);
		p_content = new JPanel();
		p_can = new JPanel() {
			public void paint(Graphics g) {
				g.drawImage(img, 0, 10, p_can);
			}
		};
		p_movieInfo = new JPanel();
		//p_table = new JPanel();
		t_review = new JTextField();
		t_story=new JTextArea();
		//table = new JTable(movieReview = new MovieReview());
		//scroll = new JScrollPane(table);
		//bt_reser = new JButton("예매");
		//bt_review = new JButton("등록");
		la_title = new JLabel("제목");
		la_genre = new JLabel();
		la_rating = new JLabel("연령");
		la_date = new JLabel("개봉일");
		la_story=new JLabel("스토리");
		//s1=new JScrollPane(t_story);
		//t_story = new JTextArea("스토리");
		for (int i = 0; i < j_la_con.length; i++) {
			j_la_con[i] = new JPanel();
			j_la_con[i].setLayout(new FlowLayout(FlowLayout.LEFT));
			j_la_con[i].setPreferredSize(new Dimension(movieTheaterMain.WIDTH - 420, movieTheaterMain.HEIGHT - 570));
			if (i == 4) {
				j_la_con[4]
						.setPreferredSize(new Dimension(movieTheaterMain.WIDTH - 420, movieTheaterMain.HEIGHT - 320));
			}
		}

		// 스타일
		p_can.setPreferredSize(new Dimension(movieTheaterMain.WIDTH - 500, movieTheaterMain.HEIGHT - 100));
		p_can.setBackground(Color.PINK);
		p_content.setPreferredSize(new Dimension(movieTheaterMain.WIDTH - 370, movieTheaterMain.HEIGHT - 100));
		p_content.setBorder(new TitledBorder(new LineBorder(new Color(0xec6d71), 3,true)));
		p_movieInfo.setPreferredSize(new Dimension(movieTheaterMain.WIDTH - 100, movieTheaterMain.HEIGHT - 150));
		p_movieInfo.setBorder(new TitledBorder(new LineBorder(new Color(0xec6d71), 3,true)));
		//p_movieInfo.setBackground(Color.RED);
		//p_table.setPreferredSize(new Dimension(movieTheaterMain.WIDTH - 300, movieTheaterMain.HEIGHT - 400));
		//scroll.setPreferredSize(new Dimension(movieTheaterMain.WIDTH - 370, movieTheaterMain.HEIGHT - 500));
		//t_review.setPreferredSize(new Dimension(movieTheaterMain.WIDTH - 530, movieTheaterMain.HEIGHT - 580));

		add(p_can);
		j_la_con[0].add(la_title);
		j_la_con[1].add(la_genre);
		j_la_con[2].add(la_rating);
		j_la_con[3].add(la_date);
		j_la_con[4].add(la_story);
//		j_la_con[4].add(t_story);
		for (int i = 0; i < j_la_con.length; i++) {
			p_movieInfo.add(j_la_con[i]);
		}
		p_content.add(p_movieInfo);
		//p_table.add(scroll);
		//p_content.add(p_table);
		//p_content.add(t_review);
		//p_content.add(bt_review);
		//p_content.add(bt_reser);
		add(p_content);
		p_can.updateUI();
	}

	public void init(Movie movie, GenreVO genreVO, RatingVO ratingVO, Image img) {
		this.movie = movie;
		this.genreVO = genreVO;
		this.ratingVO = ratingVO;
		la_title.setText(movie.getTitle());
		la_genre.setText(Integer.toString(movie.getGenre_id()));
		la_rating.setText(Integer.toString(movie.getRating_id()));
		la_date.setText(movie.getRelease_date());
		la_story.setText(movie.getStory());
		//t_story.setText(movie.getStory());
		this.img = img.getScaledInstance(MoviePoster.WIDHT + 90, MoviePoster.HEIGHT + 280, Image.SCALE_SMOOTH);
		p_can.repaint();
		p_can.updateUI();
	}
	

}
