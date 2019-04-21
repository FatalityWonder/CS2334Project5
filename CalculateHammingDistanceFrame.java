import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CalculateHammingDistanceFrame extends JFrame 
{
	JPanel left = new JPanel(new GridLayout(4, 1));
	JPanel right = new JPanel(new GridLayout(4, 1));
	
	public CalculateHammingDistanceFrame()
	{
		super("Hamming Distances");
		this.setSize(300, 400);
		this.setLayout(new GridLayout(1, 2));
		
		
		this.add(left);
		this.add(right);
		
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setVisible(true);
	}
}
