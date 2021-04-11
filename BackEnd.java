import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.zip.DataFormatException;

// --== CS400 File Header Information ==--
// Name: Jessica Xu
// Email: jxxu2@wisc.edu
// Team: FB blue
// Role: Backend developer
// TA: Daniel Finer
// Lecturer: Gary Dahl
// Notes to Grader:

/**
 * Backend has methods that will allow frontend to interact with the data
 * provided. Backend takes data from csv file and puts it into a graph.
 * 
 * @author xujessica
 *
 */
public class BackEnd {
	protected List<Planets> planetsList;
	protected List<Paths> pathsList;
	private int size; // size of paths in graph
	protected CS400Graph<Planets> solarSystem;

	/**
	 * Constructor for BackEnd object which takes in string from the user to put as
	 * elements in the graph
	 * 
	 * @param input the data specified by the user to input the reservation
	 * @throws FileNotFoundException if the csv file is not found
	 */
	public BackEnd(String input) throws FileNotFoundException, IOException {
		SolarSystemDataReader dataReader = new SolarSystemDataReader();
		try {
			planetsList = dataReader.readPlanetNames(new StringReader(input));
			pathsList = dataReader.readPaths(new StringReader(input));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			initializeGraph();
		}
	}

	/**
	 * Constructor for BackEnd object which takes a filepath from the user (console)
	 * 
	 * @param filepath Reader object that contains the filepath
	 */
	public BackEnd(Reader filepath) throws FileNotFoundException, IOException {
		SolarSystemDataReader dataReader = new SolarSystemDataReader();
		try {
			planetsList = dataReader.readPlanetNames(filepath);
			pathsList = dataReader.readPaths(filepath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			initializeGraph();
		}
	}

	/**
	 * Private helper method to initialize the graph once the BackEnd Object is
	 * created and the add all the Planet data to the graph
	 */
	public void initializeGraph() {

		solarSystem = new CS400Graph<Planets>();

		// add all the planets to the graph
		for (int i = 0; i < planetsList.size(); i++) {
			solarSystem.insertVertex(planetsList.get(i));
		}

		// add all the paths to the graph
		for (int i = 0; i < pathsList.size(); i++) {
			solarSystem.insertEdge(pathsList.get(i).getStart(), pathsList.get(i).getStart(),
					pathsList.get(i).getFuelCost());
			size++;
		}
	}

	/**
	 * Method that adds planet to graph
	 * 
	 * @param planet
	 * @return true if added successfully, false otherwise
	 */
	public boolean addPlanet(String planet) {
		if (!solarSystem.containsVertex(new Planets(planet))) {
			solarSystem.insertVertex(new Planets(planet));
			return true;
		}
		return false;
	}

	/**
	 * Method that adds path from a planet to another
	 * 
	 * @param planet
	 * @param path
	 * @return true if added successfully, false otherwise
	 */
	public boolean addPath(String start, String end, int path) {
		Planets startPlanet = new Planets(start);
		Planets endPlanet = new Planets(end);

		// adds start planet if solarSystem doesn't contain it
		if (!solarSystem.containsVertex(startPlanet)) {
			addPlanet(start);
		}

		// adds end planet if solarSystem doesn't contain it
		if (!solarSystem.containsVertex(endPlanet)) {
			addPlanet(end);
		}

		// adds edge if solarSystem doesn't contain it
		if (!solarSystem.containsEdge(startPlanet, endPlanet)) {
			solarSystem.insertEdge(startPlanet, endPlanet, path);
			size++;
			return true;
		}
		
		return false;
	}

	/**
	 * Method that removes a planet
	 * 
	 * @param planet
	 * @return true if removed successfully, false otherwise
	 */
	public boolean removePlanet(String planet) {
		if (solarSystem.containsVertex(new Planets(planet))) {
			solarSystem.removeVertex(new Planets(planet));
			return true;
		}
		return false;
	};

	/**
	 * Method that removes a path
	 * 
	 * @param start, end
	 * @return true if removed successfully, false otherwise
	 */
	public boolean removePath(String start, String end) {
		if (solarSystem.containsEdge(new Planets(start), new Planets(end))) {
			solarSystem.removeEdge(new Planets(start), new Planets(end));
			return true;
		}
		return false;
	};

	/**
	 * Method that returns list of all the planets and their paths in string format
	 * will format like this: Paths from <Planet> : <Planet> takes <fuelCost> to go
	 * to <OtherPlanet>
	 * 
	 * @return List<Planet>
	 */
	public String getAllPlanets() {
		String output = "";
		for (int i = 0; i < planetsList.size(); i++) {
			output += "\nPaths from " + planetsList.get(i).getName() + ":\n";

			for (int j = 0; j < pathsList.size(); j++) {
				if (pathsList.get(i).getStart().getName().equals(planetsList.get(i).getName())) {
					output += "\t" + pathsList.get(i).toString() + "\n";
				}
			}
		}
		return output;
	}

	/**
	 * Method that calculates the shortest path between two specified planets and
	 * then the fuel cost. return -1 if it does not exist.
	 * 
	 * @param start
	 * @param end
	 * @return fuel cost
	 */
	public int getFuelCost(String start, String end) throws NoSuchElementException {
		Planets startPlanet = new Planets(start);
		Planets endPlanet = new Planets(end);

		if (!solarSystem.containsEdge(startPlanet, endPlanet)) {
			return -1;
		}

		return solarSystem.getPathCost(new Planets(start), new Planets(end));
	}

	/**
	 * Method that returns list of all planets that the specified planet can go to
	 * 
	 * @param planet
	 * @return
	 */
	public List<Paths> getPlanetPaths(String planet) {

		List<Paths> output = new ArrayList<Paths>();
		for (int i = 0; i < pathsList.size(); i++) {
			if (pathsList.get(i).getStart().getName().equals(planet)) {
				output.add(pathsList.get(i));
			}
		}

		return output;
	}

	/**
	 * To get the total number of paths in the graph
	 * 
	 * @return number of paths
	 */
	public int getSize() {
		return size;
	}

}

// doesn't the Planets object have to contain info for planets it goes to and the fuel costs
// i think we should only have one csv file

// or list of paths so make a path object with start, end, and fuel cost
// planet can just contain name

// so make graph of just planets then add from paths list
