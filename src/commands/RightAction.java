package commands;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import render.Game;

@SuppressWarnings("serial")
public class RightAction extends AbstractAction{

	
	@Override
	public synchronized void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Game.ballX++;
		
	}

}
