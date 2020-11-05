package day1103.game;

import java.awt.Graphics2D;
import java.awt.Image;

public class Block extends GameObject{

	public Block(Image img, int x, int y, int width, int height, int velX, int velY) {
		super(img, x, y, width, height, velX, velY);
	}

	public void tick() {
		rect.x=x;
		rect.y=y;
	}

	public void render(Graphics2D g2) {
		g2.drawRect(rect.x,rect.y, rect.width,rect.height);
		g2.drawImage(img, x, y, null);
	}
	

}
