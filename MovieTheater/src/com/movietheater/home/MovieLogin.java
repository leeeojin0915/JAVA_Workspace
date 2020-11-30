package com.movietheater.home;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.movietheater.info.MoviePoster;
import com.movietheater.main.MovieFrame;
import com.movietheater.main.MovieTheaterMain;
import com.movietheater.member.Member;

public class MovieLogin extends MovieFrame {
	JPanel p_can, p_login;
	JLabel la_title, la_id, la_pass;
	JTextField t_id;
	JPasswordField t_pass;
	JButton bt_regist, bt_login;
	JButton bt_auto;
	JScrollPane scroll;
	Thread thread;

	public MovieLogin(MovieTheaterMain movieTheaterMain) {
		super(movieTheaterMain);
		scroll = new JScrollPane();
		p_can = new JPanel();
		p_login = new JPanel();

		la_title = new JLabel("MOVIE");
		la_id = new JLabel("아이디");
		la_pass = new JLabel("비밀번호");
		bt_regist = new JButton("회원가입");
		bt_login = new JButton("로그인");
		t_id = new JTextField();
		t_pass = new JPasswordField();

		this.setBackground(new Color(0x69bfcd));
		p_can.setPreferredSize(new Dimension(movieTheaterMain.WIDTH - 230, movieTheaterMain.HEIGHT - 240));
		p_can.setBorder(new TitledBorder(new LineBorder(new Color(0xb2dab8), 3,true)));
		p_login.setPreferredSize(new Dimension(movieTheaterMain.WIDTH - 600, movieTheaterMain.HEIGHT - 100));
		p_login.setBorder(new TitledBorder(new LineBorder(new Color(0xec6d71), 3, true)));
		bt_regist.setBackground(new Color(0xec6d71));
		bt_login.setBackground(new Color(0xec6d71));
		p_can.setBackground(new Color(0x69bfcd));
		p_login.setBackground(new Color(0x69bfcd));
		la_title.setFont(new Font("Verdana", Font.BOLD, 40));
		t_id.setPreferredSize(new Dimension(130, 20));
		t_pass.setPreferredSize(new Dimension(130, 20));
		p_login.add(la_title);
		p_login.add(la_id);
		p_login.add(t_id);
		p_login.add(la_pass);
		p_login.add(t_pass);
		p_login.add(bt_regist);
		p_login.add(bt_login);
		add(p_can);
		add(p_login);

		p_can.updateUI();

		bt_regist.addActionListener((e) -> {
			getMovieTheaterMain().showPage(MovieTheaterMain.MOVIE_HOME_REGIST);
		});
		bt_login.addActionListener((e) -> {
			Member member = new Member();
			member.setId(t_id.getText());
			member.setPassword(new String(t_pass.getPassword()));
			comfirmLogin(member);
		});
	}

	// 로그인 확인 메서드
	public void comfirmLogin(Member member) {
		if (member.getId().length() < 1) {
			JOptionPane.showMessageDialog(this, "1자 이상 입력하세요");
		} else if (member.getPassword().length() < 1) {
			JOptionPane.showMessageDialog(this, "한 자 이상 입력하세요");
		} else {
			if (login(member) == null) {
				JOptionPane.showMessageDialog(this, "로그인에 실패하였습니다.");
				t_id.setText("");
				t_pass.setText("");
			} else {
				getMovieTheaterMain().showPage(MovieTheaterMain.MOVIE_HOME);
				t_id.setText("");
				t_pass.setText("");
				MovieHome home=(MovieHome) getMovieTheaterMain().getMoviePage().get(MovieTheaterMain.MOVIE_HOME);
				home.receive(login(member));
				getMovieTheaterMain().setHasSession(true);
			}
		}
	}

	// home에보여주는 메서드
	public Member login(Member member) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member m = null;
		String sql = "select * from member where id=? and password=?";// 입력한 정보가 있는지 확인
		try {
			pstmt = getMovieTheaterMain().getCon().prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPassword());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				m = new Member();
				m.setMember_id(rs.getInt("member_id"));
				m.setId(rs.getString("id"));
				m.setPassword(rs.getString("password"));
				m.setName(rs.getString("name"));
				m.setGender(rs.getString("gender"));
				m.setBirth(rs.getString("birth"));
				m.setPhone(rs.getString("phone"));
				m.setEmail(rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			getMovieTheaterMain().getMovieDBManager().close(pstmt, rs);
		}
		return m;

	}

//	public void move() {
//		thread = new Thread() {
//			public void run() {
//				while (true) {
//					x -= 1;
//					p_can.repaint();
//					try {
//						thread.sleep(20);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
//				}
//			}
//		};
//		thread.start();
//	}



}
