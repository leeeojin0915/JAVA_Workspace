package com.movietheater.admin.info;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class MovieModel extends AbstractTableModel {

	ArrayList<String> columnList = new ArrayList<String>();//col
	ArrayList<Movie> movieList = new ArrayList<Movie>();//row

	public int getColumnCount() {
		return columnList.size();
	}

	public int getRowCount() {
		return movieList.size();
	}

	public String getColumnName(int col) {
		return columnList.get(col);
	}

	public Object getValueAt(int row, int col) {
		Movie movie=movieList.get(row);
		String data=null;
		if(col==0) {
			data=Integer.toString(movie.getMovie_id());
		}else if(col==1) {
			data=movie.getTitle();
		}else if(col==2) {
			data=Integer.toString(movie.getGenre_id());
		}else if(col==3) {
			data=Integer.toString(movie.getRating_id());
		}else if(col==4) {
			data=movie.getRelease_date();
		}else if(col==5) {
			data=movie.getStory();
		}else if(col==6) {
			data=movie.getUrl();
		}
		return data;
	}
}
