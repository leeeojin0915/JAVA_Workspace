package day1111.board;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class BoardWrite extends JPanel {
	JTextField t_title, t_writer;
	JTextArea content;
	JScrollPane scroll;

	JButton bt_regist;
	JButton bt_list;

	BoardApp boardApp;
	BoardList boardList;
	Connection con;

	public BoardWrite(BoardApp boardApp) {
		this.boardApp = boardApp;
		con = boardApp.getCon();

		t_title = new JTextField();
		t_writer = new JTextField();
		content = new JTextArea();
		scroll = new JScrollPane(content);
		bt_regist = new JButton("등록");
		bt_list = new JButton("목록");

		// 스타일
		t_title.setPreferredSize(new Dimension(780, 35));
		t_writer.setPreferredSize(new Dimension(780, 35));
		scroll.setPreferredSize(new Dimension(780, 200));

		// 조립
		add(t_title);
		add(t_writer);
		add(scroll);
		add(bt_regist);
		add(bt_list);

		setPreferredSize(new Dimension(780, 500));
		setVisible(true);
		// 목록으로가기
		bt_list.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				boardApp.setPage(BoardApp.BOARD_LIST);
			}
		});

		bt_regist.addActionListener((e) -> {
			regist();
			BoardList boardList=(BoardList)boardApp.getPages(BoardApp.BOARD_LIST);
			boardList.getList();//목록에서 메서드 호출
			
		});

	}
	
	//글 등록하기
	public void regist() {
		PreparedStatement pstmt = null;

		String sql = "insert into board(board_id,title,writer,content)";
		sql += " values(seq_board.nextval,?,?,?)";

		try {
			pstmt = con.prepareStatement(sql);// sql준비
			// 바인드변수지정
			pstmt.setString(1, t_title.getText());
			pstmt.setString(2, t_writer.getText());// BoardApp의 회원정보를 이용
			pstmt.setString(3, content.getText());

			int result = pstmt.executeUpdate();// 쿼리실행
			if (result == 0) {
				JOptionPane.showMessageDialog(this, "등록실패");
			} else {
				JOptionPane.showMessageDialog(this, "등록성공");
				boardApp.setPage(BoardApp.BOARD_LIST);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
