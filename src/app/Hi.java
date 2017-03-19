package app;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Hi extends JPanel {
	private ImageIcon hi;

	private int xHi = 218;
	private int yHi = 415;

	private int speed = 5;

	public Rectangle getBounds() {
		return new Rectangle(xHi, yHi, 64, 50);
	}

	private Game game;

	public Hi(Game game) {
		this.game = game;
	}

	@Override
	public void paint(Graphics g) {
		hi = new ImageIcon("hi message.png");
		hi.paintIcon(this, g, xHi, yHi);
		if (game.getScore() >= 30) {
			speed = 15;
		} else if (game.getScore() >= 20) {
			speed = 10;
		} else if (game.getScore() >= 10) {
			speed = 7;
		}
	}

	public void keyPressed(KeyEvent e) {
		// up
		if ((e.getKeyCode() == KeyEvent.VK_W) && yHi >= 145) {
			yHi = yHi - speed;
		}

		// up and right
		if ((e.getKeyCode() == KeyEvent.VK_E) && yHi >= 145 && xHi <= 411) {
			yHi = yHi - speed;
			xHi = xHi + speed;
		}

		// up and left
		if ((e.getKeyCode() == KeyEvent.VK_Q) && xHi >= 25 && yHi >= 145) {
			xHi = xHi - speed;
			yHi = yHi - speed;
		}

		// down
		if ((e.getKeyCode() == KeyEvent.VK_S) && yHi <= 685) {
			yHi = yHi + speed;
		}

		// down #2
		if ((e.getKeyCode() == KeyEvent.VK_X) && yHi <= 685) {
			yHi = yHi + speed;
		}

		// down and right
		if ((e.getKeyCode() == KeyEvent.VK_C) && yHi <= 685 && xHi <= 411) {
			yHi = yHi + speed;
			xHi = xHi + speed;
		}

		// down and left
		if ((e.getKeyCode() == KeyEvent.VK_Z) && xHi >= 25 && yHi <= 685) {
			yHi = yHi + speed;
			xHi = xHi - speed;
		}

		// right
		if ((e.getKeyCode() == KeyEvent.VK_D) && xHi <= 411) {
			xHi = xHi + speed;
		}

		// left
		if ((e.getKeyCode() == KeyEvent.VK_A) && xHi >= 25) {
			xHi = xHi - speed;
		}

	}

}
