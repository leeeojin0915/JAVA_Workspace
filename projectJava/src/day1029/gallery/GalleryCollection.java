package day1029.gallery;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GalleryCollection extends JFrame{
	JLabel j_title;
	JButton bt_prev, bt_next;
	JPanel p_south,p_center;
	String dir="D:/SeProject/res/bts/";
	String[] thumb= {"1.jpg","2.jpg","3.jpg","4.jpg","5.jpg","6.jpg","7.jpg"};
	ThumbImage[] thumb_img=new ThumbImage[thumb.length];

	public GalleryCollection() {
		j_title=new JLabel("label");
		p_south=new JPanel();
		p_center=new JPanel();
		bt_prev=new JButton("◀");
		bt_next=new JButton("▶");
		
		for(int i=0;i<thumb_img.length;i++) {
			thumb_img[i]=new ThumbImage(dir+thumb[i]);
			
		}
		
		
		
		p_south.add(bt_prev);
		p_south.add(bt_next);
		
		add(p_south,BorderLayout.SOUTH);
		add(j_title,BorderLayout.NORTH);
		add(p_center);
		
		setSize(700, 400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new GalleryCollection();

	}

}
