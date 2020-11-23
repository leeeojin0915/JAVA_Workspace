package com.movietheater.info;

import javax.swing.table.AbstractTableModel;

public class MovieReview extends AbstractTableModel {
	String[] column = { "내용", "이름" };
	String[][] data= {};

	public int getColumnCount() {
		return column.length;
	}

	public int getRowCount() {
		return data.length;
	}
	
	public String getColumnName(int col) {
		return column[col];
	}

	public Object getValueAt(int row, int col) {
		return data[row][col];
	}

}
