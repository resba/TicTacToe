package com.thenetdev.TicTacToe.util;

import javax.swing.JButton;
import java.util.UUID;

/**
 * 
 * Extended JButton instance who's only real purpose is to include a unique ID
 * for the button it defines. Designed for Matt Sowden's Tic Tac Toe program
 * for use in determining weather or not a button inside a button array
 * was pressed or not.<br>
 * <br>
 * Uses java.util.UUID to define an ID if you don't define one yourself.<br>
 * <br>
 * HERE'S AN EXAMPLE (Used inside an external ActionListener):<br>
 * <br>
 * 		if(board.statBtn.getButtonID() == ((REButton) e.getSource()).getButtonID()){<br>
 *			board.repaint();<br>
 *		}<br>
 * 
 * @author Matt Sowden
 * @version 1.0.0
 *
 */

public class REButton extends JButton {

	private static final long serialVersionUID = -4368208227423965397L;
	public String BUTTON_ID;
	
	public REButton(){
		BUTTON_ID = UUID.randomUUID().toString();
	}
	public REButton(String id){
		BUTTON_ID = id;
	}
	
	
	/**
	 * Returns the Button ID for the specific button.
	 * @return - String, ID Of Button.
	 */
	public String getButtonID(){
		return BUTTON_ID;
	}
	
	/**
	 * Overwrites the current ID of the button with a new ID.
	 * @param id
	 */
	public void setButtonID(String id){
		BUTTON_ID = id;
	}
	
}
