import java.util.ArrayList;
import java.util.Arrays;

public class HammingDist 
{
	private String StID;
	private MesoStations meso;
	
	private ArrayList<String> distance1;
	private ArrayList<String> distance2;
	private ArrayList<String> distance3;
	private ArrayList<String> distance4;
	
	private int[] numDist;
	
	public HammingDist(MesoStations meso, String StID)
	{
		distance1 = new ArrayList<String>();
		distance2 = new ArrayList<String>();
		distance3 = new ArrayList<String>();
		distance4 = new ArrayList<String>();
		
		numDist = new int[5];
		
		this.meso = meso;
		this.StID = StID;
		
		findHammingDistances(StID);
	}

	private void findHammingDistances(String station) 
	{
		ArrayList<String> mesoStations = meso.getStations();
		
		for (int i = 0; i < mesoStations.size(); ++i)
		{
			String currStation = mesoStations.get(i);
			int currDist = calculateHammingDistance(StID, currStation);
			
			addHammingArray(currDist, currStation);
		}
	}

	private void addHammingArray(int currDist, String currStation) 
	{
		switch (currDist)
		{
			case 0:
				break;
				
			case 1:
				distance1.add(currStation);
				break;
				
			case 2:
				distance2.add(currStation);
				break;
				
			case 3:
				distance3.add(currStation);
				break;
				
			case 4:
				distance4.add(currStation);
				break;
				
			default:
				break;
		}
		
		if (currDist >= 0 && currDist <= 4)
		{
			++this.numDist[currDist];
		}
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

	public int[] getNumDist() 
	{
		return Arrays.copyOf(numDist, numDist.length);
	}

	public ArrayList<String> getDistanceArray(int value) 
	{
		ArrayList<String> distanceNow = new ArrayList<String>();
		
		switch(value)
		{
			case 1:
				distanceNow = new ArrayList<String>(distance1);
				break;
				
			case 2:
				distanceNow = new ArrayList<String>(distance2);
				break;
				
			case 3:
				distanceNow = new ArrayList<String>(distance3);
				break;
				
			case 4:
				distanceNow = new ArrayList<String>(distance4);
				break;
		}
		
		return distanceNow;
	}
	
	
}
