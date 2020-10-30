package day1029.gallery;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class ThumbImage extends JPanel{
	Toolkit kit;
	Image img;

	
	public ThumbImage(String dir) {
		kit=Toolkit.getDefaultToolkit();
		//img=kit.getImage();
		
		this.setPreferredSize(new Dimension(100,100));
		
	}
	@Override
	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, this);
	}
}
