import java.util.ArrayList;
import java.util.HashMap;

public class HammingDist 
{
	private String StID;
	private MesoStations meso;
	private HashMap<String, Integer> distances;
	
	public HammingDist(MesoStations meso, String StID)
	{
		this.meso = meso;
		this.StID = StID;
		distances = findHammingDistances(StID);
	}

	private HashMap<String, Integer> findHammingDistances(String station) 
	{
		HashMap<String, Integer> distances = new HashMap<String, Integer>();
		ArrayList<String> mesoStations = meso.getStations();
		
		for (int i = 0; i < mesoStations.size(); ++i)
		{
			String currStation = mesoStations.get(i);
			int currDist = calculateHammingDistance(StID, currStation);
			distances.put(currStation, currDist);
		}
		
		return distances;
	}

	public static int calculateHammingDistance(String station, String currStation)
	{
		int distance = 0;
		
		for (int i = 0; i < station.length() && i < currStation.length(); ++i)
		{
			if (station.charAt(i) != currStation.charAt(i))
			{
				++distance;
			}
		}
		
		return distance;
	}
	
	public HashMap<String, Integer> getDistances()
	{
		return new HashMap<String, Integer>(this.distances);
	}
}
