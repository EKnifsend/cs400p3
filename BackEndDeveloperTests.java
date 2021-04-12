//--== CS400 File Header Information ==--
//Name: Jessica Xu
//Email: jxxu2@wisc.edu
//Team: FB blue
//Role: Backend developer
//TA: Daniel Finer
//Lecturer: Gary Dahl
//Notes to Grader:

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

/**
 * Class that tests the methods in Backend.java
 * 
 * @author xujessica
 *
 */
class BackEndDeveloperTests {

	/**
	 * Test to see if a BackEnd object is created correctly (check to see if size is
	 * correct based on the data input and BackEnd is not null)
	 * 
	 * @throws FileNotFoundException if csv file is not found
	 * @throws NullPointerException  if BackEnd object is not created
	 */
	@Test
	public void testBackEndObject() throws NullPointerException, FileNotFoundException {
		String dataInput = "Planet,Mercury\n" + "Edge,Sun,Mercury,400\n" + "Edge,Sun,Venus,700";

		Reader filePathInput = new FileReader("solarsystem.csv");
		BackEnd backEnd1;
		BackEnd backEnd2;
		// size is the number of paths (edges)
		int expectedSizeForBE1 = 22;
		int expectedSizeForBE2 = 2;
		try {
			backEnd1 = new BackEnd(filePathInput); // backEnd object using the csv file as the data input
			backEnd2 = new BackEnd(dataInput); // backEnd object constructed using the
			if (backEnd1.getSize() != expectedSizeForBE1) { // test to check if the size corresponds to the number of
															// rows in the csv file (41)
				fail("Did not successfully add planets to the graph");
			}
			if (backEnd2.getSize() != expectedSizeForBE2) { // test to check if the size corresponds to the number of
															// elements from the dataInput (3)
				fail("Did not successfully add planets to the graph");
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (NullPointerException e) {
			fail("The backEnd object is still null");
		}
	}

	/**
	 * Test to see if correct planet is being added
	 */
	@Test
	public void testAddPlanet() throws FileNotFoundException {
		Reader filePathInput = new FileReader("solarsystem.csv");
		BackEnd backEnd;

		try {
			backEnd = new BackEnd(filePathInput);
			backEnd.addPlanet("Athens");
			assertEquals(true, backEnd.getAllPlanets().contains("Athens")); // check if added planet Athens correctly
			backEnd.addPlanet("Morocco");
			assertEquals(true, backEnd.getAllPlanets().contains("Morocco")); // check if added planet Morocco correctly
			backEnd.addPlanet("Honolulu");
			assertEquals(true, backEnd.getAllPlanets().contains("Honolulu")); // check if added planet Honolulu
																				// correctly
		} catch (IOException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			System.out.print("Input is not valid");
		}
	}

	/**
	 * Test to see if correct planet is being removed
	 */
	@Test
	public void testRemovePlanet() throws FileNotFoundException {
		Reader filePathInput = new FileReader("solarsystem.csv");
		BackEnd backEnd;

		try {
			backEnd = new BackEnd(filePathInput);
			backEnd.addPlanet("Athens");
			backEnd.addPlanet("Morocco");
			backEnd.addPlanet("Honolulu");
			backEnd.removePlanet("Athens");
			backEnd.removePlanet("Morocco");
			backEnd.removePlanet("Honolulu");
			assertEquals(false, backEnd.getAllPlanets().contains("Athens")); // check if added planet Athens correctly
			assertEquals(false, backEnd.getAllPlanets().contains("Morocco")); // check if added planet Morocco correctly
			assertEquals(false, backEnd.getAllPlanets().contains("Honolulu")); // check if added planet Honolulu
																				// correctly
		} catch (IOException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			System.out.print("Input is not valid");
		}
	}

	/**
	 * Test to see if correct path is being added
	 */
	@Test
	public void testAddPath() throws FileNotFoundException {
		Reader filePathInput = new FileReader("solarsystem.csv");
		BackEnd backEnd;

		try {
			backEnd = new BackEnd(filePathInput);
			backEnd.addPath("Mars", "Sun", 300);
			assertEquals(300, backEnd.getFuelCost("Mars", "Sun"));
			backEnd.addPath("Saturn", "Jupiter", 6000);
			assertEquals(6000, backEnd.getFuelCost("Saturn", "Jupiter"));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			System.out.print("Input is not valid");
		}
	}

	/**
	 * Test to see if correct planet is being removed
	 */
	@Test
	public void testRemovePath() throws FileNotFoundException {
		Reader filePathInput = new FileReader("solarsystem.csv");
		BackEnd backEnd;

		try {
			backEnd = new BackEnd(filePathInput);
			backEnd.addPath("Mars", "Mercury", 300);
			backEnd.addPath("Venus", "Jupiter", 6000);
			assertEquals(true, backEnd.removePath("Mars", "Mercury"));
			assertEquals(true, backEnd.removePath("Venus", "Jupiter"));
			try {
				if (backEnd.getFuelCost("Mars", "Mercury") == 300) {
					fail("Should have failed because there should not be a path between Mars and Mercury");
				}
			} catch (NoSuchElementException e) {
				// should catch the exception
			}
			try {
				if (backEnd.getFuelCost("Venus", "Jupiter") == 6000) {
					fail("Should have failed because there should not be a path between Venus and Jupiter");
				}
			} catch (NoSuchElementException e) {
				// should catch the exception
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			System.out.print("Input is not valid");
		}
	}

	/**
	 * Test to see that backend returns correct planet paths by checking that it
	 * returns the correct planet and fuel cost
	 */
	@Test
	public void testGetPlanetPaths() throws FileNotFoundException {
		Reader filePathInput = new FileReader("solarsystem.csv");
		BackEnd backEnd;

		try {
			backEnd = new BackEnd(filePathInput);
			backEnd.addPlanet("Athens");
			backEnd.addPlanet("Morocco");
			backEnd.addPlanet("Honolulu");
			backEnd.addPath("Athens", "Morocco", 400);
			backEnd.addPath("Morocco", "Honolulu", 500);
			backEnd.addPath("Honolulu", "Athens", 600);
			assertEquals("Morocco", backEnd.getPlanetPaths("Athens").get(0).getEnd().getName());
			assertEquals(400, backEnd.getFuelCost("Athens", "Morocco"));
			assertEquals("Honolulu", backEnd.getPlanetPaths("Morocco").get(0).getEnd().getName());
			assertEquals(500, backEnd.getFuelCost("Morocco", "Honolulu"));
			assertEquals("Athens", backEnd.getPlanetPaths("Honolulu").get(0).getEnd().getName());
			assertEquals(600, backEnd.getFuelCost("Honolulu", "Athens"));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			System.out.print("Input is not valid");
		}
	}

}
