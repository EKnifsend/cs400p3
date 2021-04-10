
// --== CS400 File Header Information ==--
// Name: Gabriela Setyawan
// Email: gsetyawan@wisc.edu
// Team: Blue
// Role: Data Wrangler
// TA: Daniel Finer
// Lecturer: Gary Dahl
// Notes to Grader: N/A
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class DataWranglerTests {
	private static String planet1 = "Mars";
	private static String planet2 = "Neptune";
	private static String planet3 = "Earth";
	private static String planet4 = "Uranus";
	private static String planet5 = "Pluto";
	
	private static int fuelThreeToOne = 500;
	private static int fuelTwoToFour = 10300;
	private static int fuelFiveToThree = 1000;

	Planets PlanetOne = new Planets(planet1);
	Planets PlanetTwo = new Planets(planet2);
	Planets PlanetThree = new Planets(planet3);
	Planets PlanetFour = new Planets(planet4);
	Planets PlanetFive = new Planets(planet5);
		 
	Paths Earth2Mars = new Paths(PlanetThree, PlanetOne, fuelThreeToOne);
	Paths Neptune2Uranus = new Paths(PlanetTwo, PlanetFour, fuelTwoToFour);
	Paths Pluto2Earth = new Paths(PlanetFive, PlanetThree, fuelFiveToThree);
	  
	@Test
	public void testGetPathDetails() {
		String expectedForEarthToMars = "It takes 500 gallons to go from Earth to Mars";
		assertEquals(expectedForEarthToMars, Earth2Mars.toString());
		
		
	}
	
	@Test
	public void testReadPlanetNames() {
		
	}
	
	@Test
	public void testReadPathsToPlanets() {
		
	}
	
	

}
