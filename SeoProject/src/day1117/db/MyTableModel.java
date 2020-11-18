package day1117.db;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class MyTableModel extends AbstractTableModel{
	//아래의 두 벡터가 현재는 0이지만 유저가 원하는 오라클의 테이블명을 JTable에서 선택할 때
	//컬럼에 대한 정보를 조사해서 동적으로 채워넣을 예점
	
	//티어블에 보여질 컬럼 정보를 갖는 벡터
	Vector<String> column=new Vector<String>();
	//테이블에 보여질 레코드를 처리하는 벡터 선언
	Vector<Vector> record=new Vector<Vector>();
	public MyTableModel(Vector record,Vector column) {
		this.record=record;
		this.column=column;
		
	}
	public int getColumnCount() {
		return column.size();
	}
	public String getColumnName(int col) {
		return column.get(col);
	}
	public int getRowCount() {
		return record.size();
	}

	public Object getValueAt(int row, int col) {
		return record.get(row).get(col);//층을 먼저 뽑는다.record[][]
	}
	

}
