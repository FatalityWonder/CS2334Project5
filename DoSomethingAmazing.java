import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Class that creates a number bouncing around within a frame
 * 
 * @author CJGam
 * @version 04-25-2019
 */
public class DoSomethingAmazing extends JFrame
{	
	/**
	 * Creates a frame for the bouncing number
	 * If strings are different length, it will calculate hamming distance up to the length of the shorter string
	 * 
	 * @param st1 Station 1 to calculate Hamming Distance
	 * @param st2 Station 2 to calculate Hamming Distance
	 */
	public DoSomethingAmazing(String st1, String st2)
	{
		super("Bouncing Hamming Distance");
		this.setSize(500, 430);
		this.setLayout(new GridLayout(1, 1));
		
		// add JPanel with number
		this.add(new floatingBox(String.valueOf(HammingDist.calculateHammingDistance(st1, st2))));
		
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setVisible(true);
	}
	
	/**
	 * Class representing a JPanel containing a number that has been painted and bouncing around
	 *  
	 * @author CJGam
	 * @version 04-25-2019
	 */
	public class floatingBox extends JPanel implements ActionListener
	{
		/**
		 * How much time to wait before redrawing
		 */
		Timer timer = new Timer(15, this);
		
		/**
		 * defines size and positions of the number
		 */
		int x = 0, y = 0, changeX = 4, changeY = 6, fontSize = 24, changeSize = 1;
		
		/**
		 * hamming distance converted to a String
		 */
		private String hamming;
		
		/**
		 * Constructor for JPanel with bouncing number
		 * 
		 * @param hamming String representing the hamming Distance
		 */
		public floatingBox(String hamming)
		{
			this.hamming = hamming;
		}
		
		/**
		 * Draw the Painted number
		 */
		protected void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			
			g.setColor(Color.BLUE);
			g.setFont(new Font("TimesRoman", Font.PLAIN, fontSize));
			g.drawString(hamming, x, y);
			
			// move the number
			timer.start();
		}
		
		/**
		 * Moves the number in the panel
		 */
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			// check if number hit left or right edge
			if (x < 0 || x > 450)
			{
				changeX = -changeX;
			}
			
			// check if number hit top or bottom
			if (y < 0 || y > 370)
			{
				changeY = -changeY;
			}
			
			// check if letter hit max or minimum size
			if (fontSize < 24 || fontSize > 48)
			{
				changeSize = -changeSize;
			}
			
			// move and change size of the number
			fontSize += changeSize;
			x += changeX;
			y += changeY;
			
			repaint();
		}
	}
}
