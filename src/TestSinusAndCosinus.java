
public class TestSinusAndCosinus {
	
	public void plot() {
		
		XYPlotter plotter = new XYPlotter();
		
		double[] x1 = new double[100];
		double[] y1 = new double[100];
		
		double[] x2 = new double[100];
		double[] y2 = new double[100];

		for(int i=0; i<x1.length; i++)
		{
			x1[i] = i * 3.6;
			y1[i] = Math.sin(i * Math.toRadians(3.6));
			
			x2[i] = i * 3.6;
			y2[i] = Math.cos(i * Math.toRadians(3.6));
		}

		plotter.updateData(x1, y1, x2, y2);
		
		plotter.showPlotter();
		
	}

	public static void main(String[] args) {

		TestSinusAndCosinus functionSolver = new TestSinusAndCosinus();
		
		functionSolver.plot();
	}

}
