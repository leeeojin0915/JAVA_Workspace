package day1029.graphic.image;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ImagePickerApp extends JFrame{
	String dir="D:/workspace/java_workspace/SeProject/res/travel2/";
	String[] path= {
			"aa.jpg","ab.jpg","ax.jpg","bm.jpg","et.jpg","kg.jpg","mx.jpg"
	}; 
	JPanel p_north;
	DetailPanel p_center;
	ThumbCanvas[] thumb = new ThumbCanvas[path.length];//[][][][][][][]
	
	public ImagePickerApp() {
		p_north = new JPanel();
		p_center = new DetailPanel();
		
		//켄버스 생성 및 조립
		for(int i=0;i<thumb.length;i++) {
			thumb[i] = new ThumbCanvas(dir+path[i], p_center);
			p_north.add(thumb[i]); //켄버스를  패널에 부착!
		}
		//패널을 프레임에 부착 
		add(p_north, BorderLayout.NORTH);
		add(p_center);
		
		setSize(770,600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new ImagePickerApp();
	}

}
