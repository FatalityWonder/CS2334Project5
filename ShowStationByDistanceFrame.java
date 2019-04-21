import java.awt.GridLayout;
import java.awt.Insets;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class ShowStationByDistanceFrame extends JFrame
{
	JTextArea stations = new JTextArea(20, 10);
	JPanel mainPanel = new JPanel() {public Insets getInsets() {return new Insets(15, 15, 15, 15);}};
	JScrollPane scroll = new JScrollPane(stations);
	
	public ShowStationByDistanceFrame(ArrayList<String> stationByDistance, int distance) 
	{
		super("Stations by Distance: " + distance);
		this.setSize(400, 400);
		this.setLayout(new GridLayout(1, 1));
		
		String text = "";
		
		for (String currStation : stationByDistance)
		{
			text += currStation + "\n";
		}
		
		stations.setText(text);
		stations.setEditable(false);
				
		scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED );
		
		mainPanel.add(scroll);
		this.add(mainPanel);
		
		this.pack();
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setVisible(true);
	}

}
