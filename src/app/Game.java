package app;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import javax.swing.Timer;

@SuppressWarnings("serial")
public class Game extends JPanel implements KeyListener, ActionListener, MouseListener {

	public static enum STATE {
		MENU, GAME, CONTROLS
	}

	public static STATE state = STATE.MENU;

	Hi hi = new Hi(this);
	DM dm = new DM(this);
	Flagged flagged = new Flagged(this);

	private Timer timer = new Timer(10, this);

	private int score = 0;
	private int badScore = 0;

	private Menu menu;
	private Controls controls;

	private File sound;

	@Override
	public void paint(Graphics g) {
		if (state == STATE.MENU) {
			menu = new Menu();
			menu.paint(g);

		} else if (state == STATE.CONTROLS) {
			controls = new Controls();
			controls.paint(g);
		} else if (state == STATE.GAME) {
			Graphics2D g2d = (Graphics2D) g;
			super.paint(g2d);
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2d.setColor(Color.BLUE);
			g2d.fillRect(20, 20, 460, 100);
			g2d.drawRect(20, 140, 460, 600);
			g2d.setColor(Color.white);
			g2d.setFont(new Font("arial", Font.BOLD, 20));
			g2d.drawString("How Well Can You Slide Into Those DMs?", 50, 50);

			if (Collision()) {
				sound = new File("Pop.wav");
				this.PlaySound(sound);

				score++;
			}
			if (badCollision()) {
				badScore++;
				sound = new File("Error.wav");
				this.PlaySound(sound);
			}

			hi.paint(g2d);
			dm.paint(g2d);
			dm.move();
			flagged.paint(g2d);
			flagged.move();

			g2d.setColor(Color.white);
			g2d.setFont(new Font("arial", Font.BOLD, 15));
			g2d.drawString("DMs Sent: " + score, 360, 80);

			g2d.setColor(Color.white);
			g2d.setFont(new Font("arial", Font.BOLD, 15));
			g2d.drawString("Flagged: " + badScore, 360, 100);

			g2d.dispose();
		}
	}

	public void PlaySound(File Sound) {
		try {
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(Sound));
			clip.start();

			// Thread.sleep(clip.getMicrosecondLength() / 1000);
			// we divide by a thousand because Thread.sleep() takes
			// milliseconds as parameter unit.
		} catch (Exception e) {

		}
	}

	public Game() {
		System.out.println("Hi there! Welcome to my very first game, DM Slider. Hope you have fun!");
		this.addMouseListener(this);
		this.addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer.start();
	}

	public void actionPerformed(ActionEvent e) {

		repaint();
		if (badScore == 5) {
			timer.stop();
			sound = new File("Bruh.wav");
			PlaySound(sound);
			JOptionPane.showMessageDialog(this,
					"Congrats! You have slid into: " + getScore() + " DMs"
							+ "\nClick OK then \nSPACE to RESTART \nESC to EXIT",
					"Bruh...", JOptionPane.DEFAULT_OPTION);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void keyPressed(KeyEvent e) {
		hi.keyPressed(e);
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			System.exit(ABORT);
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			timer.start();
			score = 0;
			badScore = 0;
		}
		if ((e.getKeyCode() == KeyEvent.VK_B) && (state == STATE.CONTROLS || state == STATE.GAME)) {
			score = 0;
			badScore = 0;
			Game.state = Game.STATE.MENU;
			// repaint();

		}
	}

	public boolean Collision() {
		if (this.hi.getBounds().intersects(dm.getBounds())) {
			return true;
		}
		return false;
	}

	public boolean badCollision() {
		if (this.hi.getBounds().intersects(flagged.getBounds())) {
			return true;
		}
		return false;
	}

	public int getScore() {
		return score;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (Game.state == Game.STATE.MENU) {
			int mx = e.getX();
			int my = e.getY();
			// g2d.drawRect(200, 300, 100, 50);
			if (mx >= 200 && mx <= 300) {
				if (my >= 300 && my <= 350) {
					// Pressed Play Button
					sound = new File("Menu move.wav");
					PlaySound(sound);
					Game.state = Game.STATE.GAME;

				}
			} // g2d.drawRect(200, 400, 100, 50)
			if (mx >= 200 && mx <= 300) {
				if (my >= 400 && my <= 450) {
					// Pressed Controls Button
					sound = new File("Menu move.wav");
					PlaySound(sound);
					Game.state = Game.STATE.CONTROLS;

				}
			}
			if (mx >= 200 && mx <= 300) {
				if (my >= 500 && my <= 550) {
					sound = new File("Menu move.wav");
					PlaySound(sound);
					System.exit(ABORT);
				}
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
