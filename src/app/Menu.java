package app;

import javax.swing.ImageIcon;

//author: Jong Seob (Joseph) Son

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Menu extends JPanel {

	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.WHITE);
		g2d.fillRect(0, 0, 500, 800);

		g2d.setColor(Color.BLUE);

//		ImageIcon picture = new ImageIcon("Christmas Picture.jpg");
//		picture.paintIcon(this, g, 0, 0);

		// Title
		g2d.setFont(new Font("arial", Font.BOLD, 60));
		g2d.drawString("DM SLIDER", 90, 100);
		g2d.setFont(new Font("arial", Font.BOLD, 20));
		g2d.drawString("Slide into as many DMs as you can.", 90, 170);
		g2d.drawString("If you are flagged 5 times then game over!", 50, 200);

		// Play button
		g2d.setFont(new Font("arial", Font.BOLD, 20));
		g2d.fillRect(200, 300, 100, 50);
		g2d.setColor(Color.WHITE);
		g2d.drawString("PLAY", 225, 333);

		// Help button
		g2d.setColor(Color.BLUE);
		g2d.fillRect(200, 400, 100, 50);
		g2d.setFont(new Font("arial", Font.BOLD, 17));
		g2d.setColor(Color.WHITE);
		g2d.drawString("CONTROLS", 204, 433);

		// Exit button
		g2d.setColor(Color.BLUE);
		g2d.fillRect(200, 500, 100, 50);
		g2d.setFont(new Font("arial", Font.BOLD, 20));
		g2d.setColor(Color.WHITE);
		g2d.drawString("EXIT", 225, 533);

	}
}
