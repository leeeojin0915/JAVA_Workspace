package day1030.memo;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class memo extends JFrame implements ActionListener {
	JLabel j_ori, j_copy;
	JTextField t_ori, t_copy;
	JButton bt_com;

	public memo() {
		// 생성
		j_ori = new JLabel("원본");
		j_copy = new JLabel("복사본");
		bt_com = new JButton("COPY");
		t_ori = new JTextField(50);
		t_copy = new JTextField(50);

		// 스타일
		j_ori.setPreferredSize(new Dimension(150, 30));
		j_copy.setPreferredSize(new Dimension(150, 30));
		t_ori.setPreferredSize(new Dimension(500, 30));
		t_copy.setPreferredSize(new Dimension(500, 30));

		// 조립
		setLayout(new FlowLayout());// 프레임의 레이아웃 변경
		this.add(j_ori);
		this.add(t_ori);
		this.add(j_copy);
		this.add(t_copy);
		this.add(bt_com);

		// 연결
		bt_com.addActionListener(this);
		//파일열기
		JFileChooser chooser= new JFileChooser();
		chooser.showOpenDialog(this);
		
		setSize(750, 180);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// 하면 안됌 스트림을 닫을 기회가 없기 때문
		// 해결책)윈도우창을 닫을때, 이벤트를 구현 즉, widdowListener구현

	}

	public void copy() {
		//두 개의 클래스가 메모리에 올라와야 하는 시점은?
		//메서드 내의 지역변수는 반드시 개발자가 초기화해야 한다..멤버 변수가 아니므로
		FileInputStream fis=null;
		FileOutputStream fos=null;
		
		String ori=t_ori.getText();//원본경로
		String copy=t_copy.getText();//복사본경로
		
		try {
			fis=new FileInputStream(ori); //입력스트림 생성
			fos=new FileOutputStream(copy);//출력 스트림 생성
			
			//읽고내뱉자
			int data;//읽혀진 데이터를 받을 변수
			while(true) {
				data=fis.read();
				if(data==-1)break;
				fos.write(data);
			}
			JOptionPane.showMessageDialog(this, "복사완료");
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		copy();
	}

	public static void main(String[] args) {
		new memo();
	}

}
