/*
 * DBeaver 수준은 아니더라도 딕셔너리를 학습하기 위해 데이터 베이스 접속 클라이언트를 자바로 만들어본다
 * 실무에서는 SQLplus를 잘 사용하지 않음 이유)업무효율성이 떨어짐
 * 				언제쓰는가? 실무 현장엣는 개발자의 pc에는 각종 개발툴들이 있지만,실제적인 운영 서버에는
 * 				보안상 아무것도 설치해서는 안된다. 따라서 서버에는 툴들이 없기 때문에 만일 오라클을 유지보수하러 파견을 나간경우
 * 				콘솔창 기반으로 쿼리를 다뤄야 할 경우가 종종 있다. 이때 SQLPlus를 써야함
 * 개발자들이 개발할 때 데이터베이스 다루는 툴을 데이터베이스 "접속 클라이언트"라고 부른다.
 * 이러한 툴들 중 꽤 유명한 제품은 Toad,등이 있다(유료)
 * Toad는 DBeaver에 비해 기능이 막강하지만 유료이기 때문에 우리는 DBeaver사용
 * */

/*
 * day1116일차에 구현했던 데이터베이스 클라이언트 프로그램에서 jTable 생성자의 Vector방식을 이용하면
 * 동적인 테이블 선택시 유지보수성이 거의 불가능한 수준이므로 이를 개선해보자
 * 즉, 유저가 어떤 테이블을 선택할 지 알 수 없으므로 선택한 테이블의 컬럼 수,구성 등을 예측 할 수 없는 상황에
 * 대처해본다.
 * */
