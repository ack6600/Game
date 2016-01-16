package commands;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import main.Game;

@SuppressWarnings("serial")
public class LeftAction extends AbstractAction{

	Game mainGame = new Game();
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		mainGame.setBallX(mainGame.getBallX()-1);
		
	}

}
