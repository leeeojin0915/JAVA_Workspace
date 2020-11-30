package com.movietheater.admin.info;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

import com.movietheater.admin.main.AdminMovieFrame;
import com.movietheater.admin.main.AdminMovieTheaterMain;
import com.movietheater.main.MovieTheaterMain;

public class AdminMovieInfo extends AdminMovieFrame {
	JPanel p_list, p_info;
	JTree rating;
	JTable table;
	JScrollPane scroll;
	JButton bt_regist;
	MovieModel movieModel;

	ArrayList<String> ratingList;// 상위
	ArrayList<ArrayList> movieList = new ArrayList<ArrayList>();// 하위

	ArrayList<Movie> movies;
	Movie movie;

	public AdminMovieInfo(AdminMovieTheaterMain adminMovieTheaterMain) {
		super(adminMovieTheaterMain);
		p_list = new JPanel();
		p_info = new JPanel();
		table = new JTable();
		scroll = new JScrollPane(table);
		bt_regist = new JButton("등록");
		movieModel = new MovieModel();

		p_list.setPreferredSize(new Dimension(200, adminMovieTheaterMain.HEIGHT - 100));
		p_list.setBackground(Color.PINK);

		p_info.setPreferredSize(new Dimension(800, adminMovieTheaterMain.HEIGHT - 100));
		p_info.setBackground(Color.BLUE);

		scroll.setPreferredSize(new Dimension(800, 200));

		getRatingList();
		DefaultMutableTreeNode top = new DefaultMutableTreeNode("연령정보");
		createNode(top);

		rating = new JTree(top);

		p_list.setLayout(new FlowLayout(FlowLayout.LEFT));
		p_list.add(rating);
		p_info.add(scroll);
		p_info.add(bt_regist);

		this.add(p_list);
		this.add(p_info);

		getMovieList(null);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					AdminMovieInfoModi adminMovieInfosModi = (AdminMovieInfoModi) adminMovieTheaterMain.getMoviePage()
							.get(AdminMovieTheaterMain.AD_MOVIE_INFO_MODI);
					String movie_id = (String) table.getValueAt(table.getSelectedRow(), 0);
					adminMovieInfosModi.getInfo(Integer.parseInt(movie_id));
					adminMovieTheaterMain.showPage(AdminMovieTheaterMain.AD_MOVIE_INFO_MODI);
				}
			}
		});
		bt_regist.addActionListener((e) -> {
			adminMovieTheaterMain.showPage(AdminMovieTheaterMain.AD_MOVIE_INFO_REGIST);
		});

		rating.addTreeSelectionListener((e) -> {
			DefaultMutableTreeNode select = (DefaultMutableTreeNode) rating.getLastSelectedPathComponent();
			if (select.toString().equals("연령정보")) {
				getMovieList(null);
			} else {
				getMovieList(select.toString());
			}
		});
	}

	public void getRatingList() {// 관람등급목록
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from rating";
		try {
			pstmt = getMovieTheaterMain().getCon().prepareStatement(sql);
			rs = pstmt.executeQuery();
			ratingList = new ArrayList<String>();
			while (rs.next()) {
				ratingList.add(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			getMovieTheaterMain().getMovieDBManager().close(pstmt, rs);
		}
	}

	public void getMovieList(String data) {// 영화목록
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;

		if (data == null) {
			sql = "select * from movie order by movie_id asc";
		} else {
			sql = "select * from movie where rating_id=(select rating_id from rating where name='" + data + "')";
		}

		try {
			pstmt = getMovieTheaterMain().getCon().prepareStatement(sql);
			rs = pstmt.executeQuery();
			ResultSetMetaData meta = rs.getMetaData();
			ArrayList<String> col = new ArrayList<String>();
			for (int i = 1; i <= meta.getColumnCount(); i++) {
				String name = meta.getColumnName(i);
				col.add(name);
			}
			movies = new ArrayList<Movie>();
			while (rs.next()) {
				movie = new Movie();
				movie.setMovie_id(rs.getInt("movie_id"));
				movie.setTitle(rs.getString("title"));
				movie.setGenre_id(rs.getInt("genre_id"));
				movie.setRating_id(rs.getInt("rating_id"));
				movie.setRelease_date(rs.getString("release_date"));
				movie.setStory(rs.getString("story"));
				movie.setUrl(rs.getString("url"));
				movies.add(movie);
			}
			movieModel.columnList = col;
			movieModel.movieList = movies;
			table.setModel(movieModel);
			table.updateUI();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void createNode(DefaultMutableTreeNode top) {
		DefaultMutableTreeNode list;
		for (int i = 0; i < ratingList.size(); i++) {
			top.add(list = new DefaultMutableTreeNode(ratingList.get(i)));
		}
	}

}
