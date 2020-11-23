package com.movietheater.admin.main;

import java.awt.Dimension;

import javax.swing.JPanel;

public class AdminMovieFrame extends JPanel {
	AdminMovieTheaterMain movieTheaterMain;

	public AdminMovieFrame(AdminMovieTheaterMain movieTheaterMain) {
		this.movieTheaterMain = movieTheaterMain;
		this.setPreferredSize(new Dimension(AdminMovieTheaterMain.WIDTH, AdminMovieTheaterMain.HEIGHT - 50));
	}

}
