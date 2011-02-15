import java.util.ArrayList;

/**
 * formula of flightpath: y(x) = tan(beta)*x - g*x^2/( 2*v0^2*cos^2(beta) )
 * @author bettray
 */
public class ExampleFlightPathWithMaximum {
	
	public void plot() {
		
		XYPlotter plotter = new XYPlotter();
		
		ArrayList<Double> x = new ArrayList<Double>();
		ArrayList<Double> y = new ArrayList<Double>();
		
		double[] maxX = new double[1];
		double[] maxY = new double[1];
		
		double[] retX;
		double[] retY;
		
		double beta = 45, g = 9.81, v0 = 30;
		int i=0;
		do
		{
			x.add( (double)i );
			y.add( Math.tan(Math.toRadians(beta))*i - (g * i*i)/(2 * v0*v0 * Math.cos(Math.toRadians(beta))*Math.cos(Math.toRadians(beta))) );
			
			if(maxY[0] < y.get(i))
			{
				maxX[0] = (double)i;
				maxY[0] = y.get(i);
			}
			
			i++;
		}
		while(y.get(i-1) >= 0);
		
		retX = toArray(x);
		retY = toArray(y);
		
		plotter.updateData(retX, retY, maxX, maxY);
		
		plotter.showPlotter();	
	}
	
	/**
	 * Convert the arraylist of doubles to an double-array
	 * @param listOfDoubles
	 * @return
	 */
	private double[] toArray(ArrayList<Double> listOfDoubles)
	{
		double[] arrayOfDoubles = new double[listOfDoubles.size()];
		
		for(int i=0; i<arrayOfDoubles.length; i++)
			arrayOfDoubles[i] = listOfDoubles.get(i);

		return arrayOfDoubles;
	}

	public static void main(String[] args) {

		ExampleFlightPathWithMaximum functionSolver = new ExampleFlightPathWithMaximum();
		
		functionSolver.plot();
	}
}
