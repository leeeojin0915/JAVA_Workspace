package com.movietheater.info;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.movietheater.admin.info.Movie;
import com.movietheater.home.MovieHome;
import com.movietheater.reservation.MovieReservation;

public class MoviePoster extends JPanel {
	public static final int WIDHT=200;
	public static final int HEIGHT=200;
	

	JPanel p_can;
	JLabel la_title;
	Image img;
	Movie moive;
	GenreVO genreVO;
	RatingVO ratingVO;
	MovieHome home;
	MovieInfo movieinfo;
	MovieReservation movieReservation;
	//Thread thread;
	int width,height;
	
	
	public MoviePoster(Movie movie, MovieInfo movieinfo) {
		this.moive = movie;
		this.movieinfo = movieinfo;
	

		image(movie,WIDHT,HEIGHT);
		p_can = new JPanel() {
			public void paint(Graphics g) {
				g.drawImage(img, 0, 0, p_can);
				
			}
		};

		la_title = new JLabel(movie.getTitle());

		this.setPreferredSize(new Dimension(WIDHT, HEIGHT + 35));
		this.setBorder(new TitledBorder(new LineBorder(new Color(0x96d3de),3,true)));
		this.setBackground(new Color(0x69bfcd));
		p_can.setPreferredSize(new Dimension(WIDHT, HEIGHT));
		//p_can.setBackground(Color.PINK);
		la_title.setPreferredSize(new Dimension(WIDHT, 20));

		this.add(p_can);
		this.add(la_title);
		p_can.updateUI();
	}
	
	public MoviePoster(GenreVO genreVO,RatingVO ratingVO) {
		this.genreVO=genreVO;
		this.ratingVO=ratingVO;
	}
	public MoviePoster(Movie movie,MovieReservation movieReservation) {
		this.moive=movie;
		this.movieReservation=movieReservation;
		image(movie,120,65);
		p_can = new JPanel() {
			public void paint(Graphics g) {
				g.drawImage(img, 0, 0, p_can);
			}
		};
		this.setPreferredSize(new Dimension(WIDHT-85, HEIGHT-132));
		p_can.setPreferredSize(new Dimension(WIDHT-80, HEIGHT-130));
		p_can.setBackground(Color.PINK);

		this.add(p_can);
		p_can.updateUI();
 
		
	}
	public void image(Movie movie,int width,int height) {
		this.width=width;
		this.height=height;
		try {
			URL url = new URL(movie.getUrl());
			img = ImageIO.read(url);
			img = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
