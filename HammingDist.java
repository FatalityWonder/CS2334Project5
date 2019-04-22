import java.util.ArrayList;
import java.util.Arrays;
/**
 * Class to find hamming distance based on input mesoStation and input Station name
 * 
 * @author CJGam
 * @version 04-21-2019
 */
public class HammingDist 
{
	/**
	 * Station ID to compare everything to
	 */
	private String StID;
	
	/**
	 * Contains all station IDs in the file
	 */
	private MesoStations meso;
	
	/**
	 * all stations with distance 1
	 */
	private ArrayList<String> distance1;
	/**
	 * all stations with distance 2
	 */
	private ArrayList<String> distance2;
	/**
	 * all stations with distance 3
	 */
	private ArrayList<String> distance3;
	/**
	 * all stations with distance 4
	 */
	private ArrayList<String> distance4;
	
	/**
	 * number of stations at each distance, indexed by distance (index 1 = distance 1)
	 */
	private int[] numDist;
	
	/**
	 * Constructor to find Hamming Distances
	 * 
	 * @param meso MesoStations to be compared to
	 * @param StID Station ID to get hamming distances for
	 */
	public HammingDist(MesoStations meso, String StID)
	{
		// initialize distance ArrayLists
		distance1 = new ArrayList<String>();
		distance2 = new ArrayList<String>();
		distance3 = new ArrayList<String>();
		distance4 = new ArrayList<String>();
		
		// initialize array containing Hamming Distances
		numDist = new int[5];
		
		this.meso = meso;
		this.StID = StID;
		
		// automatically calculate hamming distances
		findHammingDistances(StID);
	}

	/**
	 * Finds all hamming distances for the input Station
	 * 
	 * @param station Station to find Hamming distances for
	 */
	private void findHammingDistances(String station) 
	{
		ArrayList<String> mesoStations = meso.getStations();
		
		// get station at each index in Mesostations
		for (int i = 0; i < mesoStations.size(); ++i)
		{
			// gets the hamming distance of each index of currStation
			String currStation = mesoStations.get(i);
			int currDist = calculateHammingDistance(StID, currStation);
			
			// sort the current station into respective array
			addHammingArray(currDist, currStation);
		}
	}

	/**
	 * Sorts the stations to each ArrayList based on Hamming Distance
	 * 
	 * @param currDist Hamming distance of currStation
	 * @param currStation Station to add to ArrayList corresponding to currDist
	 */
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
		
		// increment the number of stations with that distance, distance between 0 and 4
		if (currDist >= 0 && currDist <= 4)
		{
			++this.numDist[currDist];
		}
	}

	/**
	 * Calculates the hamming distance of two strings
	 * 
	 * @param station Initial Station to be compared to
	 * @param currStation Current station to compare to Initial Station
	 * @return Hamming distance of both input strings
	 */
	public static int calculateHammingDistance(String station, String currStation)
	{
		int distance = 0;
		
		for (int i = 0; i < station.length() && i < currStation.length(); ++i)
		{
			// compare characters at each index, if different increment Hamming distance
			if (station.charAt(i) != currStation.charAt(i))
			{
				++distance;
			}
		}
		
		return distance;
	}

	/**
	 * Gets the calculated number of stations at each hamming distance
	 * 
	 * @return Integer array that contains the number of stations at each hamming distance
	 */
	public int[] getNumDist() 
	{
		return Arrays.copyOf(numDist, numDist.length);
	}

	/**
	 * gets the ArrayList<String> with the stations with the same hamming distance from the object staion as
	 * the value
	 * 
	 * @param value Distance of arrayList to find
	 * @return ArrayList<String> with corresponding distance of value
	 */
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
