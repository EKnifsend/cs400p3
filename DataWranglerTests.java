
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
	  
	/**
	 * Test to check if the Paths and Planets method can get
	 * the correct fields of a custom graph
	 */
	@Test
	public void testGetPathAndPlanetDetails() {
		String expectedForEarthToMars = "It takes 500 gallons to go from Earth to Mars";
		assertEquals(expectedForEarthToMars, Earth2Mars.toString());
		
		int expectedFuelFromPlutoToEarth = 1000;
		assertEquals(expectedFuelFromPlutoToEarth, Pluto2Earth.getFuelCost());
		
	}
	
	/**
	 * Check to see if the readPlanetNames() can load the data from 
	 * the csv file properly to the list of planetName
	 * @throws IOException if file is not read properly
	 */
	@Test
	public void testReadPlanetNames() throws IOException {
		Reader filePathInput;
		filePathInput = new FileReader("solarsystem.csv");
		List<Planets> planetNames;
		SolarSystemDataReader readDataSet = new SolarSystemDataReader();
		
		planetNames = readDataSet.readPlanetNames(filePathInput);
		if(!planetNames.get(0).getName().equals("Mercury")) {
			fail("Didn't get the first correct planet name – should be Mercury");
		}
		if(!planetNames.get(9).getName().equals("Sun")) {
			fail("Didn't get the last correct planet name – should be Sun");
		}
		
	}
	
	/**
	 * Checks to see if the the readPaths() can get the correct
	 * paths from the csv file and put them in the list of pathToPlanets
	 * @throws IOException if file is not read properly
	 */
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
	
	/**
	 * Test to check if the read() method works, for every row in the csv file, it should create
	 * a string where data in each column is separated by a comma
	 * @throws IOException if file is not read properly
	 */
	@Test
	public void testRead() throws IOException {
		Reader filePathInput;
		filePathInput = new FileReader("solarsystem.csv");
		List<String> readPathsAndPlanets;
		SolarSystemDataReader readDataSet = new SolarSystemDataReader();
		
		readPathsAndPlanets = readDataSet.read(filePathInput);
		if(!readPathsAndPlanets.get(0).equals("Planet, Mercury")) {
			fail("Should have gotten – Planet, Mercury");
		}
		
		if(!readPathsAndPlanets.get(10).equals("Edge, Sun, Mercury, 400")) {
			fail("Should have gotten – Edge, Sun, Mercury, 400");
		}
		
	}


}
