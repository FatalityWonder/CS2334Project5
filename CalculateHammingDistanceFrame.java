import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * Class for frame that show the number of stations with each hamming distance
 * 
 * @author CJGam
 * @version 04-21-2019
 */
public class CalculateHammingDistanceFrame extends JFrame 
{
	//================================================================================================================
	// Panels For Organization and Grouping
	//================================================================================================================
	
	// main panel to be added into with 15px padding
	JPanel main = new JPanel(new GridLayout(5, 1)) {public Insets getInsets() {return new Insets(15, 15, 15, 15);}};
	// panel for label and text field for distance 0
	JPanel distance0 = new JPanel(new GridLayout(1, 2));
	// panel for label and text field for distance 1
	JPanel distance1 = new JPanel(new GridLayout(1, 2));
	// panel for label and text field for distance 2
	JPanel distance2 = new JPanel(new GridLayout(1, 2));
	// panel for label and text field for distance 3
	JPanel distance3 = new JPanel(new GridLayout(1, 2));
	// panel for label and text field for distance 4
	JPanel distance4 = new JPanel(new GridLayout(1, 2));
	
	//================================================================================================================
	// Labels for each text field
	//================================================================================================================
	
	// label for distance 0 text field
	JLabel distance0Label = new JLabel("Distance 0");
	// label for distance 1 text field
	JLabel distance1Label = new JLabel("Distance 1");
	// label for distance 2 text field
	JLabel distance2Label = new JLabel("Distance 2");
	// label for distance 3 text field
	JLabel distance3Label = new JLabel("Distance 3");
	// label for distance 4 text field
	JLabel distance4Label = new JLabel("Distance 4");

	//================================================================================================================
	// Text Fields for each hamming distance
	//================================================================================================================
	
	// text field for number stations with distance 0
	JTextField distance0Text = new JTextField("0");
	// text field for number stations with distance 1
	JTextField distance1Text = new JTextField("0");
	// text field for number stations with distance 2
	JTextField distance2Text = new JTextField("0");
	// text field for number stations with distance 3
	JTextField distance3Text = new JTextField("0");
	// text field for number stations with distance 4
	JTextField distance4Text = new JTextField("0");
	
	/**
	 * Constructor for Frame that initializes Frame Components
	 * @param allDistances Number of each hamming distance, index is hamming distance value
	 */
	public CalculateHammingDistanceFrame(int[] allDistances)
	{
		super("Hamming Distances");
		
		this.setSize(375, 200);
		this.setLayout(new GridLayout(1, 1));
		
		// add lanels and text to panels
		addLabelsAndText();
		
		// set text field text to each distance in array
		distance0Text.setText(String.valueOf(allDistances[0]));
		distance1Text.setText(String.valueOf(allDistances[1]));
		distance2Text.setText(String.valueOf(allDistances[2]));
		distance3Text.setText(String.valueOf(allDistances[3]));
		distance4Text.setText(String.valueOf(allDistances[4]));
		
		// add primary panel to the frame
		this.add(main);
		
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setVisible(true);
	}

	/**
	 * Adds panels to main panel
	 * Adds labels and Text field to corresponding panel
	 * sets text fields to not be editable
	 */
	private void addLabelsAndText() 
	{
		// add subpanels to main panel
		main.add(distance0);
		main.add(distance1);
		main.add(distance2);
		main.add(distance3);
		main.add(distance4);
		
		// add labels to subpanels
		distance0.add(distance0Label);
		distance1.add(distance1Label);
		distance2.add(distance2Label);
		distance3.add(distance3Label);
		distance4.add(distance4Label);
		
		// add text fields to subpanels
		distance0.add(distance0Text);
		distance1.add(distance1Text);
		distance2.add(distance2Text);
		distance3.add(distance3Text);
		distance4.add(distance4Text);
			
		// disable edits in text fields
		distance0Text.setEditable(false);
		distance1Text.setEditable(false);
		distance2Text.setEditable(false);
		distance3Text.setEditable(false);
		distance4Text.setEditable(false);
	}
}
