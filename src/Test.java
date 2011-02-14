
public class Test {
	
	public void plot() {
		
		XYPlotter plotter = new XYPlotter("Mein Legendentext");
		
		double[] x = new double[100];
		double[] y = new double[100];
		
		for(int i=0; i<x.length; i++)
		{
			x[i] = i * 3.6;
			y[i] = Math.sin(i * Math.toRadians(3.6));
		}
		
		plotter.showPlotter();

		plotter.updateData(x, y);
		
//		plotter.showPlotter();
		
	}

	public static void main(String[] args) {

		Test functionSolver = new Test();
		
		functionSolver.plot();
	}

}
