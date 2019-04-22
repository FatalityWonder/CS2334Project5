import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

/**
 * Class that Represents a Calculator for Finding the Hamming Distance between station IDs
 *  
 * @author CJGam
 * @version 04-21-2019
 */
public class HammingDistanceCalculatorFrame extends JFrame
{	
	/**
	 * Name of file with Station Names
	 */
	private static final String FILE_NAME = "Mesonet.txt";
	
	/**
	 * Default Frame Width
	 */
	private static final int FRAME_WIDTH = 700;
	
	/**
	 * Default Frame Height
	 */
	private static final int FRAME_HEIGHT = 800;
	
	// list of all stations in file
	MesoStations allStations = new MesoStations(FILE_NAME);
	
	// list of stations in file to add to the JComboBox
	String[] stations = arrayListToArray(allStations.getStations());
	
	//================================================================================================================
	// Panels For Organization and Grouping
	//================================================================================================================
	
	// left side panel that goes into frame
	JPanel sliderShowStation = new JPanel(new GridLayout(3, 1)) {public Insets getInsets() {return new Insets(15, 15, 15, 15);}};
	// middle panel that goes into frame
	JPanel compareAdd = new JPanel(new GridLayout(3, 1));
	// contains JLabel and Text Field for the current selected value on Slider
	JPanel enterDistBox = new JPanel(new GridLayout(1, 2));
	// contains JLabel and JComboBox for dropdown menu and label
	JPanel compareWith = new JPanel(new GridLayout(1, 2));
	// contains Button and Text Field to add station
	JPanel addStationBox = new JPanel(new GridLayout(1, 2));
	

	//================================================================================================================
	// Components for Operation
	//================================================================================================================
	
	// Slider with 4 option: 1, 2, 3, 4 to select Hamming Distance to Show
	JSlider enterHammingDistSlider = new JSlider(1, 4, 2);
	// Label for the Slider as well as Text Field that shows that value
	JLabel enterHammingDist = new JLabel("Enter Hamming Dist:");
	// Label for the Dropdown menu to select which Station to get hamming distance for
	JLabel compareWithLabel = new JLabel("Compare With: ");
	// Text Field for the current value on the slider, with default value 2
	JTextField enterHDTextBox = new JTextField("2");
	// Text box to enter station to add, default text is "ZERO"
	JTextField addStationTextBox = new JTextField("ZERO");
	// Dropdown menu to select station to find hamming distances for 
	JComboBox<String> stationDropDown = new JComboBox<String>(stations);
	// Button to calculate hamming distances of all stations from current selected in dropdown
	JButton calculateHammingDist = new JButton("Calculate HD");
	// Button to add string in the addStationTextBox to the Dropdown menu
	JButton addStation = new JButton("Add Station");
	// Button to show all stations with selected distance on slider with the selected station on the dropdown
	JButton showHammingDistStations = new JButton("Show Station");
	
	/**
	 * Constructs GUI components for the Hamming Distance Calculator. Has the ability to add new stations, compare all stations in
	 * file with the selected station and find hamming distances from that.
	 */
	public HammingDistanceCalculatorFrame()
	{
		super("Hamming Distance Calculator");
		
		this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		this.setLayout(new GridLayout(1, 2));
		
		// call methods to section off operations
		addComponentsToPanels();
		setSliderData();
		setComponentData();
			
		this.add(sliderShowStation);
		this.add(compareAdd);
		
		// check if calculate HD was clicked, and then create new frame with hamming distances
		 calculateHammingDist.addActionListener((e) -> {
			 int[] distances = new HammingDist(allStations, stationDropDown.getSelectedItem().toString()).getNumDist();
			 new CalculateHammingDistanceFrame(distances);
		 });		 
		 
		 // check if Hamming Distance slider was changed, and then set the hamming distance text box to same value
		 enterHammingDistSlider.addChangeListener((e) -> {
			 enterHDTextBox.setText(String.valueOf(enterHammingDistSlider.getValue()));
		 });
		 
		 // check if Add Station was clicked, and add station if it is not in the dropdown
		 addStation.addActionListener((e) -> {
			 ArrayList<String> mesoStations = allStations.getStations();
			 
			 String textBox = addStationTextBox.getText().toUpperCase();
			 boolean contained = mesoStations.contains(textBox);
			 			 
			 if (!contained)
			 {
				 // need to remove items to add items and sort
				 stationDropDown.removeAllItems();
				 
				 // add station to the textbox and mesostations list
				 mesoStations.add(textBox);
				 allStations.addStation(textBox);
			 
				 Collections.sort(mesoStations);
				 
				 // copy into dropdown after sort
				 for (String current : mesoStations)
				 {
					 stationDropDown.addItem(current);
				 }
				 
				 // set selected item to default
				 stationDropDown.setSelectedItem("NRMN");
			 }	 
		 });
		
		 // check if Show Stations was clicked and open a new window with the stations with the same hamming distance
		 // as the selected value on the slider from the selected station in the dropdown
		 showHammingDistStations.addActionListener((e) -> {
			 HammingDist hamming = new HammingDist(allStations, stationDropDown.getSelectedItem().toString());
			 ArrayList<String> showStationByDistance = hamming.getDistanceArray(enterHammingDistSlider.getValue());
			 new ShowStationByDistanceFrame(showStationByDistance, enterHammingDistSlider.getValue());
		 });
		 
		this.pack();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
	}
	
	/**
	 * Copies an ArrayList<String> into a perfect Size array
	 * 
	 * @param arrayList initial ArrayList to be copied
	 * @return String array with same contents and size as arraylist
	 */
	private String[] arrayListToArray(ArrayList<String> arrayList) 
	{
		String[] stations = new String[arrayList.size()];
		
		for	(int i = 0; i < arrayList.size(); ++i)
		{
			stations[i] = arrayList.get(i);
		}
		
		return stations;
	}
	
	/**
	 * makes default dropdown selection be "NRMN" and Hamming Distance Text Field be not editable
	 */
	private void setComponentData() 
	{
		enterHDTextBox.setEditable(false);
		stationDropDown.setSelectedItem("NRMN");
	}
	
	/**
	 * Add components to panels in order
	 */
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
	
	/**
	 * Sets the Slider ticks and labels
	 */
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
        
        // Show on labels
        enterHammingDistSlider.setLabelTable(labels);
        enterHammingDistSlider.setPaintLabels(true);
	}

	/**
	 * Main method to the program, calls constructor for the frame
	 * @param args
	 */
	public static void main(String[] args)
	{
		new HammingDistanceCalculatorFrame();
	}
}
