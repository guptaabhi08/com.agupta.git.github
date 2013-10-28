package com.agupta.applets;

import java.applet.Applet;
import java.awt.Graphics;

@SuppressWarnings("serial")
public class TrivialApplet extends Applet{
	public void paint(Graphics g) {
		g.drawString("Hello! How are you?", 20, 20);
	}
}
