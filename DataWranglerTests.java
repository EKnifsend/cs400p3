
// --== CS400 File Header Information ==--
// Name: Gabriela Setyawan
// Email: gsetyawan@wisc.edu
// Team: Blue
// Role: Data Wrangler
// TA: Daniel Finer
// Lecturer: Gary Dahl
// Notes to Grader: N/A
import static org.junit.jupiter.api.Assertions.*;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

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
	public void testReadPlanetNames() throws IOException {
		Reader filePathInput;
		filePathInput = new FileReader("solarsystem.csv");
		List<Planets> planetNames;
		SolarSystemDataReader readDataSet = new SolarSystemDataReader();
		
		planetNames = readDataSet.readPlanetNames(filePathInput);
		System.out.print("Test");
		if(!planetNames.get(0).getName().equals("Mercury")) {
			fail("Didn't get the first correct planet name – should be Mercury");
		}
		if(!planetNames.get(9).getName().equals("Sun")) {
			fail("Didn't get the last correct planet name – should be Sun");
		}
		
	}
	
	@Test
	public void testReadPathsToPlanets() throws IOException {
		Reader filePathInput;
		filePathInput = new FileReader("solarsystem.csv");
		List<Paths> pathToPlanets;
		SolarSystemDataReader readDataSet = new SolarSystemDataReader();
		
		pathToPlanets = readDataSet.readPaths(filePathInput);
		if(pathToPlanets.get(0).getFuelCost() != 400) {
			fail("Did not get the right cost");
		}
		
		if(!pathToPlanets.get(9).getEnd().getName().equals("Uranus")) {
			fail("Should have returned Uranus as the target planet vertex");
		}
		
	}
	
	

}