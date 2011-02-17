import java.util.ArrayList;


public class SolveAndPlot {

	protected XYPlotter plotter = new XYPlotter();

	public void plot() {
		
		/**
		 * Space for your magic code
		 */
	}
	
	/**
	 * Convert the arraylist of doubles to an double-array
	 * @param listOfDoubles
	 * @return
	 */
	protected double[] toArray(ArrayList<Double> listOfDoubles)
	{
		double[] arrayOfDoubles = new double[listOfDoubles.size()];
		
		for(int i=0; i<arrayOfDoubles.length; i++)
			arrayOfDoubles[i] = listOfDoubles.get(i);

		return arrayOfDoubles;
	}
}
