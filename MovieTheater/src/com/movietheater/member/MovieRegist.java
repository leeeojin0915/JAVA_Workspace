package com.movietheater.member;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.movietheater.main.MovieFrame;
import com.movietheater.main.MovieTheaterMain;

public class MovieRegist extends MovieFrame{
	JPanel p_regist,p_id,p_pass,p_name,p_birth,p_gender,p_email,p_phone;
	String[] title= {"회원가입","아이디","비밀번호","생년월일","성별","전화번호","메일","-","@","년","월","일"};
	JLabel[] label=new JLabel[title.length];
	//JLabel la_id,la_pass,la_name,la_age,la_gender,la_phone,la_email,la_next,la_atSign;
	JTextField t_id,t_pass,t_name,t_phoneInfront,t_phoneBack,t_email;
	Choice year,month,day,phone,mail;
	JCheckBox woman,man;
	JButton bt_regist,bt_back;
	
	
	public MovieRegist(MovieTheaterMain movieTheaterMain) {
		super(movieTheaterMain);
		p_regist=new JPanel();
		p_id=new JPanel();
		p_pass=new JPanel();
		p_name=new JPanel();
		p_birth=new JPanel();
		p_gender=new JPanel();
		p_email=new JPanel();
		p_phone=new JPanel();
		for(int i=0;i<label.length;i++) {
			label[i]=new JLabel(title[i]);
		}
		t_id=new JTextField();
		t_pass=new JTextField();
		t_name=new JTextField();
		t_phoneInfront=new JTextField();
		t_phoneBack=new JTextField();
		t_email=new JTextField();
		year=new Choice();
		month=new Choice();
		day=new Choice();
		phone=new Choice();
		mail=new Choice();
		woman=new JCheckBox("여");
		man=new JCheckBox("남");
		bt_regist=new JButton("가입하기");
		bt_back=new JButton("취소");
		
		p_regist.setLayout(new FlowLayout(FlowLayout.LEFT));
		p_regist.setPreferredSize(new Dimension(movieTheaterMain.WIDTH/3,movieTheaterMain.HEIGHT-90));
		//p_regist.setBackground(Color.PINK);
		label[0].setFont(new Font("돋움체",Font.BOLD,90));
		for(int i=1;i<label.length;i++) {
			label[i].setFont(new Font("돋움체",Font.BOLD,20));			
		}
		t_id.setPreferredSize(new Dimension(150,20));
		t_pass.setPreferredSize(new Dimension(150,20));
		t_name.setPreferredSize(new Dimension(150,20));
		t_phoneInfront.setPreferredSize(new Dimension(100,20));
		t_phoneBack.setPreferredSize(new Dimension(100,20));
		t_email.setPreferredSize(new Dimension(150,20));
		
		p_regist.add(label[0]);
		p_id.add(label[1]);//아이디
		p_id.add(t_id);
		p_pass.add(label[2]);//비번
		p_pass.add(t_pass);
		p_birth.add(label[3]);//생년월일
		for(int i=1900;i<2021;i++) {
			year.add(""+i+"");
		}
		p_birth.add(year);
		p_birth.add(label[9]);
		for(int i=1;i<13;i++) {
			month.add(""+i+"");
		}
		p_birth.add(month);
		p_birth.add(label[10]);
		for(int i=1;i<32;i++) {
			day.add(""+i+"");
		}
		p_birth.add(day);
		p_birth.add(label[11]);
		p_gender.add(label[4]);//성별
		p_gender.add(woman);
		p_gender.add(man);
		p_phone.add(label[5]);//전화번호
		phone.add("010");
		phone.add("011");
		phone.add("016");
		phone.add("017");
		phone.add("019");
		phone.add("031");
		phone.add("032");
		phone.add("033");
		p_phone.add(phone);
		p_phone.add(t_phoneInfront);
		p_phone.add(label[7]);
		p_phone.add(t_phoneBack);
		p_email.add(label[6]);//메일
		p_email.add(t_email);
		p_email.add(label[8]);
		mail.add("naver.com");
		mail.add("hanmail.com");
		mail.add("gmail.com");
		mail.add("nate.com");
		p_email.add(mail);
		
		p_regist.add(p_id);
		p_regist.add(p_pass);
		p_regist.add(p_name);
		p_regist.add(p_birth);
		p_regist.add(p_gender);
		p_regist.add(p_phone);
		p_regist.add(p_email);
		p_regist.add(bt_regist);
		p_regist.add(bt_back);
		this.add(p_regist);


		
	}

}
