package day1105.db;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class EmpApp extends JFrame {
	JButton bt_connect, bt_load;
	JTextArea area;
	JScrollPane scroll;
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String user = "user1104";
	String password = "user1104";
	Connection con;// 접속 후 그 정보를 가진 객체, 따라서 접속을 끊으려면 이 객체 필요
	PreparedStatement pstmt;// 쿼리문 수행 객체, 인터페이스이므로 new로 생성하는 것이 아니라 접속 객체인 Connection 객체로 부터 인스턴스를 얻어 올 수
							// 있다.
							// 왜? 접속이 성공되어야 쿼리문을 수행할 수 있으므로 접속객체에 의존적인 것이 당연하다
	ResultSet rs;//select 쿼리문 수행결과에 의해 표가 반환되는데 이때 이 표를 담는 객체

	public EmpApp() {
		bt_connect = new JButton("Connect");
		bt_load = new JButton("load");

		area = new JTextArea();
		scroll = new JScrollPane(area);

		// 스타일적용
		area.setPreferredSize(new Dimension(780, 500));

		setLayout(new FlowLayout());

		add(bt_connect);
		add(bt_load);
		add(scroll);

		// 버튼과 리스너 연결
		bt_connect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				connect();// 오라클 접속
			}
		});
		bt_load.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				load();// select로 emp가져오기
			}
		});

		setSize(800, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void connect() {
		// 오라클 접속 시도하기
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			area.append("드라이버 로드 성공\n");

			// 접속시도
			con = DriverManager.getConnection(url, user, password);
			if (con == null) {
				area.append("접속실패\n");
			} else {
				area.append("접속성공");
			}
		} catch (ClassNotFoundException e) {
			area.append("드라이버 로드 실패\n");
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void load() {
		// select 문을 실행해 본다
		String sql = "select * from emp";
		try {
			pstmt = con.prepareStatement(sql);
			//pstmt.executeLargeUpdate()//DML(insert, update,delete)의 경우만
			//select문의 경우에는 executeQuery()이용해야 한다.
			rs=pstmt.executeQuery(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new EmpApp();
	}

}
