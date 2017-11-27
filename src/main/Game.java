package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JTable;

public class Game {
	private JFrame frame;
	private static JLabel Showcoin1 , Showcoin2;
	private static JTextPane round , roundnum , player;
	private static JButton drop1 , drop2 , drop3 , drop4 , drop5 , drop6 , drop7 , restart , mainmenu;
	private static int[][] board = new int[7][6];
	private static int[] check = new int[7];
	private static int turn = 1;
	private static JLabel[][] coin = new JLabel[7][6];
	private static int win = 0;
	private static JLabel winpopup;
	private static int tie = 0;
	/**
	 * Launch the application.
	 */
	public static void gameFrame() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Game window = new Game();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Game() {
		initialize();
	}
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		resetArray(frame);
		
		mainmenu = new JButton("");
		mainmenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Start.mainMenu();
			}
		});
		mainmenu.setIcon(new ImageIcon("src/pic/exit.png"));
		mainmenu.setBounds(680, 400, 150, 75);
		frame.getContentPane().add(mainmenu);
		mainmenu.setVisible(false);
		
		restart = new JButton("");
		restart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				gameFrame();
			}
		});
		restart.setIcon(new ImageIcon("src/pic/restart.png"));
		restart.setBounds(450, 400, 150, 75);
		frame.getContentPane().add(restart);
		restart.setVisible(false);
		
		winpopup = new JLabel("");
		winpopup.setIcon(new ImageIcon("src/pic/player1.png"));
		winpopup.setBackground(Color.GRAY);
		winpopup.setBounds(390, 241, 500, 300);
		frame.getContentPane().add(winpopup);
		winpopup.setVisible(false);
		
		int d = 312;
		for(int a=0 ; a<=6 ; a++ ){
			int c = 150;
			for(int b=0 ; b<=5 ; b++){
				coin[a][b] = new JLabel("");
				coin[a][b].setBounds(d, c, 60, 60);
				frame.getContentPane().add(coin[a][b]);
				coin[a][b].setVisible(false);
				c += 80;
			}
			d+=100;
		}
		
		Showcoin1 = new JLabel("");
		Showcoin1.setIcon(new ImageIcon("src/pic/blue.png"));
		Showcoin1.setBounds(491, 20, 60, 60);
		frame.getContentPane().add(Showcoin1);
		
		Showcoin2 = new JLabel("");
		Showcoin2.setIcon(new ImageIcon("src/pic/blue.png"));
		Showcoin2.setBounds(732, 20, 60, 60);
		frame.getContentPane().add(Showcoin2);
		
		round = new JTextPane();
		round.setText("Round :");
		round.setOpaque(false);
		round.setForeground(Color.GRAY);
		round.setFont(new Font("Showcard Gothic", Font.BOLD, 31));
		round.setBounds(1027, 57, 117, 50);
		frame.getContentPane().add(round);
		
		roundnum = new JTextPane();
		roundnum.setText("1");
		roundnum.setOpaque(false);
		roundnum.setForeground(Color.GRAY);
		roundnum.setFont(new Font("Showcard Gothic", Font.BOLD, 31));
		roundnum.setBounds(1145, 57, 50, 50);
		frame.getContentPane().add(roundnum);
		
		player = new JTextPane();
		player.setForeground(Color.GRAY);
		player.setFont(new Font("Showcard Gothic", Font.BOLD, 31));
		player.setOpaque(false);
		player.setBounds(560, 20, 160, 50);
		frame.getContentPane().add(player);
		player.setText("Player 1");
		
		
		JButton back = new JButton("");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Start.mainMenu();
			}
		});
		back.setIcon(new ImageIcon("src/pic/back.png"));
		back.setBounds(20, 20, 50, 50);
		frame.getContentPane().add(back);
		
		JButton surrender = new JButton("");
		surrender.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(turn % 2 != 0){
					endGame(frame,9);
				}
				else if(turn % 2 == 0){
					endGame(frame,8);
				}
			}
		});
		surrender.setIcon(new ImageIcon("src/pic/surrender.png"));
		surrender.setBounds(20, 108, 180, 50);
		frame.getContentPane().add(surrender);
		
		drop1 = new JButton("");
		drop1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameStart(1,frame);
				check[0]++;
			}
		});
		
		drop1.setContentAreaFilled(false);
		drop1.setFocusPainted(false);
		drop1.setBorderPainted(false);
		drop1.setForeground(null);
		drop1.setIcon(new ImageIcon("src/pic/drop.png"));
		drop1.setBackground(SystemColor.window);
		drop1.setBounds(291, 85, 100, 50);
		frame.getContentPane().add(drop1);

		drop2 = new JButton("");
		drop2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameStart(2,frame);
				check[1]++;
			}
		});
		drop2.setContentAreaFilled(false);
		drop2.setFocusPainted(false);
		drop2.setBorderPainted(false);
		drop2.setForeground(null);
		drop2.setIcon(new ImageIcon("src/pic/drop.png"));
		drop2.setBackground(SystemColor.window);
		drop2.setBounds(391, 85, 100, 50);
		frame.getContentPane().add(drop2);
		
		drop3 = new JButton("");
		drop3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameStart(3,frame);
				check[2]++;
			}
		});
		drop3.setContentAreaFilled(false);
		drop3.setFocusPainted(false);
		drop3.setBorderPainted(false);
		drop3.setForeground(null);
		drop3.setIcon(new ImageIcon("src/pic/drop.png"));
		drop3.setBackground(SystemColor.window);
		drop3.setBounds(491, 85, 100, 50);
		frame.getContentPane().add(drop3);
		
		drop4 = new JButton("");
		drop4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameStart(4,frame);
				check[3]++;
			}
		});
		drop4.setContentAreaFilled(false);
		drop4.setFocusPainted(false);
		drop4.setBorderPainted(false);
		drop4.setForeground(null);
		drop4.setIcon(new ImageIcon("src/pic/drop.png"));
		drop4.setBackground(SystemColor.window);
		drop4.setBounds(591, 85, 100, 50);
		frame.getContentPane().add(drop4);
		
		drop5 = new JButton("");
		drop5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameStart(5,frame);
				check[4]++;
			}
		});
		drop5.setContentAreaFilled(false);
		drop5.setFocusPainted(false);
		drop5.setBorderPainted(false);
		drop5.setForeground(null);
		drop5.setIcon(new ImageIcon("src/pic/drop.png"));
		drop5.setBackground(SystemColor.window);
		drop5.setBounds(691, 85, 100, 50);
		frame.getContentPane().add(drop5);
		
		drop6 = new JButton("");
		drop6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameStart(6,frame);
				check[5]++;
			}
		});
		drop6.setContentAreaFilled(false);
		drop6.setFocusPainted(false);
		drop6.setBorderPainted(false);
		drop6.setForeground(null);
		drop6.setIcon(new ImageIcon("src/pic/drop.png"));
		drop6.setBackground(SystemColor.window);
		drop6.setBounds(791, 85, 100, 50);
		frame.getContentPane().add(drop6);
		
		drop7 = new JButton("");
		drop7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gameStart(7,frame);
				check[6]++;
			}
		});
		drop7.setContentAreaFilled(false);
		drop7.setFocusPainted(false);
		drop7.setBorderPainted(false);
		drop7.setForeground(null);
		drop7.setIcon(new ImageIcon("src/pic/drop.png"));
		drop7.setBackground(SystemColor.window);
		drop7.setBounds(891, 85, 100, 50);
		frame.getContentPane().add(drop7);
		
		JLabel board = new JLabel("New label");
		board.setIcon(new ImageIcon("src/pic/board2.png"));
		board.setBounds(240, 120, 800, 550);
		frame.getContentPane().add(board);
		
		JLabel background = new JLabel("New label");
		background.setIcon(new ImageIcon("src/pic/game.png"));
		background.setBounds(0, 0, 1274, 685);
		frame.getContentPane().add(background);
	}
	public static void turnBase1(){
		player.setText("Player 1");
		Showcoin2.setIcon(new ImageIcon("src/pic/blue.png"));
		Showcoin1.setIcon(new ImageIcon("src/pic/blue.png"));
	}
	public static void turnBase2(){
		player.setText("Player 2");
		Showcoin2.setIcon(new ImageIcon("src/pic/red.png"));
		Showcoin1.setIcon(new ImageIcon("src/pic/red.png"));
	}

	public static void gameStart(int btn,JFrame frame){
			if(turn % 2 != 0){
				int player = 1;
				buttonClick(player,btn,frame);
				turnBase2();
				turn++;
			}
			else if(turn % 2 == 0){
				int player = 2;
				buttonClick(player,btn,frame);
				turnBase1();
				turn++;
			}
			roundnum.setText(""+turn);
	}
	
	public static void buttonClick(int player,int btn,JFrame frame){
		for(int a = 5 ; a >= 0 ; a--){
			if(board[btn-1][a] == 0){
				win = a;
				if(player == 1){
					board[btn-1][a] = 1;
					coin[btn-1][a].setIcon(new ImageIcon("src/pic/blue.png"));
					coin[btn-1][a].setVisible(true);
				}
				else if(player == 2){
					board[btn-1][a] = 2;
					coin[(btn-1)][a].setIcon(new ImageIcon("src/pic/red.png"));
					coin[btn-1][a].setVisible(true);
				}
				if(check[btn-1]>=5){
					switch(btn){
						case 1:	frame.remove(drop1); drop1.setVisible(false); tie++; if(tie == 7){endGame(frame,10);} return;
						case 2:	frame.remove(drop2); drop2.setVisible(false); tie++; if(tie == 7){endGame(frame,10);} return;
						case 3: frame.remove(drop3); drop3.setVisible(false); tie++; if(tie == 7){endGame(frame,10);} return;
						case 4: frame.remove(drop4); drop4.setVisible(false); tie++; if(tie == 7){endGame(frame,10);} return;
						case 5: frame.remove(drop5); drop5.setVisible(false); tie++; if(tie == 7){endGame(frame,10);} return;
						case 6: frame.remove(drop6); drop6.setVisible(false); tie++; if(tie == 7){endGame(frame,10);} return;
						case 7: frame.remove(drop7); drop7.setVisible(false); tie++; if(tie == 7){endGame(frame,10);} return;
					}
				}
				winCheck(btn,frame);
				return;
			}
		}
	}
	
	public static void resetArray(JFrame frame){
		for(int a=0 ; a<=6 ; a++ ){
			for(int b=0 ; b<=5 ; b++){
				board[a][b] = 0;
			}
		}
		for(int a=0 ; a<=6 ; a++){
			check[a] = 0;
		}
		turn = 1;
	}
	
	public static void winCheck(int btn , JFrame frame){
		try{
			if(board[btn-1][win] == board[btn][win]){
				if(board[btn][win] == board[btn+1][win]){
					if(board[btn+1][win] == board[btn+2][win]){
						endGame(frame,btn);
					}
					else if(board[btn-1][win] == board[btn-2][win]){
						endGame(frame,btn);
					}
				}
			}
		}catch(ArrayIndexOutOfBoundsException exception){}
		try{
			if(board[btn-1][win] == board[btn][win-1]){
				if(board[btn][win-1] == board[btn+1][win-2]){
					if(board[btn+1][win-2] == board[btn+2][win-3]){
						endGame(frame,btn);
					}
					else if(board[btn-1][win] == board[btn-2][win+1]){
						endGame(frame,btn);
					}
				}
			}
		}catch(ArrayIndexOutOfBoundsException exception){}
		try{
			if(board[btn-1][win] == board[btn-1][win-1]){
				if(board[btn-1][win-1] == board[btn-1][win-2]){
					if(board[btn-1][win-2] == board[btn-1][win-3]){
						endGame(frame,btn);
					}
					if(board[btn-1][win-2] == board[btn-1][win+1]){
						endGame(frame,btn);
					}
				}
			}
		}catch(ArrayIndexOutOfBoundsException exception){}
		try{
			if(board[btn-1][win] == board[btn-2][win-1]){
				if(board[btn-2][win-1] == board[btn-3][win-2]){
					if(board[btn-3][win-2] == board[btn-4][win-3]){
						endGame(frame,btn);
					}
					else if(board[btn-3][win-2] == board[btn][win+1]){
						endGame(frame,btn);
					}
				}
			}
		}catch(ArrayIndexOutOfBoundsException exception){}
		try{
			if(board[btn-1][win] == board[btn-2][win]){
				if(board[btn-2][win] == board[btn-3][win]){
					if(board[btn-3][win] == board[btn-4][win]){
						endGame(frame,btn);
					}
					else if(board[btn-3][win] == board[btn][win]){
						endGame(frame,btn);
					}
				}
			}
		}catch(ArrayIndexOutOfBoundsException exception){}
		try{
			if(board[btn-1][win] == board[btn-2][win+1]){
				if(board[btn-2][win+1] == board[btn-3][win+2]){
					if(board[btn-3][win+2] == board[btn-4][win+3]){
						endGame(frame,btn);
					}
					else if(board[btn-3][win+2] == board[btn][win-1]){
						endGame(frame,btn);
					}
				}
			}
		}catch(ArrayIndexOutOfBoundsException exception){}
		try{
			if(board[btn-1][win] == board[btn-1][win+1]){
				if(board[btn-1][win+1] == board[btn-1][win+2]){
					if(board[btn-1][win+2] == board[btn-1][win+3]){
						endGame(frame,btn);
					}
					else if(board[btn-1][win+2] == board[btn-1][win-1]){
						endGame(frame,btn);
					}
				}
			}
		}catch(ArrayIndexOutOfBoundsException exception){}
		try{
			if(board[btn-1][win] == board[btn][win+1]){
				if(board[btn][win+1] == board[btn+1][win+2]){
					if(board[btn+1][win+2] == board[btn+2][win+3]){
						endGame(frame,btn);
					}
					if(board[btn+1][win+2] == board[btn-2][win-1]){
						endGame(frame,btn);
					}
				}
			}
		}catch(ArrayIndexOutOfBoundsException exception){}
	}
	
	public static void endGame(JFrame frame,int btn){
		try{if(board[btn-1][win] == 1){
			winpopup.setIcon(new ImageIcon("src/pic/player1.png"));
		}}catch(ArrayIndexOutOfBoundsException exception){}
		try{if(board[btn-1][win] == 2){
			winpopup.setIcon(new ImageIcon("src/pic/player2.png"));
		}}catch(ArrayIndexOutOfBoundsException exception){}
		try{if(btn == 8){
			winpopup.setIcon(new ImageIcon("src/pic/player1.png"));
		}}catch(ArrayIndexOutOfBoundsException exception){}
		try{if(btn == 9){
			winpopup.setIcon(new ImageIcon("src/pic/player2.png"));
		}}catch(ArrayIndexOutOfBoundsException exception){}
		try{if(btn == 10){
			winpopup.setIcon(new ImageIcon("src/pic/tie.png"));
		}}catch(ArrayIndexOutOfBoundsException exception){}
		winpopup.setVisible(true);
		mainmenu.setVisible(true);
		restart.setVisible(true);
		frame.remove(drop1); drop1.setVisible(false);
		frame.remove(drop2); drop2.setVisible(false);
		frame.remove(drop3); drop3.setVisible(false);
		frame.remove(drop4); drop4.setVisible(false);
		frame.remove(drop5); drop5.setVisible(false);
		frame.remove(drop6); drop6.setVisible(false);
		frame.remove(drop7); drop7.setVisible(false);
	}
}
