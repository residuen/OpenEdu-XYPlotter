public class TestSinus {
	
	public void plot() {
		
		XYPlotter plotter = new XYPlotter();
		
		double[] x = new double[100];
		double[] y = new double[100];
		
		for(int i=0; i<x.length; i++)
		{
			x[i] = i * 3.6;
			y[i] = Math.sin(i * Math.toRadians(3.6));
		}

		plotter.updateData(x, y);
		
		plotter.showPlotter();	
	}

	public static void main(String[] args) {

		TestSinus functionSolver = new TestSinus();
		
		functionSolver.plot();
	}
}
