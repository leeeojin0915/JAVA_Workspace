package com.movietheater.info;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class MoviePoster extends JPanel {
	JPanel p_can;
	MovieHandler handler;
	Image img;


	public MoviePoster() {
		//String data = handler.movieList.
		String data="http://img.cgv.co.kr/Movie/Thumbnail/Poster/000079/79960/79960_1000.jpg";
		try {
			URL url = new URL(data);
			img = ImageIO.read(url);
			img = img.getScaledInstance(300, 400, Image.SCALE_SMOOTH);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		p_can = new JPanel() {
			public void paint(Graphics g) {
				g.drawImage(img, 0, 0, p_can);
			}
		};

		p_can.setPreferredSize(new Dimension(300, 600));
		// p_can.setBackground(Color.BLUE);
		this.add(p_can);

	}
	public void poster(String data) {
		for(int i=0;i<handler.movieList.size();i++) {
			 Movie movie=handler.movieList.get(i);
			 data=movie.getUrl();
		}
	}
}
