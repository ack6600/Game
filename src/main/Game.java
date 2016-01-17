package main;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Game extends JPanel implements KeyListener,ActionListener{
	public static int ballX = 200;
	public static int ballY = 200;
	

	private int rectWidth = 10;
	private int rectHeight = 10;
	private static int refreshRate = 60;
	private static long lastTime = System.currentTimeMillis();
	private static long frameRate = 0;
	private int steadyFrameRate;
	private boolean w;
	private boolean a;
	private boolean s;
	private boolean d;
//	private Ball ball = new Ball();
	private int[] lastFrameRates = {0,0,0,0,0};
	private int average;
	private int shouldCalculate = 0;
	Random r = new Random();
//	private int ballTargetX = r.nextInt(400);
//	private int ballTargetY = r.nextInt(400);
	public void moveBall()
	{
		
		if(w)
		{
			ballY--;
			
		}
		if(a)
		{
			ballX--;
		}
		if(s)
		{
			ballY++;
		}
		if(d)
		{
			ballX++;
		}
	}
	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setColor(Color.BLUE);

		g2d.fillRect(ballX, ballY, rectWidth, rectHeight);

		Font f = new Font("Font",Font.PLAIN,12);
		g2d.setFont(f);
		shouldCalculate++;
		if(shouldCalculate > 10)
		{
		steadyFrameRate = (calculateFrameRate((int) frameRate));
		shouldCalculate = 0;
		}
		g2d.drawString(new Integer(steadyFrameRate).toString(), 2, 12);
//		try {
//			Thread.sleep(1);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}
	public int calculateFrameRate(int fRate)
	{
		for(int i = 0; i<lastFrameRates.length-1; i++)
		{
		lastFrameRates[i] = lastFrameRates[i+1];
		}
		lastFrameRates[lastFrameRates.length-1] = fRate;
		average = 0;
		for(int i = 0; i<lastFrameRates.length; i++)
		{
			average = average + lastFrameRates[i];
		}
		return average/lastFrameRates.length;
	}
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		JFrame mainFrame = new JFrame();
		Game mainGame = new Game();
		mainGame.addKeyListener(mainGame);
		
		new Timer(1000/refreshRate, mainGame).start();
		//controls
//		mainGame.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0), "up");
//		mainGame.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0), "down");
//		mainGame.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_A, 0), "left");
//		mainGame.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_D, 0), "right");
//		mainGame.getActionMap().put("up", new UpAction());
//		mainGame.getActionMap().put("down", new DownAction());
//		mainGame.getActionMap().put("left", new LeftAction());
//		mainGame.getActionMap().put("right", new RightAction());
		mainFrame.add(mainGame);
		mainFrame.addKeyListener(mainGame);
		mainFrame.setSize(400, 400);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setVisible(true);
		while(true)
		{
			mainGame.moveBall();
			Thread.sleep(10);
		}
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getKeyChar() == 'w')
		{
			w = true;
			
		}
		if (arg0.getKeyChar() == 'a')
		{
			a = true;
		}
		if (arg0.getKeyChar() == 's')
		{
			s = true;
		}
		if (arg0.getKeyChar() == 'd')
		{
			d = true;
		}
		
		
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getKeyChar() == 'w')
		{
			w = false;
		}
		if (arg0.getKeyChar() == 'a')
		{
			a = false;
		}
		if (arg0.getKeyChar() == 's')
		{
			s = false;
		}
		if (arg0.getKeyChar() == 'd')
		{
			d = false;
		}
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		this.repaint();
		try
		{
		frameRate = 1000/(System.currentTimeMillis() - lastTime);
		lastTime = System.currentTimeMillis();
		}
		catch(ArithmeticException e)
		{
			e.printStackTrace();
		}
	}

}
