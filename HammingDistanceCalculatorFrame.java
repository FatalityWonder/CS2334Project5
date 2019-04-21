import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;
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
	private static final String FILE_NAME = "Mesonet.txt";
	private static final int FRAME_WIDTH = 700;
	private static final int FRAME_HEIGHT = 800;
	
	MesoStations allStations = new MesoStations(FILE_NAME);
	
	String[] stations = arrayListToArray(allStations.getStations());
	
	JPanel sliderShowStation = new JPanel(new GridLayout(3, 1)) {public Insets getInsets() {return new Insets(15, 15, 15, 15);}};
	JPanel compareAdd = new JPanel(new GridLayout(3, 1));
	JPanel enterDistBox = new JPanel(new GridLayout(1, 2));
	JPanel compareWith = new JPanel(new GridLayout(1, 2));
	JPanel addStationBox = new JPanel(new GridLayout(1, 2));
	
	JSlider enterHammingDistSlider = new JSlider(1, 4, 2);
	JLabel enterHammingDist = new JLabel("Enter Hamming Dist:");
	JLabel compareWithLabel = new JLabel("Compare With: ");
	JTextField enterHDTextBox = new JTextField("2");
	JTextField addStationTextBox = new JTextField("ZERO");
	JComboBox<String> stationDropDown = new JComboBox<String>(stations);
	JButton calculateHammingDist = new JButton("Calculate HD");
	JButton addStation = new JButton("Add Station");
	JButton showHammingDistStations = new JButton("Show Station");
	
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
			 int[] distances = new HammingDist(allStations, stationDropDown.getSelectedItem().toString()).getNumDist();
			 new CalculateHammingDistanceFrame(distances);
		 });		 
		 
		 enterHammingDistSlider.addChangeListener((e) -> {
			 enterHDTextBox.setText(String.valueOf(enterHammingDistSlider.getValue()));
		 });
		 
		 addStation.addActionListener((e) -> {
			 allStations.addStation(addStationTextBox.getText());
			 stationDropDown.addItem(addStationTextBox.getText());
		 });
		
		 showHammingDistStations.addActionListener((e) -> {
			 HammingDist hamming = new HammingDist(allStations, stationDropDown.getSelectedItem().toString());
			 ArrayList<String> showStationByDistance = hamming.getDistanceArray(enterHammingDistSlider.getValue());
			 new ShowStationByDistanceFrame(showStationByDistance, enterHammingDistSlider.getValue());
		 });
		 
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        
	}
	
	private String[] arrayListToArray(ArrayList<String> arrayList) 
	{
		String[] stations = new String[arrayList.size()];
		for	(int i = 0; i < arrayList.size(); ++i)
		{
			stations[i] = arrayList.get(i);
		}
		
		return stations;
	}

	private void setComponentData() 
	{
		enterHDTextBox.setEditable(false);
		stationDropDown.setSelectedItem("NRMN");
	}

	private void addComponentsToPanels() 
	{		
		sliderShowStation.add(enterDistBox);
		sliderShowStation.add(enterHammingDistSlider);
		sliderShowStation.add(showHammingDistStations);
		
		enterDistBox.add(enterHammingDist);
		enterDistBox.add(enterHDTextBox);
		
		compareAdd.add(compareWith);
		compareAdd.add(calculateHammingDist);
		compareAdd.add(addStationBox);
		
		compareWith.add(compareWithLabel);
		compareWith.add(stationDropDown);
		
		addStationBox.add(addStation);
		addStationBox.add(addStationTextBox);
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
