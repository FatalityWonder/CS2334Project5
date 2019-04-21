import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class HammingDistanceCalculatorFrame extends JFrame
{	
	
	private static final int FRAME_WIDTH = 700;
	private static final int FRAME_HEIGHT = 800;
	
	JPanel sliderShowStation = new JPanel(new GridLayout(3, 1));
	JPanel compareAdd = new JPanel(new GridLayout(3, 1));
	
	JSlider enterHammingDistSlider = new JSlider(1, 4, 2);
	
	public HammingDistanceCalculatorFrame()
	{
		super("Hamming Distance Calculator");
		
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.setLayout(new GridLayout(1, 2));
		
		sliderShowStation.add(enterHammingDistSlider);
		
		setSliderData();
		
		this.add(sliderShowStation);
		this.add(compareAdd);
		
		//this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
	}
	
	private void setSliderData() 
	{
		// TODO Auto-generated method stub
		
	}

	public static void main(String[] args)
	{
		new HammingDistanceCalculatorFrame();
	}
}
