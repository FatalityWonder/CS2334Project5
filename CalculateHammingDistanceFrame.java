import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculateHammingDistanceFrame extends JFrame 
{
	JPanel main = new JPanel(new GridLayout(5, 1)) {public Insets getInsets() {return new Insets(15, 15, 15, 15);}};
	JPanel distance0 = new JPanel(new GridLayout(1, 2));
	JPanel distance1 = new JPanel(new GridLayout(1, 2));
	JPanel distance2 = new JPanel(new GridLayout(1, 2));
	JPanel distance3 = new JPanel(new GridLayout(1, 2));
	JPanel distance4 = new JPanel(new GridLayout(1, 2));
	
	JLabel distance0Label = new JLabel("Distance 0");
	JLabel distance1Label = new JLabel("Distance 1");
	JLabel distance2Label = new JLabel("Distance 2");
	JLabel distance3Label = new JLabel("Distance 3");
	JLabel distance4Label = new JLabel("Distance 4");
	
	JTextField distance0Text = new JTextField("0");
	JTextField distance1Text = new JTextField("0");
	JTextField distance2Text = new JTextField("0");
	JTextField distance3Text = new JTextField("0");
	JTextField distance4Text = new JTextField("0");
	
	public CalculateHammingDistanceFrame()
	{
		super("Hamming Distances");
		this.setSize(300, 200);
		this.setLayout(new GridLayout(1, 1));
		
		addLabelsAndText();
		
		this.add(main);
		
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setVisible(true);
	}

	private void addLabelsAndText() 
	{
		main.add(distance0);
		main.add(distance1);
		main.add(distance2);
		main.add(distance3);
		main.add(distance4);
		
		distance0.add(distance0Label);
		distance1.add(distance1Label);
		distance2.add(distance2Label);
		distance3.add(distance3Label);
		distance4.add(distance4Label);
		
		distance0.add(distance0Text);
		distance1.add(distance1Text);
		distance2.add(distance2Text);
		distance3.add(distance3Text);
		distance4.add(distance4Text);
		
		distance0Text.setEditable(false);
		distance1Text.setEditable(false);
		distance2Text.setEditable(false);
		distance3Text.setEditable(false);
		distance4Text.setEditable(false);
	}
}
