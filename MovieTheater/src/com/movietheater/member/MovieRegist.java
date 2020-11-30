package com.movietheater.member;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.movietheater.main.MovieFrame;
import com.movietheater.main.MovieTheaterMain;

public class MovieRegist extends MovieFrame {
	JPanel p_regist, p_id, p_pass, p_name, p_birth, p_gender, p_email, p_phone, p_button;
	String[] title = { "아이디", "비밀번호", "이름", "생년월일", "성별", "전화번호", "메일", "-", "@", "년", "월", "일" };
	JLabel[] label = new JLabel[title.length];
	String[] addPhone = { "010", "011", "017", "019", "032", "031", "02", "043", "055" };
	String[] addemail = { "naver.com", "daum.net ", "gail.com ", "nate.com ", "직접입력 " };
	JTextField t_id, t_name, t_phoneInfront, t_phoneBack, t_email;
	JPasswordField t_pass;
	Choice year, month, day, phone, mail;
	JRadioButton woman, man;
	JButton bt_regist, bt_back, bt_check;
	ButtonGroup gender;
	JFrame genderBox;

	ArrayList<Member> memberList;
	Member member;

	public MovieRegist(MovieTheaterMain movieTheaterMain) {
		super(movieTheaterMain);
		p_regist = new JPanel();
		p_id = new JPanel();
		p_pass = new JPanel();
		p_name = new JPanel();
		p_birth = new JPanel();
		p_gender = new JPanel();
		p_email = new JPanel();
		p_phone = new JPanel();
		p_button = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		for (int i = 0; i < label.length; i++) {
			label[i] = new JLabel(title[i]);
		}
		t_id = new JTextField();
		t_pass = new JPasswordField();
		t_name = new JTextField();
		t_phoneInfront = new JTextField();
		t_phoneBack = new JTextField();
		t_email = new JTextField();
		year = new Choice();
		month = new Choice();
		day = new Choice();
		phone = new Choice();
		mail = new Choice();
		woman = new JRadioButton("여");
		man = new JRadioButton("남", true);
		bt_regist = new JButton("가입하기");
		bt_back = new JButton("취소");
		bt_check = new JButton("중복확인");
		gender = new ButtonGroup();
		genderBox = new JFrame();

		this.setBackground(new Color(0x69bfcd));
		p_regist.setBorder(new TitledBorder(new LineBorder(Color.PINK, 3, true), "회원가입"));
		p_regist.setBackground(new Color(0x69bfcd));
		p_regist.setLayout(new FlowLayout(FlowLayout.LEFT));
		p_regist.setPreferredSize(new Dimension(movieTheaterMain.WIDTH / 2, movieTheaterMain.HEIGHT - 150));
		// p_regist.setBackground(Color.PINK);
		for (int i = 0; i < label.length; i++) {
			label[i].setFont(new Font("돋움체", Font.PLAIN, 15));
		}
		t_id.setPreferredSize(new Dimension(movieTheaterMain.WIDTH / 5, 20));
		t_pass.setPreferredSize(new Dimension(movieTheaterMain.WIDTH / 5, 20));
		t_name.setPreferredSize(new Dimension(movieTheaterMain.WIDTH / 5, 20));
		t_phoneInfront.setPreferredSize(new Dimension(movieTheaterMain.WIDTH / 8, 25));
		t_phoneBack.setPreferredSize(new Dimension(movieTheaterMain.WIDTH / 8, 25));
		t_email.setPreferredSize(new Dimension(movieTheaterMain.WIDTH / 8, 25));
		bt_regist.setBackground(new Color(0xec6d71)); 
		bt_check.setBackground(new Color(0xec6d71)); 
		bt_back.setBackground(new Color(0xec6d71)); 

		p_id.add(label[0]);// 아이디
		p_id.add(t_id);
		p_id.add(bt_check);
		p_id.setBackground(new Color(0x69bfcd));

		
		p_pass.setBackground(new Color(0x69bfcd));
		p_pass.add(label[1]);// 비번
		p_pass.add(t_pass);
		

		p_name.setBackground(new Color(0x69bfcd));
		p_name.add(label[2]);// 이름
		p_name.add(t_name);

		p_birth.setBackground(new Color(0x69bfcd));
		p_birth.add(label[3]);// 생년월일
		for (int i = 1950; i < 2021; i++) {
			year.add(String.valueOf(i));
		}
		p_birth.add(year);
		p_birth.add(label[9]);// 년
		for (int i = 1; i < 13; i++) {
			month.add(String.valueOf(i));
		}
		p_birth.add(month);
		p_birth.add(label[10]);// 월
		for (int i = 1; i < 32; i++) {
			day.add(String.valueOf(i));
		}
		p_birth.add(day);
		p_birth.add(label[11]);// 일

		p_gender.setBackground(new Color(0x69bfcd));
		p_gender.add(label[4]);// 성별
		gender.add(man);
		gender.add(woman);
//		genderBox.add(man);
//		genderBox.add(woman);
		p_gender.add(man);
		p_gender.add(woman);

		p_phone.setBackground(new Color(0x69bfcd));
		p_phone.add(label[5]);// 전화번호
		for (int i = 0; i < addPhone.length; i++) {
			phone.add(addPhone[i]);
		}
		p_phone.add(phone);
		p_phone.add(t_phoneInfront);
		p_phone.add(label[7]);// -
		p_phone.add(t_phoneBack);

		p_email.setBackground(new Color(0x69bfcd));
		p_email.add(label[6]);// 메일
		p_email.add(t_email);
		p_email.add(label[8]);// @
		for (int i = 0; i < addemail.length; i++) {
			mail.add(addemail[i]);
		}
		p_email.add(mail);

		p_regist.setBackground(new Color(0x69bfcd));
		p_regist.add(p_id);
		p_regist.add(p_pass);
		p_regist.add(p_name);
		p_regist.add(p_birth);
		p_regist.add(p_gender);
		p_regist.add(p_phone);
		p_regist.add(p_email);
		p_button.setBackground(new Color(0x69bfcd));
		p_button.add(bt_regist);
		p_button.add(bt_back);
		p_regist.add(p_button);

		this.add(p_regist);

		bt_check.addActionListener((e) -> {
			if (id(t_id.getText())) {
				JOptionPane.showMessageDialog(this, "이미 다른 아이디가 있습니다.");
			}else {
				JOptionPane.showMessageDialog(this, "사용 가능 한 아이디 입니다.");
			}
		});
		bt_regist.addActionListener((e) -> {
			checkForm(regist());
			 if(id(t_id.getText())) {
				JOptionPane.showMessageDialog(this, "이미 가입된 아이디 입니다. \n 아이디 중복 후 시도하세요");
				t_id.setText("");
			}
		});
		bt_back.addActionListener((e)->{
			getMovieTheaterMain().showPage(MovieTheaterMain.MOVIE_HOME_REGIST);
		});

	}
	public boolean id(String id) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from member where id=?";
		boolean data = false;
		try {
			pstmt = getMovieTheaterMain().getCon().prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			data = rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return data;
	}

