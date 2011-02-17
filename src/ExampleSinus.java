public class ExampleSinus {
	
	public void plot() {
		
		XYPlotter plotter = new XYPlotter();	// cool, my own xy-plotter object
		
		double[] x = new double[100];	// get place for 100 x-values
		double[] y = new double[100];	// get place for 100 y-values
		
		// This loop starts at 0 and ends at 99
		// the x-value will be increasing by a step-width of 3.6
		// the sin-function needs the radiant of the angle
		for(int i=0; i<x.length; i++)
		{
			x[i] = i * 3.6;	// push the next value into x-array
			y[i] = Math.sin(i * Math.toRadians(3.6));	// solve and push the function-value into y-array
		}

		plotter.updateData(x, y);	// Now give the plotter the results, so it will paint a magic xy-plot
		
		plotter.showPlotter();		// to see the plot, make the frame visible
	}	

	public static void main(String[] args) {

		// get a new Object
		ExampleSinus functionSolver = new ExampleSinus();
		
		// call the plot-method
		functionSolver.plot();
	}
}
