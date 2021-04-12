// --== CS400 File Header Information ==--
// Name: Gabriela Setyawan
// Email: gsetyawan@wisc.edu
// Team: Blue
// Role: Data Wrangler
// TA: Daniel Finer
// Lecturer: Gary Dahl
// Notes to Grader: N/A
/**
 * Paths represent edges for Planets
 * @author Gabriela Setyawan 
 *
 */
public class Paths {
	protected Planets start;
	protected Planets end;
	protected int fuelCost;

	/**
	 * Constructor for Path object
	 * @param name String that represents name of the planet
	 */
	public Paths(Planets start, Planets end, int fuelCost) {
		this.start = start;
		this.end = end;
		this.fuelCost = fuelCost;
		
	}
	
	
	/**
	 * Getter method for the starting planet
	 * @return start reference to the starting Planet
	 */
	public Planets getStart() {
		return start;
	}


	/**
	 * Getter method for the ending planet (target planet of the edge)
	 * @return start reference to the ending Planet
	 */
	public Planets getEnd() {
		return end;
	}



	/**
	 * Getter method for the fuel needed from one planet to the other
	 * @return fuelCost integer containing the fuel needed to get from starting planet to ending planet
	 */
	public int getFuelCost() {
		return fuelCost;
	}



	/**
	 * Get the details of the planet as a string object
	 * @return String that contains the information about a certain planet
	 */
	public String toString() {
		return "It takes " + fuelCost + " gallons to go from " + start.getName() + " to " + end.getName();
	}
	
}