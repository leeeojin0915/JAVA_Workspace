/**/
package day1106.db;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JTableApp extends JFrame{
	JTable table;//MVC에서 뷰이다
	JScrollPane scroll;
	MyModel model;
	
	public JTableApp() {
		table=new JTable(model=new MyModel());//jtable과 컨트롤러인 mymodel연결
		scroll=new JScrollPane(table);
		
		add(scroll);
		setSize(400, 200);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	

	public static void main(String[] args) {
		new JTableApp();
	}

}
