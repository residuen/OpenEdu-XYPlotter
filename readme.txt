XYPlotter is an open-source tool, that plots xy-linecharts.
It based upon JFreeChart, an opensource charting API. 
This program is written in Java.

For more information, see the website at http://residuen.github.com/XYPlotter/

To report a bug or a make a suggestions, mail to:
kbay@gmx.de

INSTALLATION
The following JFreeChart-files has to be added to your project:
- jcommon-1.0.16.jar
- jfreechart-1.0.13.jar
Copy it into your project-path and add it as a project-library
You can get the file at http://www.jfree.org/jfreechart/

USAGE
To use the class only following lines are  required:
...
XYPlotter plotter = new XYPlotter();	// get a new instance
...
double[] x = new double[100];
double[] y = new double[100];
...
plotter.updateData(x, y);				// push two double-array x[] and y[] to the plotter
plotter.showPlotter();					// show the plotter on screen
...

CREDITS
XYPlotter is an open source project, supported presently by me.
Most used icons are from http://tango.freedesktop.org/Tango_Icon_Library