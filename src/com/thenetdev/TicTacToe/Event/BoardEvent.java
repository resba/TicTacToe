package com.thenetdev.TicTacToe.Event;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import com.thenetdev.TicTacToe.TicTacToe;
import com.thenetdev.TicTacToe.util.REButton;


/**
 * Used to manage the events on the Main Tic Tac Toe Board.
 * 
 * @author Matt Sowden
 *
 */
public class BoardEvent implements ActionListener {
	public static TicTacToe board; 
	
	public BoardEvent(TicTacToe instance) {
        board = instance;
}
	/**
	 * Implemented method for ActionLister.
	 */
	public void actionPerformed(ActionEvent e) {
        ((REButton) e.getSource()).setText(board.getCurrentTurn());
        System.out.println(((REButton) e.getSource()).getButtonID());
        ((REButton) e.getSource()).setEnabled(false);
        if(board.isWinner(board.getCurrentTurn())==true){
        	JOptionPane.showMessageDialog(null,"The winner is: "+board.getCurrentTurn()+"\nPress Reset Game to Play Again!");
        	board.blackout();
        	
        }else{
        	board.rotateTurn();
        }
        board.getStatFrame().setTitle("Tic Tac Toe -- Current Turn: "+board.getCurrentTurn());
        board.text.setText ("Current Turn: "+board.getCurrentTurn());
        
		
	}

}
