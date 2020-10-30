package day1029.collection;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ButtonCollection extends JFrame implements ActionListener{
	JPanel p_north,p_center;
	JButton bt_create,bt_bg;
	
	//배열은 크기를 정해야 하기 때문에 크기를 알 수 없는 프로그램에서는 사용제한이 생긴다.
	//JButton[] btn=new JButton[];//배열의 가장 큰 특징 : 배열은 생성시 크기를 명시해야 한다.
	ArrayList<JButton> btn=new ArrayList<JButton>();//현재는 크기가 0
	public ButtonCollection() {
		p_north=new JPanel();
		p_center=new JPanel();
		bt_create=new JButton("생성");
		bt_bg=new JButton("배경색");
		
		p_north.add(bt_create);
		p_north.add(bt_bg);
		
		//프레임에 부착
		add(p_north,BorderLayout.NORTH);
		add(p_center);
		
		//버튼과 리스너 연결
		bt_create.addActionListener(this);
		bt_bg.addActionListener(this);
		
		setSize(500,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		if(obj==bt_create) {
			create();
		}else if(obj==bt_bg) {
			setBg();
		}
	}
	
	public void create() {
		//버튼생성하여 p_center부착
		JButton bt=new CustomButton();
		p_center.add(bt);
		
		btn.add(bt);//리스트에 추가하기 js의 push()메서드와 같다
		System.out.println("현재까지 누적된 리스트의 수는"+btn.size());
		bt.setText("버튼"+Integer.toString(btn.size()));//정수+string=string
		
		//p_center에 버튼을 그린게 아니라 버튼을 추가한 것
		//따라서 이때는 p_center를 갱신하면 된다===>updateUI()
		p_center.updateUI();
				
	}
	public void setBg(){
		//btn 리스트에 들어있는 모든 요소를 대상으로 배경색 바꾸기
		//ArrayList는 순서있는 집합이므로, for문을 사용 할 수 있다
		for(int i=0;i<btn.size();i++) {
			JButton bt=btn.get(i);//리스트에서 꺼내기
			bt.setBackground(Color.YELLOW);
		}
		
		
		
		
	}
	public static void main(String[] args){
		new ButtonCollection();

	}

}
