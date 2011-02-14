/*
XYPlotter:
A simple xyplotter based on JFreeChart.
Get JFreeChart under http://www.jfree.org/jfreechart/
 
Copyright (C) 2010 Karsten Bettray

Dieses Programm ist freie Software. Sie koennen es unter den Bedingungen der GNU General Public License,
wie von der Free Software Foundation veroeffentlicht, weitergeben und/oder modifizieren, entweder gemaess
Version 3 der Lizenz oder (nach Ihrer Option) jeder spaeteren Version.
Die Veroeffentlichung dieses Programms erfolgt in der Hoffnung, dass es Ihnen von Nutzen sein wird, aber
OHNE IRGENDEINE GARANTIE, sogar ohne die implizite Garantie der MARKTREIFE oder der VERWENDBARKEIT FUER
EINEN BESTIMMTEN ZWECK. Details finden Sie in der GNU General Public License.
Sie sollten ein Exemplar der GNU General Public License zusammen mit diesem Programm erhalten haben.
Falls nicht, siehe <http://www.gnu.org/licenses/>.
*/

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

// used sources: http://www.java2s.com/Code/Java/Chart/JFreeChartLineChartDemo1.htm
public class XYPlotter extends JFrame implements PlotterInterface
{
	private XYPlot plot = null;
	private XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
	private XYSeries series1 = null;
	private XYSeries series2 = null;
	private XYDataset xyDataset = null;
    private JFreeChart chart = null;
    private ChartPanel chartPanel = null;

	public XYPlotter(String legendTxt)
	{
		super("XY-Plotter");

		initFrame();
		
		createChart(legendTxt);
   }
 	
	/**
	 * Init the jframe
	 */
 	private void initFrame()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(Color.WHITE);
		setLayout(new GridLayout(1, 1));
		setSize(640, 480);
	}
    
    /**
     * Creates a chart.
     * 
     * @param dataset  the data for the chart.
     * 
     * @return a chart.
     */
    private void createChart(String legendTxt) {
        
        getContentPane().removeAll();
        
    	xyDataset = createDataset(legendTxt);
    	
        // create the chart...
        chart = ChartFactory.createXYLineChart(
            "",     				 // chart title	"Line Chart Demo 6"
            "x",					// x axis label
            "f(x)",					// y axis label
            xyDataset,                  // data
            PlotOrientation.VERTICAL,
            true,						// include legend
            true,						// tooltips
            false						// urls
        );

        // NOW DO SOME OPTIONAL CUSTOMISATION OF THE CHART...
        chart.setBackgroundPaint(Color.white);

        // get a reference to the plot for further customisation...
        plot = chart.getXYPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);

        renderer.setSeriesShapesVisible(0, false);
        renderer.setSeriesShapesVisible(1, false);

        plot.setRenderer(renderer);

        // change the auto tick unit selection to integer units only...
        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        // OPTIONAL CUSTOMISATION COMPLETED.
                
        chartPanel = new ChartPanel(chart);
        chartPanel.setLayout(new GridLayout(1, 1));
        getContentPane().add(chartPanel);
        
//        chartPanel.revalidate();
    }
    
    /**
     * Creates the dataset.
     * 
     * @return a sample dataset.
     */
    private XYDataset createDataset(String legendTxt) {

		series1 = new XYSeries("f(x)");
		series2 = new XYSeries("g(x)");
    	
        final XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series1);
        dataset.addSeries(series2);
        
        return dataset;        
    }
    
	@Override
	public void showPlotter() {
		
		setVisible(true);
 	}
	
	@Override
	public void hidePlotter() {
		
		setVisible(true);
	}

	/**
	 * update data of series1
	 */
	@Override
	public void updateData(double[] x, double[] y) {
		
		series1.clear();
    	series2.clear();
    	
    	if(x.length == y.length)
    		for(int i=0; i<x.length; i++)
    			series1.add(x[i], y[i]);
    	else
    		JOptionPane.showMessageDialog(null, "Array sizes of x and y are not equal!");
    	
    	chartPanel.revalidate();
	}
	
	/**
	 * Update data of series1 and series2
	 */
	@Override
	public void updateData(double[] x1, double[] y1, double[] x2, double[] y2) {
		
		series1.clear();
    	series2.clear();
    	
    	if(x1.length == y1.length)
    		for(int i=0; i<x1.length; i++)
    			series1.add(x1[i], y1[i]);
    	else
    		JOptionPane.showMessageDialog(null, "Array sizes of x1 and y1 are not equal!");
    	
    	if(x2.length == y2.length)
    		for(int i=0; i<x2.length; i++)
    			series1.add(x2[i], y2[i]);
    	else
    		JOptionPane.showMessageDialog(null, "Array sizes of x2 and y2 are not equal!");
    	
    	chartPanel.revalidate();
	}
	
	/**
	 * return the Chartpanel
	 * @return
	 */
 	public ChartPanel getChartPanel() {
 		
		return chartPanel;
	}
}