	public Member regist() {
		int yy = Integer.parseInt(year.getSelectedItem());
		int mm = Integer.parseInt(month.getSelectedItem());
		int dd = Integer.parseInt(day.getSelectedItem());
		// String data = "남";
		Member member = new Member();
		member.setId(t_id.getText());
		member.setPassword(new String(t_pass.getPassword()));
		member.setName(t_name.getText());
		member.setBirth(Integer.toString(yy) + "-" + Integer.toString(mm) + "-" + Integer.toString(dd));
		if (man.isSelected() == true) {
			member.setGender(man.getText()); 
		} else if (woman.isSelected() == true) {
			member.setGender(woman.getText());
		}
		member.setPhone(
				new String(phone.getSelectedItem() + "-" + t_phoneInfront.getText() + "-" + t_phoneBack.getText()));
		member.setEmail(new String(t_email.getText() + "@" + mail.getSelectedItem()));
		return member;
	}

	public void checkForm(Member member) {
		if (member.getId().length() < 1) {
			JOptionPane.showMessageDialog(this, "한 글자 이상 입력하세요");
		} else if (member.getPassword().length() < 3) {
			JOptionPane.showMessageDialog(this, "3자 이상 입력하세요");
		} else if (member.getName().length() < 1) {
			JOptionPane.showMessageDialog(this, "한 글자 이상 입력하세요");
		} else if (member.getBirth().length() < 8) {
			JOptionPane.showMessageDialog(this, "생년월일을 입력하세요");
		} else if (member.getPhone().length() < 13) {
			JOptionPane.showMessageDialog(this, "번호를 입력해주세요");
		} else if (member.getEmail().length() < 14) {
			JOptionPane.showMessageDialog(this, "메일을 입력하세요");
		} else {
			if (getMember(member) == 0) {
				JOptionPane.showMessageDialog(this, "회원가입에 실패했습니다. 다시 시도해 주세요");
				getMovieTheaterMain().showPage(MovieTheaterMain.MOVIE_HOME_REGIST);
			} else {
				JOptionPane.showMessageDialog(this, "가입성공");
				getMovieTheaterMain().showPage(MovieTheaterMain.MOVIE_LOGIN);

			}
		}
	}

	public int getMember(Member member) {
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "insert into member(member_id,id,password,name,gender,birth,phone,email) values(seq_member.nextval,?,?,?,?,?,?,?)";

		try {
			pstmt = getMovieTheaterMain().getCon().prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getGender());
			pstmt.setString(5, member.getBirth());
			pstmt.setString(6, member.getPhone());
			pstmt.setString(7, member.getEmail());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			getMovieTheaterMain().getMovieDBManager().close(pstmt);
		}
		return result;
	}

}
