import java.util.List;

// --== CS400 File Header Information ==--
// Name: Jessica Xu
// Email: jxxu2@wisc.edu
// Team: FB blue
// Role: Backend developer
// TA: Daniel Finer
// Lecturer: Gary Dahl
// Notes to Grader: 

/**
 * This interface is part of the starter archive for the Front End developers 
 * @author xujessica
 * @param <T>
 *
 */
public interface BackendInterface<T> {
	public void intializeGraph();
	public boolean addPlanet(String planet);
	public boolean addPath(String start, String end, int path); // adds path to specified planet
	public boolean removePlanet(String planet); // removes planet’s paths too
	public boolean removePath(String start, String end);
	public List<Planets> getAllPlanets();
	public int getFuelCost(Planets start, Planets end); // returns shortest path (fuel cost) 
	public List<Planets> getPlanetPaths(Planets planet); // returns list of all planets and the fuel cost a 
														//specified planet goes to



}
