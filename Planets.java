// --== CS400 File Header Information ==--
// Name: Gabriela Setyawan
// Email: gsetyawan@wisc.edu
// Team: Blue
// Role: Data Wrangler
// TA: Daniel Finer
// Lecturer: Gary Dahl
// Notes to Grader: N/A
/**
 * Planets represent a data in the vertices in the Solar System Graph that contains the name of the planet, diameter and meanTemperature
 * @author Gabriela Setyawan 
 *
 */
public class Planets {
private String name;
//private int diameter;
//private int meanTemperature;
	/**
	 * Constructor for Planets object
	 * @param name String that represents name of the planet
	 * @param diameter integer that represents the diameter of the planet
	 * @param meanTemperature integer that represents the mean Temperature of the planet
	 */
	public Planets(String name) {
		this.name = name;
//		this.diameter = diameter;
//		this.meanTemperature = meanTemperature;
	}
	
//	/**
//	 * Getter method for the mean temperature field of the planet
//	 * @return integer that represents the mean Temperature of the planet
//	 */
//	public int getMeanTemperature() {
//		return this.meanTemperature;
//	}
//	
	/**
	 * Getter method for the name field of the planet
	 * @return String that represents the name of the planet
	 */
	public String getName() {
		return this.name;
	}
//	/**
//	 * Getter method for the diameter field of the planet
//	 * @return integer that represents the diameter of the planet
//	 */
//	public int getDiameter() {
//		return this.diameter;
//	}
//
//	/**
//	 * Get the details of the planet as a string object
//	 * @return String that contains the information about a certain planet
//	 */
//	public String ToString() {
//		return "This planet is called " + this.name + " and it has a diameter of " + this.diameter + " km, and the mean temperature is " + this.meanTemperature;
//	}
//	
}

