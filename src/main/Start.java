package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Start {

	private JFrame frmFourInLine;

	/**
	 * Launch the application.
	 */
	public static void mainMenu() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start window = new Start();
					window.frmFourInLine.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Start() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmFourInLine = new JFrame();
		frmFourInLine.setResizable(false);
		frmFourInLine.setTitle("Four In Line");
		frmFourInLine.setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\workspace\\FourInLine\\src\\pic\\Untitled-2.png"));
		frmFourInLine.getContentPane().setBackground(Color.WHITE);
		frmFourInLine.setBounds(100, 100, 1280, 720);
		frmFourInLine.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFourInLine.getContentPane().setLayout(null);
		
		JButton start = new JButton("");
		start.setIcon(new ImageIcon("D:\\workspace\\FourInLine\\src\\pic\\startgame.png"));
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frmFourInLine.setVisible(false);
				Game.gameFrame();
			}
		});
		start.setForeground(SystemColor.activeCaptionBorder);
		start.setBackground(SystemColor.activeCaption);
		start.setBounds(540, 320, 200, 75);
		frmFourInLine.getContentPane().add(start);
		
		JButton how = new JButton("");
		how.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmFourInLine.setVisible(false);
				HowToPlay.howToPlay();
			}
		});
		how.setIcon(new ImageIcon("D:\\workspace\\FourInLine\\src\\pic\\howtoplay.png"));
		how.setBounds(540, 415, 200, 75);
		frmFourInLine.getContentPane().add(how);
		
		JButton exit = new JButton("");
		exit.setIcon(new ImageIcon("D:\\workspace\\FourInLine\\src\\pic\\exit1.png"));
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(1);
			}
		});
		exit.setBounds(540, 510, 200, 75);
		frmFourInLine.getContentPane().add(exit);
		
		JLabel background = new JLabel("New label");
		background.setIcon(new ImageIcon("D:\\workspace\\FourInLine\\src\\pic\\StartMenu.png"));
		background.setBounds(0, 0, 1274, 685);
		frmFourInLine.getContentPane().add(background);
	}
}
