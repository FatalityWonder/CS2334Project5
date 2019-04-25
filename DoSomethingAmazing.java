import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class DoSomethingAmazing extends JFrame
{	
	public DoSomethingAmazing(String st1, String st2)
	{
		super("Bouncing Hamming Distance");
		this.setSize(500, 430);
		this.setLayout(new GridLayout(1, 1));
		
		this.add(new floatingBox(String.valueOf(HammingDist.calculateHammingDistance(st1, st2))));
		
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setVisible(true);
	}
	
	public class floatingBox extends JPanel implements ActionListener
	{
		Timer timer = new Timer(15, this);
		int x = 0, y = 0, changeX = 4, changeY = 6, fontSize = 24, changeSize = 1;
		
		private String hamming;
		
		public floatingBox(String hamming)
		{
			this.hamming = hamming;
		}
		
		protected void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			
			g.setColor(Color.BLUE);
			g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
			g.drawString(hamming, x, y);
			
			timer.start();
		}
		
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			if (x < 0 || x > 450)
			{
				changeX = -changeX;
			}
			if (y < 0 || y > 370)
			{
				changeY = -changeY;
			}
			if (fontSize < 24 || fontSize > 48)
			{
				changeSize = -changeSize;
			}
			
			fontSize += changeSize;
			x += changeX;
			y += changeY;
			
			repaint();
		}
	}
}
