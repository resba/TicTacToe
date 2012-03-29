package com.thenetdev.TicTacToe.Event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.thenetdev.TicTacToe.TicTacToe;
import com.thenetdev.TicTacToe.util.REButton;

/**
 * 
 * This event listener is used to manage the events
 * on the Statistic Bar of the Tic Tac Toe game.
 * 
 * @author Matt Sowden
 *
 */
public class StatisticEvent implements ActionListener {
	public static TicTacToe board; 
	
	public StatisticEvent(TicTacToe instance) {
        board = instance;
}

	/**
	 * Implementation method of ActionListener.
	 */
	public void actionPerformed(ActionEvent e) {
		System.out.println("Reset Button Switched.");
		if(board.statBtn[0][0].getButtonID() == ((REButton) e.getSource()).getButtonID()){
			board.repaint();
		}
		
	}

}
