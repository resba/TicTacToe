package com.thenetdev.TicTacToe;


import java.awt.*;
import javax.swing.*;

import com.thenetdev.TicTacToe.Event.BoardEvent;
import com.thenetdev.TicTacToe.Event.StatisticEvent;
import com.thenetdev.TicTacToe.util.REButton;

/**
 * Tic Tac Toe Final Project in Intro To Java.
 * 
 * Tic Tac Toe is a very fun, yet very complex game.
 * 
 * @author Matt Sowden
 *
 */

public class TicTacToe {
	private final BoardEvent b = new BoardEvent(this);
	private final StatisticEvent sEv = new StatisticEvent(this);
	private JFrame frame;
	private JPanel panel;
	private JFrame statFrame;
	private JPanel statPanel;
	public JLabel text;
	public REButton [][] buttons = new REButton[3][3];
	public REButton [][] statBtn = new REButton[1][2];
	public String turn;
	public int gameCounter;

	public TicTacToe() {
		//First is setting the game counter.
		gameCounter = 0;
		
		//Next is defining the main board container.
		frame = new JFrame("Tic Tac Toe");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Now we define the content holder.
		panel = new JPanel();
		panel.setBackground(Color.black);
		panel.setLayout(new GridLayout(0,3,3,3));
		panel.setPreferredSize(new Dimension(500,500));
		
		//Finally we add the content holder to the container.
		frame.getContentPane().add(panel);
		
		//Same process, but this is for the stats bar.
		setStatFrame(new JFrame("Tic Tac Toe -- Game Start"));
		getStatFrame().setLocation(0, 530);
		getStatFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		statPanel = new JPanel();
		statPanel.setBackground(Color.black);
		statPanel.setLayout(new GridLayout(0,2,0,0));
		statPanel.setPreferredSize(new Dimension(500, 50));
		getStatFrame().getContentPane().add(statPanel);
		
		//Set the first turn to X then we paint the board.
		turn = "X";
		paint();
		paintStatBar();
	}

	/**
	 * Sets all the buttons on the main board to the Disabled state.
	 * This is useful for when a player has won, but not all of the
	 * spots have been taken yet.
	 * 
	 * It also makes the background of the reset button yellow, to
	 * draw the attention of the player.
	 */
	public void blackout() {
		for(int i = 0; i < buttons.length; i++) {
			for(int j = 0; j < buttons[i].length; j++) {
				buttons[i][j].setEnabled(false);
			}
		}
		statBtn[0][0].setBackground(Color.yellow);
	}
	
	/**
	 * Used to repaint the board when a player clicks "Reset Board"
	 * on the stats bar.
	 */
	public void repaint() {
		gameCounter = 0;
		for(int i = 0; i < buttons.length; i++) {
			for(int j = 0; j < buttons[i].length; j++) {
				buttons[i][j].setFont(new Font("Arial", Font.BOLD, 48));
				buttons[i][j].setForeground(Color.lightGray);
				buttons[i][j].setBackground(Color.GRAY);
				buttons[i][j].setText ("-");
				buttons[i][j].setEnabled(true);
				setTurn("X");
				getStatFrame().setTitle("Tic Tac Toe -- Current Turn: "+getCurrentTurn());
		        text.setText ("Current Turn: "+getCurrentTurn());
			}
		}
		statBtn[0][0].setBackground(Color.LIGHT_GRAY);
	}
	
	/**
	 * Used to paint the main board. This is separate from painting 
	 * the Statistic Bar for structural and neatness concerns.
	 */
	public void paint() {

		for(int i = 0; i < buttons.length; i++) {
			for(int j = 0; j < buttons[i].length; j++) {
				buttons[i][j] = new REButton();
				buttons[i][j].setFont(new Font("Arial", Font.BOLD, 48));
				buttons[i][j].addActionListener(b);
				panel.add(buttons[i][j]);
				buttons[i][j].setForeground(Color.lightGray);
				buttons[i][j].setBackground(Color.GRAY);
				buttons[i][j].setText ("-");
			}
		}
	}
	
	
	/**
	 * Used to paint the Statistics Bar. This is separate from painting 
	 * the Main Board for structural and neatness concerns.
	 */
	public void paintStatBar() {
		for(int i = 0; i < statBtn.length; i++) {
			for(int j = 0; j < statBtn[i].length; j++) {
				if(j == 0) {
					statBtn[i][j] = new REButton();
					statBtn[i][j].setFont(new Font("Arial", Font.BOLD, 12));
					statBtn[i][j].addActionListener(sEv);
					statBtn[i][j].setForeground(Color.darkGray);
					statBtn[i][j].setBackground(Color.lightGray);
					statBtn[i][j].setText ("Reset Game");
					statPanel.add(statBtn[i][j]);
				}else if(j == 1) {
					text = new JLabel();
					text.setFont(new Font("Arial", Font.BOLD, 33));
					text.setForeground(Color.LIGHT_GRAY);
					text.setText("Current Turn: "+getCurrentTurn());
					statPanel.add(text);
				}
				
				
			}
		}
	}
	
	
	/**
	 * 
	 * Gets the current player (X or O) that is taking their turn.
	 * 
	 * @return X or O, depending on who's turn it is.
	 */
	public String getCurrentTurn() {
		return turn;
	}
	
