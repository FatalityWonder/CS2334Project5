import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

/**
 * Class that creates a frame that shows the Stations with the specified Hamming distance
 * 
 * @author CJGam
 * @version 04-21-2019
 */
public class ShowStationByDistanceFrame extends JFrame
{
	// main panel to add things the text area to
	JPanel mainPanel = new JPanel() {public Insets getInsets() {return new Insets(15, 15, 15, 15);}};
	// text area that will contain stations
	JTextArea stations = new JTextArea(20, 10);
	// scroll bar for station text area if needed
	JScrollPane scroll = new JScrollPane(stations);
	
	/**
	 * Creates frame to show GUI components
	 * 
	 * @param stationByDistance ArrayList of Specified Distance to be shown 
	 * @param distance Specified Hamming Distance to Show
	 */
	public ShowStationByDistanceFrame(ArrayList<String> stationByDistance, int distance) 
	{
		super("Stations by Distance: " + distance);
		this.setSize(400, 400);
		this.setLayout(new GridLayout(1, 1));
		
		// Text Area only accepts one string
		String text = "";
		for (String currStation : stationByDistance)
		{
			text += currStation + "\n";
		}
		
		stations.setText(text);
		stations.setEditable(false);
		
		scroll.setVerticalScrollBarPolicy (ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		mainPanel.add(scroll);
		this.add(mainPanel);
		
		this.pack();
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setVisible(true);
	}

}