package day1117.db;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class DBMSClientApp2 extends JFrame {
	JPanel p_west;// 서쪽
	Choice ch_users;// 유저명이 출력 될 초이스 컴포넌트
	JPasswordField t_pass;// 비밀번호 텍스트 필드
	JButton bt_login;// 접속버튼

	JPanel p_center;// 그리드가 적용될 센터패널
	JPanel p_upper;// 테이블과 시퀀스를 포함한 패널(그리드)
	JPanel p_middle;// SQL편집기가 위치 할 미들 패널(borderLayout)
	JPanel p_bottom;// 하단의 그리드(1,2)가 적용될 패널
	JTextArea area;// 쿼리 편집기
	JButton bt_execute;// 쿼리문 실행버튼
	JTable t_tables;// 유저의 테이블 정보를 출력할 테이블
	JTable t_seq;// 유저의 시퀀스 정보를 출력할 테이블
	JTable t_record;// 유저가 선택한 테이블의 레코드를 출력 할 Jtable
	JTable t_colname;// '' 컬럼명,자료형 출력
	JScrollPane s1, s2, s3, s4, s5;// 스크롤 4개

	String driver = "oracle.jdbc.driver.OracleDriver";
	String url = "jdbc:oracle:thin:@localhost:1521:XE";
	String user = "system";
	String password = "1234";
	Connection con;

	// 테이블 모델로 가면 힘드니 이차원 벡터
	Vector tableList = new Vector();// 이벡터 안에는 추후 또다른 벡터가 들아갈 예점 즉, 이차원 배열과동일
									// 단, 이차원배열보다는 크기가 자유로워서 유연함 코딩하기 편하다
	Vector<String> tableColumn = new Vector<String>();// 컬럼명은 당연히 String

	// 시퀀스에 필요한 벡터들
	Vector seqList = new Vector();
	Vector<String> seqColumn = new Vector<String>();

	// 테이블 컬럼정보에 필요한 벡터들
	Vector columnList = new Vector();
	Vector<String> columType = new Vector<String>();

	// TableModel보유
	MyTableModel model;

	public DBMSClientApp2() {
		// 생성
		p_west = new JPanel();
		ch_users = new Choice();
		t_pass = new JPasswordField();
		bt_login = new JButton("접속");

		p_center = new JPanel();
		p_upper = new JPanel();
		p_middle = new JPanel();
		p_bottom = new JPanel();
		area = new JTextArea();
		bt_execute = new JButton("SQL문 실행");
		s3 = new JScrollPane(area);// 추후 컬럼 정보 보여줄 스크롤

		p_center.setLayout(new GridLayout(3, 2));// 3층에 1호수
		p_upper.setLayout(new GridLayout(1, 2));// 1층에 2호수
		p_middle.setLayout(new BorderLayout());
		p_bottom.setLayout(new GridLayout(1, 2));

		// 컬럼정보 초기화하기
		// 완성된 이차원벡터를 jtable에 반영 생성자의 인수로 넣자
		// 컬럼정보는 어떻게 가져올까- 2개밖에 없으니 고정
		tableColumn.add("table_name");
		tableColumn.add("tablespace_name");
		// 사이즈가 0이지만 추후 메서드 호출 시 벡터의 크기가 변경
		// jtable을 새로고침하면 됨
		t_tables = new JTable(tableList, tableColumn);// 여기서 초기백터값을 넣어주기 이 시점은 db연동 전이므로

		// 시퀀스의 생성자에 벡터 적용
		seqColumn.add("sequence_name");
		seqColumn.add("last_number");
		t_seq = new JTable(seqList, seqColumn);
		s1 = new JScrollPane(t_tables);
		s2 = new JScrollPane(t_seq);

		// 선택한 테이블의 레코드 보여줄 JTable생성
		// t_record = new JTable(model = new MyTableModel());// myTablemodel을 대입하 예쩡
		t_record = new JTable(null);// myTablemodel을 대입하 예쩡
		s4 = new JScrollPane(t_record);

		// 선택한 테이블의 컬럼명,자료형 보여줄 Jtable
		columType.add("컬럼명");
		columType.add("데이터타입");
		t_colname = new JTable(columnList,columType);
		s5 = new JScrollPane(t_colname);

		// 스타일
		p_west.setPreferredSize(new Dimension(150, 30));
		ch_users.setPreferredSize(new Dimension(145, 30));
		t_pass.setPreferredSize(new Dimension(145, 30));
		bt_login.setPreferredSize(new Dimension(145, 30));
		area.setFont(new Font("Arial Black", Font.BOLD, 20));

		// 조립
		p_west.add(ch_users);
		p_west.add(t_pass);
		p_west.add(bt_login);

		p_upper.add(s1);
		p_upper.add(s2);
		p_middle.add(s3);
		p_middle.add(bt_execute, BorderLayout.SOUTH);
		p_bottom.add(s4);
		p_bottom.add(s5);

		p_center.add(p_upper);// 그리드의1층
		p_center.add(p_middle);// 그리드의2층
		p_center.add(p_bottom);

		add(p_west, BorderLayout.WEST);
		add(p_center);

		setSize(900, 750);
		setVisible(true);
		// setDefaultCloseOperation(EXIT_ON_CLOSE);
		// 프로세스만 종료시켜버리므로 오라클 스트림 닫는 처리를
		// 할 기회를 잃어버리게 된다
		// 따라서 윈도우 어댑터 구현하여 닫을게 있다면 닫는처리하자
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				disConnect();// 시스템 종료전에 닫을 자원이 있을때 먼저 닫을려고 호출함
				System.exit(0);
			}
		});

		bt_login.addActionListener((e) -> {
			login();// 선택한 유저로 로그인 시도
		});

		// 테이블과 리스너 연결
		t_tables.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				// 선택한 좌표의 테이블명 얻기
				int row = t_tables.getSelectedRow();// 선택한 row구하기
				int col = t_tables.getSelectedColumn();// 선택한 column구하기

				String tableName = (String) t_tables.getValueAt(row, col);
				tableName = tableName.toLowerCase();// 소문자
				System.out.println(t_tables.getValueAt(row, col));

				// 구해진 테이블 명을 select()메서드의 인수로 넘기자
				select(tableName);
				System.out.println("모델의 컬럼 카운트는" + t_record.getColumnCount());
			}
		});
		// 시퀀스와 리스너 연결
		t_seq.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				// 선택한 좌표의 테이블명 얻기
				int row = t_seq.getSelectedRow();// 선택한 row구하기
				int col = t_seq.getSelectedColumn();// 선택한 column구하기
				System.out.println(t_seq.getValueAt(row, col));
			}
		});
		bt_execute.addActionListener((e) -> {
			select(null);
		});
		setLocationRelativeTo(null);
		connect();// 서버접속
		getUserList();// 유저목록 구해오기

	}

	// 오라클에 접속하기
	public void connect() {
		try {
			Class.forName(driver);// 드라이버로드
			con = DriverManager.getConnection(url, user, password);// 접속시도
			if (con == null) {
				JOptionPane.showMessageDialog(this, user + "접속실패");
			} else {
				this.setTitle(user + " 계정으로 접속 중...");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 유저목록 가져오기
	public void getUserList() {
		// pstmt와 result은 소모품이므로 매 쿼리문마다 1개씩 대웅
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select username from dba_users order by username asc";
		try {
			pstmt = con.prepareStatement(sql);// 쿼리문 준비
			rs = pstmt.executeQuery();// 반환형을 먼저 적으면 이클립스가 알맞는 메서드를 찾아줌

			// 컬럼정보 초기화하기
			tableColumn.add("table_name");
			tableColumn.add("tablespace_name");

			// rs에 들어있는 유저정보를 Choice에 출력
			while (rs.next()) {
				ch_users.add(rs.getString("username"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 자원닫기
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void getTableList() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select table_name, tablespace_name from user_tables";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			// 평소같았으면 이차원 배열 선언한 후 last(),getRow(),스크롤 옵션 등을 넣었을테지만
			// 벡터를 이용하면 필요없음
			while (rs.next()) {
				Vector vec = new Vector();// table 벡터에 담겨질 벡터
				vec.add(rs.getString("table_name"));
				vec.add(rs.getString("tablespace_name"));

				tableList.add(vec);// 멤버변수 벡터에 벡터를 담았으니 이제 멤버변수 벡터는 이차원벡터가 됨
			}

			t_tables.updateUI();
			// 테이블의 러코드와 컬럼갯수 확인
			// 현재 테이블이 컬럼을 몇 개로 인식하고 있는지
			System.out.println("컬럼수는:" + t_tables.getColumnCount());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 자원닫기
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// 시퀀스가져오기
	public void getSeList() {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select sequence_name, last_number from user_sequences";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				Vector seq = new Vector();
				seq.add(rs.getString("sequence_name"));
				seq.add(rs.getString("last_number"));
				seqList.add(seq);// 기존 시퀀스 벡터에 추가해서 이차원벡터로 만들기
			}
			// 만들어진 벡터를 테이블에 반영
			t_seq.updateUI();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 자원닫기
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}

	// 유저가 선택한 테이블의 레코드 가져오기
	// 이 메서드를 호출하는 자는 select문의 매개변수로 테이블명을 넘겨야함
	// 매개변수가 넘어오면, 테이블명만 사용하고 안넘어오면 전체 SQL문 대체하자
	public void select(String tableName) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = null;
		if (tableName != null) {// 테이블명을 매개변수로 넘기면 아래의 쿼리문
			sql = "select * from " + tableName;
		} else {
			sql = area.getText();
		}
		System.out.println(sql);

		// 완성을 지으면서
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			/*
			 * 컬럼 정보 만들기 위한 코드
			 */
			Vector column = new Vector();// 이 벡터는 새로운 TableModel 객체의 인스턴스가 가진 컬럼벡터에 대입 될 예정
			ResultSetMetaData meta = rs.getMetaData();
			int columnCount = meta.getColumnCount();// 총 컬럼 수

			System.out.println("당신이 선택한" + tableName + "테이블 컬럼 수는" + columnCount);

			// 컬럼ㅈ 정보 출력
			// 출력만 확인하지말고 MyTableModel이 보유한 컬럼용 벡터네 정보를 채워넣자
			for (int i = 1; i <= columnCount; i++) {
				// System.out.println(meta.getColumnName(i));
				column.add(meta.getColumnName(i));
			}
			Vector record = new Vector();
			while (rs.next()) {
				Vector vec = new Vector();// 비어있는 일차원 벡터
				// 이 rs를 어디에 담아야 ㅎ라까( 힌트: 생성자 벡터 방식이 아닌 ttable mdel방식
				// TableModel인 my~이 보유한 ㅔㅂㄱ터에 다ㅣㅁ기
				// rs도 일종의 배열이므로 index로 컬럼을 접근할 수 잇다. 1부터시작
				// 1부터 몇까지 컬럼이 존재하는지 알 수 없다.
				// rs.getString(1);
				// 이럴땐 테이블에 대한 메타정보를 가져오자
				for (int i = 1; i <= meta.getColumnCount(); i++) {
					vec.add(rs.getString(i));// 데이터채우기
				}
				record.add(vec);// MyTableModel 보유한 벡터에 추가
			}
			// 데이터를 담은 이차원 벡터와 컬럼을 담은 일차원 벡터를 새로운 모델객체를 생성하면서 전달
			model = new MyTableModel(record, column);
			t_record.setModel(model);// 테이블에 모델을 생성자가 아닌 메서드로 적용하자
			getColumnType(meta);//메타 전달
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 자원닫기
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

	}
	//유저가 선택한 테이블의 구조 정보 가져오기
	public void getColumnType(ResultSetMetaData meta) {
		try {
			int total=meta.getColumnCount();//총 컬럼 수
			//멤버변수로 선언된 벡터에 버튼을 누를때마다 계속 누적이 되므로
			//아래의 for문이 수행되기 전에 먼저 비워놓고 채우자
			columnList.removeAll(columnList);
			
			for(int i=1;i<=total;i++) {
				System.out.println("컬럼명"+meta.getColumnName(i)+"("+meta.getColumnTypeName(i)+")");
				Vector vec=new  Vector();
				vec.add(meta.getColumnName(i));
				vec.add(meta.getColumnTypeName(i));
				
				columnList.add(vec);
			}
			t_colname.updateUI();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 로그인
	public void login() {
		// 현재 유지되고 있는 접속 객체인 Connection을 끊고, 다른 유저로 접속시도
		disConnect();// 접속끊기

		user = ch_users.getSelectedItem();// 현재 초이스 컴포넌트에 선택 된 아이템 값
		password = new String(t_pass.getPassword());// 비밀번호 설정

		connect();// 접속하기(하지만 멤버변수가 현재 system으로 되어 있으므로 멤버변수를 초이스 값으로 교체 해야함
		getTableList();// 이 시점에 로그인 하자마자 테이블 정보를 주자
		getSeList();
		System.out.println("보유한 테이블" + tableList.size());
	}

	// 오라클에 접속끊기
	public void disConnect() {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new DBMSClientApp2();

	}

}
