package app;

import javax.swing.JFrame;
import javax.swing.Timer;

import java.awt.Color;

public class Main {

	public static void main(String[] args) {
		Game game = new Game();
		JFrame frame = new JFrame();
		frame.add(game);

		frame.setBounds(10, 10, 500, 800);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setBackground(Color.WHITE);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
