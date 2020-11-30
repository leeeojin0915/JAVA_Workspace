package com.movietheater.reservation;

import com.movietheater.admin.info.Movie;

public class ReservationVo extends Movie{
	private String theater;
	private String day;
	private String time;

	public String getTheater() {
		return theater;
	}

	public void setTheater(String theater) {
		this.theater = theater;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
}
