package UI;

import java.awt.Color;
import java.awt.Graphics;
import NoiseMakers.NoiseMaker;

@SuppressWarnings("serial")
@Deprecated
public class NoisePanel1D extends NoisePanel {
	protected NoiseMaker n;
	protected double xScale,yScale;
	
	public NoisePanel1D(NoiseMaker n,int width,int height,int range) {
		super(width,height);
		this.n=n;
		xScale=1.*range/w; //Units per pixel
		yScale=h; //Pixels per unit
	}
	
	@Override
	public void paintComponent(Graphics page) {
		page.setColor(Color.BLACK);
		page.fillRect(0,0,w,h);
		page.setColor(Color.BLUE);
		for (int x1=1;x1<w-1;x1++) {
			page.drawLine(x1,(int) (n.get(x1*xScale)*yScale),x1+1,(int) (n.get((x1+1)*xScale)*yScale));
			page.drawLine(x1,(int) (n.get(x1*xScale)*yScale),x1-1,(int) (n.get((x1-1)*xScale)*yScale));
		}
	}
}
