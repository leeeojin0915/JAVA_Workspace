package com.movietheater.info;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.movietheater.main.MovieFrame;
import com.movietheater.main.MovieTheaterMain;

public class MovieInfo extends MovieFrame {
	
	MoviePoster poster;

	public MovieInfo(MovieTheaterMain movieTheaterMain) {
		super(movieTheaterMain);
		poster = new MoviePoster();

		add(poster);
		
		poster.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				getMovieTheaterMain().showPage(MovieTheaterMain.MOVIE_INFO_DETAIL);
			}
		});
		
	}
}
