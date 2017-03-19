package app;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Controls extends JPanel {

	private int ypos = 100;

	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.BLUE);
		g2d.fillRect(20, 20, 460, 720);

		g2d.setFont(new Font("arial", Font.BOLD, 20));
		g2d.setColor(Color.WHITE);

		g2d.drawString("W: MOVE UP", 100, ypos);
		g2d.drawString("X: MOVE DOWN", 100, ypos + 30);
		g2d.drawString("D: MOVE RIGHT", 100, ypos + 60);
		g2d.drawString("A: MOVE LEFT", 100, ypos + 90);
		g2d.drawString("Q: MOVE UP and LEFT", 100, ypos + 120);
		g2d.drawString("E: MOVE UP and RIGHT", 100, ypos + 150);
		g2d.drawString("Z: MOVE DOWN AND LEFT", 100, ypos + 180);
		g2d.drawString("C: MOVE DOWN AND RIGHT", 100, ypos + 210);
		g2d.drawString("ESC: EXIT ", 100, ypos + 240);
		g2d.drawString("SPACE: RESTART", 100, ypos + 270);
		g2d.drawString("B: BACK", 100, ypos + 300);

	}
}
