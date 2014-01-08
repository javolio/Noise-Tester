package UI;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 * A panel.
 * 
 * @author Joseph Avolio
 */
@SuppressWarnings("serial")
public abstract class NoisePanel extends JPanel {
	protected int w,h;
	
	/**
	 * Creates a panel instance with a given size
	 * 
	 * @param width The width of the display in pixels
	 * @param height The height of the display in pixels
	 */
	public NoisePanel(int width,int height) {
		setPreferredSize(new Dimension(width,height));
		setSize(width,height);
		setMinimumSize(new Dimension(width,height));
		w=width;
		h=height;
	}
	
	@Override
	public abstract void paintComponent(Graphics page);
}
