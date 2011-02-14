public class TestVariantSinus {
	
	public void plot() {
		
		Thread t = new Thread() {
			
			public void run() {
				
				XYPlotter plotter = new XYPlotter();
				
				plotter.showPlotter();
				
				double[] x = new double[1000];
				double[] y = new double[1000];
				
				double factor = 360d / (double)x.length;
				
				int waitTime = 50;
				
				while(!isInterrupted())
				{
					for(double j=1; j<=5; j+=0.0625)
					{
						for(int i=0; i<x.length; i++)
						{
							x[i] = i * factor;
							y[i] = Math.sin(j * i * Math.toRadians(factor));
						}
				
						plotter.updateData(x, y);

						try { Thread.sleep(waitTime); }
						catch (InterruptedException e) { e.printStackTrace(); }
					}
					
					for(double j=5; j>=1; j-=0.0625)
					{
						for(int i=x.length-1; i>=0; i--)
						{
							x[i] = i * factor;
							y[i] = Math.sin(j * i * Math.toRadians(factor));
						}
				
						plotter.updateData(x, y);

						try { Thread.sleep(waitTime); }
						catch (InterruptedException e) { e.printStackTrace(); }
					}
				}
			}
		};
		
		t.start();
	}

	public static void main(String[] args) {

		TestVariantSinus functionSolver = new TestVariantSinus();
		
		functionSolver.plot();
	}
}
