package day1105.db;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class EmpApp2 extends JFrame {
	JButton bt_connect, bt_load;
	JTextArea area;
	JScrollPane scroll;

	// JDBC기술은 DBMS종류에 상관없이 중립적인 코드를 작성할 수 있도록 지원한다.
	// 해당 DB기종마다 알맞는 Driver를 사용해야 한다.
	// ?autoReconnect=true&amp;serverTimezone=UTC -->최신버전이라 연결이 안될 경우 url에 붙여넣기

	String url = "jdbc:mariadb://localhost/db1105";
	String user = "root";
	String password = "1234";
	Connection con;// 접속 후 그 정보를 가진 객체, 따라서 접속을 끊으려면 이 객체 필요
	PreparedStatement pstmt;// 쿼리문 수행 객체, 인터페이스이므로 new로 생성하는 것이 아니라 접속 객체인 Connection 객체로 부터 인스턴스를 얻어 올 수
							// 있다.
							// 왜? 접속이 성공되어야 쿼리문을 수행할 수 있으므로 접속객체에 의존적인 것이 당연하다
	ResultSet rs;// select 쿼리문 수행결과에 의해 표가 반환되는데 이때 이 표를 담는 객체

	public EmpApp2() {
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
		//setDefaultCloseOperation(EXIT_ON_CLOSE); //DB를 닫지 않고 프로세스만 종료해버려서 쓰면 안된다
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				//열려있는 데이터베이스 관련 객체들을 모두 닫자
				if(rs!=null) {
					try {
						rs.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				if(pstmt!=null) {
					try {
						pstmt.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				if(con!=null) {
					try {
						con.close();
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
				//프로세스 종료
				System.exit(0);
			}
		});
	}

	public void connect() {
		// 오라클 접속 시도하기
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			area.append("드라이버 로드 성공\n");

			// 접속시도
			con = DriverManager.getConnection(url, user, password);
			if (con == null) {
				area.append("접속실패\n");
			} else {
				area.append("접속성공\n");
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
			// pstmt.executeLargeUpdate()//DML(insert, update,delete)의 경우만
			// select문의 경우에는 executeQuery()이용해야 한다.
			rs = pstmt.executeQuery(sql);
			// rs에는 표가 들어있다 따라서 원하는 레코드로 커서를 옮기자

			area.append("EMPNO\t ENAME\t JOB\t MGR\t HIREDATE\t\t SAL\t COMM\t DEPTNO\t \n");
			while (rs.next()) {//rs.nect()가 참인 동안만 반복문 수행
				//rs.next();// 데이터가 존재하면 한 칸 전진 후 true를 반환
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String job = rs.getString("job");
				int mgr = rs.getInt("mgr");
				String hiredate = rs.getString("hiredate");
				int sal = rs.getInt("sal");
				int comm = rs.getInt("comm");
				int deptno = rs.getInt("deptno");

				area.append(empno + "\t" + ename + "\t" + job + "\t" + mgr + "\t" + hiredate + "\t" + sal + "\t" + comm
						+ "\t" + deptno + "\t\n");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new EmpApp2();
	}

}