	/**
	 * 
	 * Determines if the current placement of Xs and Os is appropriate to
	 * declare one player the winner. For efficiency, the algorithm is
	 * only implemented to check if the current player has a winning
	 * placement.
	 * 
	 * @param current -- the current player (getCurrentTurn())
	 * @return true if the current player has a winning placement, false if there is no winning placement.
	 */
	public boolean isWinner(String current) {
		
		/*
		 * Case 1:
		 * [x][x][x]
		 * [ ][ ][ ]
		 * [ ][ ][ ]
		 */
		if(gBT(buttons[0][0]) == current && gBT(buttons[0][1]) == current && gBT(buttons[0][2]) == current){
			return true;
		}else
		/*
		 * Case 2:
		 * [x][ ][ ]
		 * [x][ ][ ]
		 * [x][ ][ ]
		 */
		if(gBT(buttons[0][0]) == current && gBT(buttons[1][0]) == current && gBT(buttons[2][0]) == current){
			return true;
		}else
		/*
		 * Case 3:
		 * [x][ ][ ]
		 * [ ][x][ ]
		 * [ ][ ][x]
		 */
		if(gBT(buttons[0][0]) == current && gBT(buttons[1][1]) == current && gBT(buttons[2][2]) == current){
			return true;
		}else
		/*
		 * Case 4:
		 * [ ][ ][x]
		 * [ ][ ][x]
		 * [ ][ ][x]
		 */
		if(gBT(buttons[0][2]) == current && gBT(buttons[1][2]) == current && gBT(buttons[2][2]) == current){
				return true;
		}else
		/*
		 * Case 5:
		 * [ ][ ][x]
		 * [ ][x][ ]
		 * [x][ ][ ]
		 */
		if(gBT(buttons[2][0]) == current && gBT(buttons[1][1]) == current && gBT(buttons[0][2]) == current){
				return true;
		}else
		/*
		 * Case 6:
		 * [ ][ ][ ]
		 * [x][x][x]
		 * [ ][ ][ ]
		 */
		if(gBT(buttons[1][0]) == current && gBT(buttons[1][1]) == current && gBT(buttons[1][2]) == current){
				return true;
		}else
		/*
		 * Case 7:
		 * [ ][ ][ ]
		 * [ ][ ][ ]
		 * [x][x][x]
		 */
		if(gBT(buttons[2][0]) == current && gBT(buttons[2][1]) == current && gBT(buttons[2][2]) == current){
				return true;
		}else
		/*
		 * Case 8:
		 * [ ][x][ ]
		 * [ ][x][ ]
		 * [ ][x][ ]
		 */
		if(gBT(buttons[0][1]) == current && gBT(buttons[1][1]) == current && gBT(buttons[2][1]) == current){
				return true;
		}else{
		
		return false;
		}
	}
	
	/**
	 * 
	 * Shortener for getting the text from a REButton/JButton
	 * 
	 * @param btn -- A JButton or REButton.
	 * @return String containing the text of the specified button.
	 */
	private String gBT(REButton btn) {
		return btn.getText();
	}
	
	/**
	 * 
	 * Changes who's turn it is. It is currently implemented after isWinner() returns
	 * false and after the BoardEvent is fired.
	 * 
	 * @return String containing the next player. N if an error has occured.
	 */
	public String rotateTurn() {
        gameCounter++;
        if(gameCounter==9){
        	JOptionPane.showMessageDialog(null, "Game Over! It's a Tie!\nPress Reset Game to Play Again!");
        	blackout();
        }
		if(turn == "X"){
			return turn = "O";
		}else if (turn == "O"){
			return turn = "X";
		}else{
		return turn = "N";
		}
	}
	
	/**
	 * 
	 * Allows the program to manually set the turn of the next player.
	 * Currently implemented in repaint() to always reset the turn to
	 * X.
	 * 
	 * @param player
	 */
	public void setTurn(String player) {
		turn = player;
	}
	
	/**
	 * Debug method to print out a list of buttons array position
	 * following by the text they contain.
	 */
	public void checkButtons() {
		for(int i = 0; i < buttons.length; i++){
			for(int j = 0; j < buttons[i].length; j++)
			{
				System.out.print(i+" ");
				System.out.println(j);
				System.out.println(buttons[i][j].getText());
			}
		}
	}
	//-------------------------------------------------------------------------------------
	
	/**
	 * Displays the game's frames.
	 */
	public void display() {
		frame.pack();
		frame.setVisible(true);
		getStatFrame().pack();
		getStatFrame().setVisible(true);

	}
	/**
	 * Used to set items in the Statistics Frame.
	 * @param statFrame
	 */
	public void setStatFrame(JFrame statFrame) {
		this.statFrame = statFrame;
	}
	
	/**
	 * Used to get the statFrame JFrame Object.
	 * Currently implemented to change the title to
	 * show who the current player is.
	 * @return JFrame "statFrame" object.
	 */
	public JFrame getStatFrame() {
		return statFrame;
	}
}
