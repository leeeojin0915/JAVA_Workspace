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

public class TestEx extends JFrame {
	JButton bt_conn, bt_load;
	JTextArea area;
	JScrollPane scroll;

	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String user = "user1104";
	String password = "user1104";

	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	public TestEx() {
		bt_conn = new JButton("연결");
		bt_load = new JButton("로드");
		area = new JTextArea();
		scroll = new JScrollPane(area);

		area.setPreferredSize(new Dimension(770, 620));

		setLayout(new FlowLayout());
		add(bt_conn);
		add(bt_load);
		add(scroll);

		bt_conn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				conn();
			}
		});

		bt_load.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				load();
			}
		});

		setVisible(true);
		setSize(800, 700);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
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
				System.exit(0);
			}
		});

	}

	public void conn() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			area.append("드라이버 로드 성공\n");
			con = DriverManager.getConnection(url, user, password);
			if (con == null) {
				area.append("접속 실패\n");
			} else {
				area.append("접속성공\n");
				
				/*
				String in="insert into member(member_id,name,age,phone)";
				in+=" values(seq_member.nextval,'batman',25,'016')";
				
				pstmt=con.prepareStatement(in);
				
				int result=pstmt.executeUpdate();
				if(result==0) {
					System.out.println("입력실패");
				}else {
					System.out.println("입력성공");
				}*/
				
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			area.append("드라이버 로드 실패");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void load() {
		String sql = "select * from member";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);

			area.append("MEMBER_ID \t NAME \t AGE \t PHONE\n");

			while (rs.next()) {
				int member_id = rs.getInt("member_id");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String phone = rs.getString("phone");
				area.append(member_id + "\t" + name + "\t" + age + "\t" + phone + "\t\n");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new TestEx();
	}

}
