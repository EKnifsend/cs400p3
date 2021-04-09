/**
 * Paths represent edges for Planets
 * @author Gabriela Setyawan 
 *
 */
public class Paths {
	private Planets start;
	private Planets end;
	private int fuelCost;

	/**
	 * Constructor for Planets object
	 * @param name String that represents name of the planet
	 */
	public Paths(Planets start, Planets end, int fuelCost) {
		this.start = start;
		this.end = end;
		this.fuelCost = fuelCost;
		
	}
	
	

	public Planets getStart() {
		return start;
	}



	public Planets getEnd() {
		return end;
	}



	public int getFuelCost() {
		return fuelCost;
	}



	/**
	 * Get the details of the planet as a string object
	 * @return String that contains the information about a certain planet
	 */
	public String toString() {
		return start + " takes " + fuelCost + " to go to " + end;
	}
	
}
