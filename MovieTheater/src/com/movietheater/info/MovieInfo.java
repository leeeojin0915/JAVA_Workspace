package com.movietheater.info;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.movietheater.admin.info.Movie;
import com.movietheater.main.MovieFrame;
import com.movietheater.main.MovieTheaterMain;

public class MovieInfo extends MovieFrame {
	JPanel p_info;
	JScrollPane scroll;
	ArrayList<MoviePoster> movieList;
	Thread thread;
	ArrayList<RatingVO> ratingList=new ArrayList<RatingVO>();
	ArrayList<GenreVO> genreList=new ArrayList<GenreVO>();;
	GenreVO genreVO;
	RatingVO ratingVO;

	public MovieInfo(MovieTheaterMain movieTheaterMain) {
		super(movieTheaterMain);
		p_info = new JPanel();
		scroll = new JScrollPane(p_info);

		p_info.setPreferredSize(new Dimension(movieTheaterMain.WIDTH, movieTheaterMain.HEIGHT));
		p_info.setBackground(new Color(0x69bfcd));
		add(scroll, BorderLayout.EAST);


		getMovie();
		p_info.updateUI();

		for (MoviePoster moviePoster : movieList) {
			moviePoster.addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent e) {
					MovieInfoDetail movieInfoDetail = (MovieInfoDetail) getMovieTheaterMain().getMoviePage()
							.get(MovieTheaterMain.MOVIE_INFO_DETAIL);
					movieInfoDetail.init(moviePoster.moive,genreVO,ratingVO,moviePoster.img);
					movieInfoDetail.p_can.repaint();
					movieInfoDetail.updateUI();
					getMovieTheaterMain().showPage(MovieTheaterMain.MOVIE_INFO_DETAIL);

				}
			});
		}

	}

	public void getMovie() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from movie";
		try {
			pstmt = getMovieTheaterMain().getCon().prepareStatement(sql);
			rs = pstmt.executeQuery();

			movieList = new ArrayList<MoviePoster>();
			while (rs.next()) {
				Movie vo = new Movie();
				vo.setMovie_id(rs.getInt("movie_id"));
				vo.setTitle(rs.getString("title"));
				vo.setGenre_id(rs.getInt("genre_id"));
				vo.setRating_id(rs.getInt("rating_id"));
				vo.setRelease_date(rs.getString("release_date"));
				vo.setStory(rs.getString("story"));
				vo.setUrl(rs.getString("url"));

				movieList.add(getPoster(vo));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			getMovieTheaterMain().getMovieDBManager().close(pstmt, rs);
		}
	}

	public void getRating() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from rating";
		try {
			pstmt = getMovieTheaterMain().getCon().prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (true) {
				RatingVO ratingVO = new RatingVO();
				ratingVO.setRating_id(rs.getInt("rating_id"));
				ratingVO.setName(rs.getString("name"));
				ratingList.add(ratingVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			getMovieTheaterMain().getMovieDBManager().close(pstmt, rs);
		}
	}

	public void getGenre() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from genre";
		try {
			pstmt = getMovieTheaterMain().getCon().prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (true) {
				GenreVO genreVO = new GenreVO();
				genreVO.setGenre_id(rs.getInt("genre_id"));
				genreVO.setName(rs.getString("name"));
				genreList.add(genreVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			getMovieTheaterMain().getMovieDBManager().close(pstmt, rs);
		}
	}

	public MoviePoster getPoster(Movie vo) {
		MoviePoster moviePoster = new MoviePoster(vo, this);
		p_info.add(moviePoster);

		return moviePoster;
	}
	public MoviePoster getPoster(Movie vo,GenreVO genreVO,RatingVO ratingVO) {
		MoviePoster moviePoster = new MoviePoster(vo, this);
		p_info.add(moviePoster);
		
		return moviePoster;
	}
}
