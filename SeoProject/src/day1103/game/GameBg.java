package day1103.game;

import java.awt.Graphics2D;
import java.awt.Image;

public class GameBg extends GameObject {

	public GameBg(Image img, int x, int y, int width, int height, int velX, int velY) {
		super(img, x, y, width, height, velX, velY);
	}

	public void tick() {
		this.x += this.velX;
		if (this.x <= -GamePanel.WIDTH) {
			this.x = GamePanel.WIDTH;
		}
	}

	public void render(Graphics2D g2) {
		g2.drawImage(img, x, y, null);// 배경
		// g2.drawImage(img, GamePanel.WIDTH, 0, null);//배경
	}

}
