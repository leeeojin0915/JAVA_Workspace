package com.movietheater.admin.info;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.movietheater.admin.main.AdminMovieFrame;
import com.movietheater.admin.main.AdminMovieTheaterMain;

public class AdminMovieInfoRegist extends AdminMovieFrame {
	String[] la_name = { "[영화제목]", "[장르]", "[관람등급]", "[개봉일]", "[줄거리]", "[이미지]" };
	JPanel[] panel = new JPanel[8];
	JLabel[] label = new JLabel[la_name.length];
	JButton bt_regist, bt_cancel;
	JTextField t_title, t_url, t_date;
	Choice ch_genre, ch_rating;
	JTextArea story;
	JScrollPane scroll;
	AdminMovieInfo adminMovieInfo ;
	ArrayList<String> ratingList;
	ArrayList<String> genreList;

	public AdminMovieInfoRegist(AdminMovieTheaterMain movieTheaterMain) {
		super(movieTheaterMain);
		adminMovieInfo = new AdminMovieInfo(movieTheaterMain);
		genre();
		for (int i = 0; i < panel.length; i++) {
			panel[i] = new JPanel();
		}
		for (int i = 0; i < label.length; i++) {
			label[i] = new JLabel(la_name[i]);
		}
		bt_regist = new JButton("등록하기");
		bt_cancel = new JButton("취소");
		t_date = new JTextField();
		story = new JTextArea();
		scroll = new JScrollPane(story);
		t_title = new JTextField();
		t_url = new JTextField();
		ch_rating = new Choice();
		ch_genre = new Choice();

		for (String name : adminMovieInfo.ratingList) {
			ch_rating.add(name);
		}

		for (int i = 0; i < genreList.size(); i++) {
			ch_genre.add(genreList.get(i));
		}
		panel[0].setLayout(new FlowLayout(FlowLayout.LEFT));
		panel[0].setPreferredSize(new Dimension(600, movieTheaterMain.HEIGHT - 90));
		panel[0].setBackground(Color.GREEN);
		for (int i = 1; i < panel.length; i++) {
			panel[i].setPreferredSize(new Dimension(500, 65));
			panel[i].setLayout(new FlowLayout(FlowLayout.LEFT));
			if (i == 5) {
				panel[5].setPreferredSize(new Dimension(480, 180));
			}
		}
		scroll.setPreferredSize(new Dimension(400, 160));
		t_title.setPreferredSize(new Dimension(200, 20));
		t_url.setPreferredSize(new Dimension(300, 20));
		t_date.setPreferredSize(new Dimension(200, 20));

		panel[1].add(label[0]);
		panel[1].add(t_title);
		panel[2].add(label[1]);
		panel[2].add(ch_genre);
		panel[3].add(label[2]);
		panel[3].add(ch_rating);
		panel[4].add(label[3]);
		panel[4].add(t_date);
		panel[5].add(label[4]);
		panel[5].add(scroll);
		panel[6].add(label[5]);
		panel[6].add(t_url);

		for (int i = 1; i < panel.length; i++) {
			panel[0].add(panel[i]);
		}
		panel[7].add(bt_regist);
		panel[7].add(bt_cancel);
		add(panel[0]);

		bt_regist.addActionListener((e) -> {
			if (movieRegist() == 0) {
				JOptionPane.showMessageDialog(AdminMovieInfoRegist.this, "등록실패");
			} else {
				JOptionPane.showMessageDialog(AdminMovieInfoRegist.this, "등록성공");
				adminMovieInfo.getMovieList(null);
				AdminMovieInfo adminMovieInfo=(AdminMovieInfo) movieTheaterMain.getMoviePage().get(AdminMovieTheaterMain.AD_MOVIE_INFO);
				getMovieTheaterMain().showPage(AdminMovieTheaterMain.AD_MOVIE_INFO);
				
			}
		});
	}

	public void genre() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from genre";
		try {
			pstmt = getMovieTheaterMain().getCon().prepareStatement(sql);
			rs = pstmt.executeQuery();
			genreList = new ArrayList();
			while (rs.next()) {
				genreList.add(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			getMovieTheaterMain().getMovieDBManager().close(pstmt, rs);
		}
	}

	public int getGenreId(String genre) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int genre_id = 0;
		String sql = "select * from genre where name=?";

		try {
			pstmt = getMovieTheaterMain().getCon().prepareStatement(sql);
			pstmt.setString(1, genre);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				genre_id = rs.getInt("genre_id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			getMovieTheaterMain().getMovieDBManager().close(pstmt, rs);
		}
		return genre_id;
	}

	public int getRatingId(String rating) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int rating_id = 0;
		String sql = "select * from rating where name=?";

		try {
			pstmt = getMovieTheaterMain().getCon().prepareStatement(sql);
			pstmt.setString(1, rating);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				rating_id = rs.getInt("rating_id");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			getMovieTheaterMain().getMovieDBManager().close(pstmt, rs);
		}
		return rating_id;
	}

	public int movieRegist() {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "insert into movie(movie_id,title,genre_id,rating_id,release_date,story,url)";
		sql += " values(seq_movie.nextval,?,?,?,?,?,?)";

		try {
			pstmt = getMovieTheaterMain().getCon().prepareStatement(sql);
			pstmt.setString(1, t_title.getText());
			pstmt.setInt(2, getGenreId(ch_genre.getSelectedItem()));
			pstmt.setInt(3, getRatingId(ch_rating.getSelectedItem()));
			pstmt.setString(4, t_date.getText());
			pstmt.setString(5, story.getText());
			pstmt.setString(6, t_url.getText());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			getMovieTheaterMain().getMovieDBManager().close(pstmt);
		}
		return result;
	}

}
