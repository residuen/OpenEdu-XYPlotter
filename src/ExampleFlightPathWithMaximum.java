import java.util.ArrayList;

/**
 * formula of flightpath: y(x) = tan(beta)*x - g*x^2/( 2*v0^2*cos^2(beta) )
 * This example solves the functionvalues- and the maximumpoint of the flightpath
 * @author bettray
 */
public class ExampleFlightPathWithMaximum extends SolveAndPlot {
	
	public void plot() {
		
		ArrayList<Double> xValueList = new ArrayList<Double>();	// this list gets all new functionvalues (the x-values)
		ArrayList<Double> yValueList = new ArrayList<Double>();	// this list gets all new functionvalues (the y-values)
		
		double maxX = 0;	// x-coordinate for maximum you are searching for
		double maxY = 0;	// y-coordinate for maximum you are searching for
		
		double[] x;			// array variable for x, needed later to push it into the plotter
		double[] y;			// array variable for y, needed later to push it into the plotter
		
		double beta = 40; 	// startangle
		double g = 9.81;	// gravity
		double v0 = 25;		// startspeed
		
		int i=0;			// count variable
		
		do
		{
			xValueList.add((double)i );	// lets add the x-value
			
			// solve and add the function-value
			yValueList.add( Math.tan(Math.toRadians(beta))*i - (g * i*i)/(2 * v0*v0 * Math.cos(Math.toRadians(beta))*Math.cos(Math.toRadians(beta))) );
			
			// compare the last with the current function-value, so you can test for the maximum
			if(maxY < yValueList.get(i))
			{
				maxX = (double)i;
				maxY = yValueList.get(i);
			}
			
			i++;	// increase the counter
		}
		while(yValueList.get(i-1) >= 0);	// test, if the functionvalue is bigger than zero
		
		x = toArray(xValueList);	// convert the list of x-values to an array of x-values
		y = toArray(yValueList);	// convert the list of y-values to an array of y-values
		
		plotter.updateData(x, y, maxX, maxY);	// Now give the plotter the results, so it will paint a magic xy-plot
		
		plotter.showPlotter();					// to see the plot, make the frame visible
	}

	public static void main(String[] args) {

		// get a new Object
		ExampleFlightPathWithMaximum functionSolver = new ExampleFlightPathWithMaximum();
		
		// call the plot-method
		functionSolver.plot();
	}
}
