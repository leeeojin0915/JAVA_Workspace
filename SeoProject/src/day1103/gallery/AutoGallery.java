package day1103.gallery;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import common.image.ImageUtil;

public class AutoGallery extends JFrame{
	JPanel can;
	JButton bt_prev,bt_pause,bt_auto,bt_next;
	//os의 종속된 경로로 가져올때는 Toolkit을 이용한다
	Toolkit kit;
	Image[] img=new Image[10]; //공간
	int index=0;//사진 배열의 인덱스
	Thread thread;//자동사진넘기기용스레드
	boolean flag=false;
	
	public AutoGallery() {
		kit=Toolkit.getDefaultToolkit();
		for(int i=0;i<img.length;i++) {
			img[i]=ImageUtil.getCustomSize(kit.getImage("D:/koreaIT/Workspace/java_workspace/SeoProject/sre/bts/"+(i+1)+".jpg"), 680, 550);
		}
		can=new JPanel() {
			public void paint(Graphics g) {
				g.drawImage(img[index], 0, 0, this);
			}
		};
		bt_prev=new JButton(ImageUtil.getIcon(this.getClass(), "res/prev.png",100,35));
		bt_pause=new JButton(ImageUtil.getIcon(this.getClass(), "res/pause.png",100,35));
		bt_auto=new JButton(ImageUtil.getIcon(this.getClass(), "res/auto.png",100,35));
		bt_next=new JButton(ImageUtil.getIcon(this.getClass(), "res/next.png",100,35));
		
		//스타일
		can.setPreferredSize(new Dimension(680, 550));
		can.setBackground(Color.BLUE);
		bt_prev.setPreferredSize(new Dimension(100, 35));
		bt_pause.setPreferredSize(new Dimension(100, 35));
		bt_auto.setPreferredSize(new Dimension(100, 35));
		bt_next.setPreferredSize(new Dimension(100, 35));
		
		thread=new Thread() {
			public void run() {
				while(true) {
					if(flag) {
						next();											
					}
					try {
						thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		thread.start();
		
		setLayout(new FlowLayout());
		add(can);
		add(bt_prev);
		add(bt_pause);
		add(bt_auto);
		add(bt_next);
		
		//버튼과 리스너 연결
		bt_prev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				index--;
				can.repaint();
			}
		});
		bt_pause.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				flag=false;
			}
		});
		bt_auto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				flag=true;
			}
		});
		bt_next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				next();
			}
		});
		
		setVisible(true);
		setSize(700,650);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	//다음 사진 나오게
	public void next() {
		index++;
		can.repaint();
	}
	public static void main(String[] args) {
		new AutoGallery();
	}

}
