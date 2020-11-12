package day1111.member;

import java.awt.Dimension;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import day1111.board.BoardApp;

public class LoginForm extends JPanel{
	JPanel p_container;
	JTextField t_id;
	JPasswordField t_pass;
	JButton bt_regist;
	JButton bt_login;
	
	BoardApp boardApp;
	Connection con;

	public LoginForm(BoardApp boardApp) {
		this.boardApp=boardApp;
		con=boardApp.getCon();
		
		p_container=new JPanel();
		t_id=new JTextField(30);
		t_pass=new JPasswordField(30);
		bt_regist=new JButton("회원가입");
		bt_login=new JButton("로그인");
		
		p_container.setPreferredSize(new Dimension(400,150));
		
		p_container.add(t_id);
		p_container.add(t_pass);
		p_container.add(bt_regist);
		p_container.add(bt_login);
		
		add(p_container);
		
		bt_regist.addActionListener((e)->{
			boardApp.setPage(BoardApp.MEMBER_REGIST);
		});
		
		//로그인 버튼과 리스너 연결
		bt_login.addActionListener((e)->{
			login();
		});
		setVisible(true);
	}
	/*
	 * 데이터베이스 연결을 모든 메서드마다 접속~끊기를 반복한다면 코드중복 문제가 발생 한다.
	 * 효율성이 없으므로 프로그램 가동과 동시에 한 번 접속해놓고 프로그램 종료할때 한 번에 접속 해제하는게 좋음
	 * 따라서 각 페이지에서 접속 해제 처리하지말고 최상위 컨테이너인 JFrame에섬 접속 및 해제 처리를 하자
	 * */
	public void login() {
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select * from board_member where m_id=? and m_pass=?";
		try {
			pstmt=con.prepareStatement(sql); //쿼리문 준비
			pstmt.setString(1, t_id.getText());
			pstmt.setString(2, new String(t_pass.getPassword()));
			
			rs=pstmt.executeQuery();//쿼리실행 select 문이므로 레코드를 담은 ResultSet이 반환된다.
			//로그인의 경우 제대로 된 인증이 될 경우 레코드를 언제나 몇 건이 나오는가 1건
			//rs가 반환된 시점부터는 rs의 커서를 내렸을때 레코드가 존재한다면 인증 성공으로 간주
			//없다면 로그인 실패
			if(rs.next()) {
				JOptionPane.showMessageDialog(this, "로그인성공");
				
				//로그인을 성공했을 때 회원정보를 보관+인증변수도 true
				boardApp.setHasSession(true);
				
				//회원정보 채워넣기
				BoardMember boardMember=new BoardMember();//empty
				boardMember.setMember_id(rs.getInt("member_id"));//id
				boardMember.setM_id(rs.getString("m_id"));//pk
				boardMember.setM_pass(rs.getString("m_pass"));//pass
				boardMember.setM_name(rs.getString("m_name"));//name
				boardMember.setRegdate(rs.getString("regdate"));//regdate
				
				//BoardApp가 보유한 회원정보 객체에 주소값 전달
				boardApp.setBoardMember(boardMember);
				
				//메인페이지로 보내기(게시판목록)
				boardApp.setPage(BoardApp.BOARD_LIST);
			}else {
				JOptionPane.showMessageDialog(this, "다시 로그인 해주세요");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if(pstmt!=null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
}
