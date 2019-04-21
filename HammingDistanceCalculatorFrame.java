import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class HammingDistanceCalculatorFrame extends JFrame
{	
	
	private static final int FRAME_WIDTH = 700;
	private static final int FRAME_HEIGHT = 800;
	
	String[] stations = {"NRMN", "FELL", "HIKE"};
	
	JPanel sliderShowStation = new JPanel(new GridLayout(3, 1)) {public Insets getInsets() {return new Insets(15, 15, 15, 15);}};
	JPanel compareAdd = new JPanel(new GridLayout(3, 1));
	JPanel enterDistBox = new JPanel(new GridLayout(1, 2));
	
	JSlider enterHammingDistSlider = new JSlider(1, 4, 2);
	JLabel enterHammingDist = new JLabel("Enter Hamming Dist:");
	JTextField enterHDTextBox = new JTextField("2");
	JComboBox<String> stationDropDown = new JComboBox<String>(stations);
	JButton calculateHammingDist = new JButton("Calculate HD");
	JButton addStation = new JButton("Add Station");
	
	public HammingDistanceCalculatorFrame()
	{
		super("Hamming Distance Calculator");
		
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.setLayout(new GridLayout(1, 2));
		
		addComponentsToPanels();
		setSliderData();
		setComponentData();
		
		this.add(sliderShowStation);
		this.add(compareAdd);
		
		 calculateHammingDist.addActionListener((e) -> {
			 new CalculateHammingDistanceFrame();
		 });		 
		 
		 enterHammingDistSlider.addChangeListener((e) -> {
			 enterHDTextBox.setText(String.valueOf(enterHammingDistSlider.getValue()));
		 });
		
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        
	}
	
	private void setComponentData() 
	{
		enterHDTextBox.setEditable(false);	
	}

	private void addComponentsToPanels() 
	{		
		sliderShowStation.add(enterDistBox);
		sliderShowStation.add(enterHammingDistSlider);
		
		enterDistBox.add(enterHammingDist);
		enterDistBox.add(enterHDTextBox);
		
		compareAdd.add(stationDropDown);
		compareAdd.add(calculateHammingDist);
		compareAdd.add(addStation);
	}

	private void setSliderData() 
	{
		// create tick marks at each position
		enterHammingDistSlider.setMinorTickSpacing(1);
		enterHammingDistSlider.setMajorTickSpacing(1);
		enterHammingDistSlider.setPaintTicks(true);
		
		// create labels
        Hashtable<Integer, JLabel> labels = new Hashtable<>();
        labels.put(1, new JLabel("1"));
        labels.put(2, new JLabel("2"));
        labels.put(3, new JLabel("3"));
        labels.put(4, new JLabel("4"));
        
        // turn on labels
        enterHammingDistSlider.setLabelTable(labels);
        enterHammingDistSlider.setPaintLabels(true);
		
	}

	public static void main(String[] args)
	{
		new HammingDistanceCalculatorFrame();
	}
}
