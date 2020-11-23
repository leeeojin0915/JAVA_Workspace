package com.swingmall.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.swingmall.board.QnA;
import com.swingmall.cart.Cart;
import com.swingmall.home.Home;
import com.swingmall.member.Login;
import com.swingmall.member.MyPage;
import com.swingmall.member.RegistForm;
import com.swingmall.product.Product;
import com.swingmall.product.ProductDetail;
import com.swingmall.util.db.DBManager;

public class ShopMain extends JFrame {
	// 상수선언
	public static final int WIDTH = 1200;
	public static final int HEIGHT = 900;
	// 최상위
	public static final int HOME = 0;
	public static final int PRODUCT = 1;
	public static final int QNA = 2;
	public static final int MYPAGE = 3;
	public static final int LOGIN = 4;
	public static final int PRODUCT_DETAIL = 5;
	public static final int MEMBER_REGIST=6;
	public static final int CART=7;
	
	// 하위페이지

	JPanel user_container;// 관리자,사용자 화면을 구분지을 수 있는 컨테이너
	JPanel p_content;// 여기에 모든 페이지가 미리 붙어져 잇을것임
	// 추후 showPage메서드로 보일지여부 설정
	JPanel p_navi;// 웹사이즈의 주 메뉴를 포함 할 컨테이너 패널
	String[] navi_title = { "Home", "Product", "QnA", "Mypage", "Login" };
	public JButton[] navi = new JButton[navi_title.length];// [][][][][]배열생성

	// 페이지 구성
	private Page[] page = new Page[8];// 최상위페이지들

	JLabel la_footer;// 윈도우 하 단의 카피라이트 영역
	private DBManager dbManager;
	private Connection con;
	
	//로그인 상태인지 알 수 있는 여부
	private boolean hasSession=false;

	public ShopMain() {
		dbManager = new DBManager();
		user_container = new JPanel();
		p_content = new JPanel();
		p_navi = new JPanel();
		la_footer = new JLabel("SwingMall All rights reserved", SwingConstants.CENTER);// 가운데 정렬

		con = dbManager.connect();
		if (con == null) {
			JOptionPane.showMessageDialog(this, "데이터베이스에 접속 할 수 없습니다.");
			System.exit(0);
		} else {
			this.setTitle("SwingShop에 오신 것을 환영합니다.");
		}

		// 메인메뉴 생성
		for (int i = 0; i < navi.length; i++) {
			navi[i] = new JButton(navi_title[i]);
			p_navi.add(navi[i]);// 패널에 메뉴 부착
		}

		// 페이지 구성
		page[0] = new Home(this);
		page[1] = new Product(this);
		page[2] = new QnA(this);
		page[3] = new MyPage(this);
		page[4] = new Login(this);
		page[5] = new ProductDetail(this);
		page[6] = new RegistForm(this);
		page[7] = new Cart(this);//장바구니

		// 스타일 적용
		user_container.setPreferredSize(new Dimension(WIDTH, HEIGHT - 50));
		user_container.setBackground(Color.WHITE);
		la_footer.setPreferredSize(new Dimension(WIDTH, 50));
		la_footer.setFont(new Font("Arial Black", Font.BOLD, 19));

		// 조립
		user_container.setLayout(new BorderLayout());
		user_container.add(p_navi, BorderLayout.NORTH);
		// user_container.add(page[this.LOGIN]);// 센터에 페이지 부착
		for (int i = 0; i < page.length; i++) {
			p_content.add(page[i]);
		}

		user_container.add(p_content);// 센터에 페이지 부착
		this.add(user_container);
		this.add(la_footer, BorderLayout.SOUTH);

		setSize(WIDTH, HEIGHT);
		setVisible(true);
		setLocationRelativeTo(null);

		// 프레임과 리스너 연결
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dbManager.disConnect(con);
				System.exit(0);
			}
		});

		// 메뉴 버튼과 리스너 연결
		for (int i = 0; i < navi.length; i++) {
			navi[i].addActionListener((e) -> {
				Object obj = e.getSource();
				if (obj == navi[0]) {
					showPage(HOME);
				} else if (obj == navi[1]) {
					showPage(PRODUCT);
				} else if (obj == navi[2]) {
					showPage(QNA);
				} else if (obj == navi[3]) {
					//mypage는 무조건 보여줘서는 안되고 로그인한 사람에게만 보여줘야함
					//로그인상태가 아니라면 욕
					if(hasSession==true) {
						showPage(MYPAGE);						
					}else {
						JOptionPane.showMessageDialog(ShopMain.this, "로그인이 필요합니다.");
					}
					
				} else if (obj == navi[4]) {
					//로그인을 요청할 지,로그아웃을 요청할 지를 구분
					//hasSession의 값이 true 일 때는 로그인 한 상태이므로 로그아웃을 요청해야함
					if(hasSession) {
						int ans=JOptionPane.showConfirmDialog(ShopMain.this, "로그아웃 하시겠습니까?");
						if(ans==JOptionPane.OK_OPTION) {//예
							Login loginPage=(Login)page[ShopMain.LOGIN];
							loginPage.logout();
						}
					}else {
						showPage(LOGIN);//로그인						
					}
				}
			});
		}
	}

	// 보여질 페이지와 안보여질 페이지
	public void showPage(int showIndex) {// 매개변수로 보여주고 싶은 페이지 넘버
		for (int i = 0; i < page.length; i++) {
			if (i == showIndex) {
				page[i].setVisible(true);
			} else {
				page[i].setVisible(false);
			}
		}
	}

	// 보여질 컨텐트와 가려질 컨텐트
	public void addRemoveContent(Component removeObj, Component addObj) {
		this.remove(removeObj);// 제거
		this.add(addObj);// 부착
		((JPanel) addObj).updateUI();
	}

	public DBManager getDbManager() {
		return dbManager;
	}

	public Connection getCon() {
		return con;
	}

	public Page[] getPage() {
		return page;
	}

	
	public boolean isHasSession() {
		return hasSession;
	}

	public void setHasSession(boolean hasSession) {
		this.hasSession = hasSession;
	}

	public static void main(String[] args) {
		new ShopMain();
	}

}
