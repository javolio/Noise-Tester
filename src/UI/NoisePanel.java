package UI;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public abstract class NoisePanel extends JPanel {
	protected int w,h;
	
	public NoisePanel(int width,int height) {
		setPreferredSize(new Dimension(width,height));
		setSize(width,height);
		setMinimumSize(new Dimension(width,height));
		w=width;
		h=height;
	}
	
	public abstract void paintComponent(Graphics page);
}
