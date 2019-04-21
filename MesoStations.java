import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MesoStations 
{
	private ArrayList<String> stations;
	private String fileName;
	
	public  MesoStations(String fileName)
	{
		try {
			stations = getStationsFromFile();
		} catch (IOException e) {
			System.out.println("Error Reading File!");
			e.printStackTrace();
		}
		
		this.fileName = fileName;
	}

	private ArrayList<String> getStationsFromFile() throws IOException 
	{
		// oversize to allow for more stations to be added before resizing, original file has 120 stations
		ArrayList<String> stations = new ArrayList<String>(140);
		
		BufferedReader br = new BufferedReader(new FileReader(this.fileName));
				
		String currLine = "";
		while ((currLine = br.readLine()) != null)
		{
			stations.add(currLine);
		}
		
		return stations;
	}

	public ArrayList<String> getStations() 
	{
		return new ArrayList<String>(stations);
	}
	
	public void addStation(String station)
	{
		stations.add(station);
	}
}
