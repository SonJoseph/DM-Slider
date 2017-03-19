package app;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.util.Random;
import javax.swing.ImageIcon;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Flagged extends JPanel {

	private Game game;
	private Hi hi;

	private ImageIcon Flagged;
	private Random random = new Random();

	private int xpos = 400;
	private int ypos = 700;

	private int dx = 1;
	private int dy = 1;

	public Rectangle getBounds() {
		return new Rectangle(xpos, ypos, 26, 25);
	}

	public Flagged(Game game) {
		this.game = game;
	}

	@Override
	public void paint(Graphics g) {

		int[] allxDM = new int[] { 25, 200, 440 };
		int[] allyDM = new int[] { 150, 420, 710 };
		int xDM = random.nextInt(3);
		int yDM = random.nextInt(3);
		if (game.badCollision()) {
			xpos = allxDM[xDM];
			ypos = allyDM[yDM];
			Flagged = new ImageIcon("Flagged.png");
			Flagged.paintIcon(this, g, xpos, ypos);
		} else {
			Flagged = new ImageIcon("Flagged.png");
			Flagged.paintIcon(this, g, xpos, ypos);
		}
	}

	public void move() {
		if (game.getScore() >= 20) {

			if (xpos + dx > 441) {
				dx = -5;
			}
			if (xpos + dx < 20) {
				dx = 5;
			}
			if (ypos + dy > 707) {
				dy = -5;
			}
			if (ypos + dy < 140) {
				dy = 5;
			}

			xpos = xpos + dx;
			ypos = ypos + dy;
		} else if (game.getScore() >= 15) {

			if (xpos + dx > 441) {
				dx = -4;
			}
			if (xpos + dx < 20) {
				dx = 4;
			}
			if (ypos + dy > 707) {
				dy = -4;
			}
			if (ypos + dy < 140) {
				dy = 4;
			}

			xpos = xpos + dx;
			ypos = ypos + dy;
		} else if (game.getScore() >= 10) {

			if (xpos + dx > 441) {
				dx = -3;
			}
			if (xpos + dx < 20) {
				dx = 3;
			}
			if (ypos + dy > 707) {
				dy = -3;
			}
			if (ypos + dy < 140) {
				dy = 3;
			}

			xpos = xpos + dx;
			ypos = ypos + dy;
		} else if (game.getScore() >= 5) {

			if (xpos + dx > 450) {
				dx = -2;
			}
			if (xpos + dx < 20) {
				dx = 2;
			}
			if (ypos + dy > 710) {
				dy = -2;
			}
			if (ypos + dy < 140) {
				dy = 2;
			}

			xpos = xpos + dx;
			ypos = ypos + dy;
		} else {
			if (xpos + dx > 441) {
				dx = -1;
			}
			if (xpos + dx < 20) {
				dx = 1;
			}
			if (ypos + dy > 710) {
				dy = -1;
			}
			if (ypos + dy < 140) {
				dy = 1;
			}
			xpos = xpos + dx;
			ypos = ypos + dy;

		}

	}
}
