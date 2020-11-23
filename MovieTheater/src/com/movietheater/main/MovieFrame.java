package com.movietheater.main;

import java.awt.Dimension;

import javax.swing.JPanel;

public class MovieFrame extends JPanel {
	private MovieTheaterMain movieTheaterMain;

	public MovieTheaterMain getMovieTheaterMain() {
		return movieTheaterMain;
	}

	public MovieFrame(MovieTheaterMain movieTheaterMain) {
		this.movieTheaterMain = movieTheaterMain;
		this.setPreferredSize(new Dimension(MovieTheaterMain.WIDTH, MovieTheaterMain.HEIGHT - 50));
	}

}
