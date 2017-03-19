package app;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.util.Random;
import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Rectangle;

public class DM extends JPanel {

	private Game game;
	private Hi hi;

	private ImageIcon DM;
	private Random random = new Random();

	private int xpos = 40;
	private int ypos = 160;

	private int dx = 1;
	private int dy = 1;

	public Rectangle getBounds() {
		return new Rectangle(xpos, ypos, 39, 33);
	}

	public DM(Game game) {
		this.game = game;
	}

	@Override
	public void paint(Graphics g) {
		int[] allxDM = new int[] { 40, 75, 110, 145, 180, 215, 250, 285, 320, 355, 390, 425 };
		int[] allyDM = new int[] { 160, 200, 240, 280, 320, 360, 400, 440, 480, 520, 560, 600, 640, 680 };
		int xDM = random.nextInt(12);
		int yDM = random.nextInt(14);
		if (game.Collision()) {
			xpos = allxDM[xDM];
			ypos = allyDM[yDM];
			DM = new ImageIcon("message icon.png");
			DM.paintIcon(this, g, xpos, ypos);
		} else {
			DM = new ImageIcon("message icon.png");
			DM.paintIcon(this, g, xpos, ypos);
		}
	}

	public void move() {
		if (xpos + dx > 441) {
			dx = -1;
		}
		if (xpos + dx < 20) {
			dx = 1;
		}
		if (ypos + dy > 707) {
			dy = -1;
		}
		if (ypos + dy < 140) {
			dy = 1;
		}
		xpos = xpos + dx;
		ypos = ypos + dy;
	}

}
