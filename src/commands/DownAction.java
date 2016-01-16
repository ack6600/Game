package commands;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import main.Game;

@SuppressWarnings("serial")
public class DownAction extends AbstractAction{

	Game mainGame = new Game();
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		mainGame.setBallY(mainGame.getBallY()-1);
		
	}

}
