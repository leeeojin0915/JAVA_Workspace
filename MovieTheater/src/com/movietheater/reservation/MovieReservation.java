package com.movietheater.reservation;

import java.awt.Choice;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.movietheater.main.MovieFrame;
import com.movietheater.main.MovieTheaterMain;

public class MovieReservation extends MovieFrame {
	JPanel p_west,p_center,p_east;
	//JPanel p_
	JScrollPane scroll;
	JLabel la_date,la_month,la_day,la_theater;
	Choice ch_month,ch_day,ch_region,ch_theater;
	JButton bt_next;
	public MovieReservation(MovieTheaterMain movieTheaterMain) {
		super(movieTheaterMain);
		

	}

}
