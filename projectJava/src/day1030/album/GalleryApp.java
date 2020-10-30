package day1030.album;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class GalleryApp extends JFrame implements ActionListener {
	JPanel p_west, p_center, p_south;
	JScrollPane scroll;
	JLabel la_name;// 제목 나올 라벨
	XCanvas can; // 센터에 크게 나올 이미지를 그릴 캔버스
	JButton bt_prev, bt_next;
	

	ArrayList<Thumb> list = new ArrayList<Thumb>();// 썸네일 배열[][]][][][][][][] null
	String dir = "D:/SeProject/res/bts/";
	String[] src = { "1.jpg", "2.jpg", "3.jpg", "4.jpg", "5.jpg", "6.jpg", "7.jpg", "8.jpg", "9.jpg", "10.jpg" };
	int n = 0;// 배열의 index

	public GalleryApp() {
		super("자바 갤러리");
		// 생성
		p_west = new JPanel();
		p_center = new JPanel();
		scroll = new JScrollPane(p_west);
		la_name = new JLabel(src[n]+"("+(n+1)+"/"+src.length+")", SwingConstants.CENTER);
		can = new XCanvas(dir + src[n]);
		p_south = new JPanel();
		bt_prev = new JButton("◀");
		bt_next = new JButton("▶");

		// 썸네일 생성
		for (int i = 0; i < src.length; i++) {
			Thumb thumb = null;
			list.add(thumb = new Thumb(dir + src[i],this));// thumb에 넘겨줘야함
			p_west.add(thumb);
		}

		// 디자인
		la_name.setPreferredSize(new Dimension(700, 50));
		la_name.setBackground(Color.RED);
		la_name.setFont(new Font("Verdana", Font.BOLD, 25));
		p_west.setPreferredSize(new Dimension(100, 600));
		p_center.setPreferredSize(new Dimension(700, 600));
		p_west.setBackground(Color.YELLOW);
		// p_center.setBackground(Color.GREEN);

		// 조립
		p_south.add(bt_prev);
		p_south.add(bt_next);
		p_center.add(la_name);
		p_center.add(can);
		p_center.add(p_south);

		add(scroll, BorderLayout.WEST);// scroll안에 west를 넣었으니 scroll을 넣어줘야함
		add(p_center);

		bt_prev.addActionListener(this);// 버튼과 리스너 연결
		bt_next.addActionListener(this);

		setVisible(true);
		setSize(800, 600);
		// 윈도우를 화면 중앙에 띄우는 법
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//updateData();
	}

	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();// 이벤트 일으킨 컴포넌트
		if (obj == bt_prev) {
			prev();
		} else if (obj == bt_next) {
			next();
		}
		updateData();

	}

	public void updateData() {
		// 그림은 XCanvas가 담당하므로 그려질 img를 변경시켜주고 다시 그리라고 하면 됨
		can.setSrc(dir + src[n]);
		can.repaint(); // update()->paint()
		la_name.setText(src[n]+"("+(n+1)+"/"+src.length+")");// 제목 변경
	}

	public void prev() {
		if(n>0) {
			n--;
		}else {
			JOptionPane.showMessageDialog(this, "이전 이미지가 없습니다.");
		}
	}
	public void next() {
		//배열을 넘어서지 않는 범위내에서 ++허용
		if(n<src.length-1) {
			n++;
		}else {
			JOptionPane.showMessageDialog(this, "마지막 이미지 입니다.");
		}
		//넘어서면 경고
	}

	public static void main(String[] args) {
		new GalleryApp();
	}

}
