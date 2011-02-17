public interface PlotterInterface {

	public void showPlotter();
	public void hidePlotter();
	public void updateData(double[] x, double[] y);
	public void updateData(double[] x, double[] y, double marksX, double marksY);
	public void updateData(double[] x, double[] y, double[] marksX, double[] marksY);
	public void message(String messageText);
}