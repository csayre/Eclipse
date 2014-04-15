package de.ifgl.lodnasa.tutorial;
import gov.nasa.worldwind.BasicModel;
import gov.nasa.worldwind.awt.WorldWindowGLCanvas;

import javax.swing.*;

public class View extends JFrame {

		// TODO Auto-generated method stub
		  public View()
		    {
		        WorldWindowGLCanvas wwd = new WorldWindowGLCanvas();
		        wwd.setPreferredSize(new java.awt.Dimension(1000, 800));
		        this.getContentPane().add(wwd, java.awt.BorderLayout.CENTER);
		        wwd.setModel(new BasicModel());
		    }
	}


