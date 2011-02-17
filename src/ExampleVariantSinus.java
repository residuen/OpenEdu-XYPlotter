public class ExampleVariantSinus {
	
	public void plot() {
		
		// get a new thread with the embedded function-solving
		Thread t = new Thread() {
			
			public void run() {
				
				XYPlotter plotter = new XYPlotter();	// cool, my own xy-plotter object
				
				double[] x = new double[1000];	// get place for 1000 x-values
				double[] y = new double[1000];	// get place for 1000 y-values
				
				plotter.showPlotter();			// to see the plot, make the frame visible
				
				double factor = 360d / (double)x.length;	// the stepfactor for the x-values
				
				int waitTime = 50;			// the sleeptime, before the next periode will be solved
				
				while(!isInterrupted())		// the endless loop starts here
				{
					for(double j=1; j<=5; j+=0.0625)	// outer loop, to change the frequency with each periode
					{
						for(int i=0; i<x.length; i++)	// inner loop, solves the sinus-function
						{
							x[i] = i * factor;			// push the next value into x-array
							
							// solve and push the function-value into y-array
							// j gives the changing of the freqquency
							y[i] = Math.sin(Math.toRadians(x[i] * j));	
						}
				
						plotter.updateData(x, y);	// push the new function-values to the plotter 

						// wait for a while, so make an animation possible
						try { Thread.sleep(waitTime); }
						catch (InterruptedException e) { e.printStackTrace(); }
					}
					
					for(double j=5; j>=1; j-=0.0625)		// outer loop, to change the frequency with each periode
					{
						for(int i=x.length-1; i>=0; i--)	// inner loop, solves the sinus-function
						{
							x[i] = i * factor;				// push the next value into x-array
							
							// solve and push the function-value into y-array
							// j gives the changing of the freqquency
							y[i] = Math.sin(Math.toRadians(x[i] * j));
						}
				
						plotter.updateData(x, y);	// push the new function-values to the plotter 

						// wait for a while, so make an animation possible
						try { Thread.sleep(waitTime); }
						catch (InterruptedException e) { e.printStackTrace(); }
					}
				}
			}
		};
		
		t.start();	// Start the thread
	}

	public static void main(String[] args) {

		// get a new Object
		ExampleVariantSinus functionSolver = new ExampleVariantSinus();
		
		// call the plot-method
		functionSolver.plot();
	}
}
