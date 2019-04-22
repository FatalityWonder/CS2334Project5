import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
/**
 * Class to get the Station IDs from a file
 * 
 * @author CJGam
 * @version 04-21-2019 
 */
public class MesoStations 
{
	/**
	 * List of all station IDs
	 */
	private ArrayList<String> stations;
	
	/**
	 * File to be read From
	 */
	private String fileName;
	
	/**
	 * Constructor for creating a list of all stations
	 * 
	 * @param fileName File to read for Station IDs
	 */
	public  MesoStations(String fileName)
	{
		this.fileName = fileName;
		
		try {
			stations = this.getStationsFromFile();
		} catch (IOException e) {
			System.out.println("Error Reading File!");
			e.printStackTrace();
		}
	}

	/**
	 * Reads a file containing station IDs and puts them in an ArrayList
	 * 
	 * @return ArrayList with all station IDs
	 * @throws IOException
	 */
	private ArrayList<String> getStationsFromFile() throws IOException 
	{
		// oversize to allow for more stations to be added before resizing, original file has 120 stations
		ArrayList<String> stations = new ArrayList<String>(140);
		
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		
		// String will be read in with the while loop header
		String currLine = "";
		while ((currLine = br.readLine()) != null)
		{
			stations.add(currLine);
		}
		
		return stations;
	}

	/**
	 * Gets the ArrayList with all stations in the file
	 * 
	 * @return ArrayList with all stations
	 */
	public ArrayList<String> getStations() 
	{
		return new ArrayList<String>(stations);
	}
	
	/**
	 * Add new station
	 * 
	 * @param station Station to be added to the stationList
	 */
	public void addStation(String station)
	{
		stations.add(station);
	}
}
