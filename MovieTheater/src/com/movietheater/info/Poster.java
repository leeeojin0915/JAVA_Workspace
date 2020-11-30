package com.movietheater.info;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;

import com.movietheater.admin.info.Movie;
import com.movietheater.home.MovieHome;

public class Poster extends Canvas {
	Image img;
	Movie movie;
	MovieHome movieHome;
	Thread thread;
	int x=0;
	public Poster(Movie movie,MovieHome moviehome,int width,int height) {
		this.movie=movie;
		this.movieHome=moviehome;
		try {
			URL url = new URL(movie.getUrl());
			img = ImageIO.read(url);
			img = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
//		setFocusable(true);
//		thread = new Thread() {
//			public void run() {
//				while (true) {
//					x--;
//					repaint();
//					try {
//						thread.sleep(20);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//			}
//		};
//		thread.start();
	}
	public void paint(Graphics g) {
		g.drawImage(img, x, 0, this);
	}

}
