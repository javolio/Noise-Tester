package UI;

import java.awt.Color;
import java.awt.Graphics;
import NoiseMakers.ContinuousNoiseMaker2D;

@SuppressWarnings("serial")
@Deprecated
public class NoisePanel2D extends NoisePanel {
	protected ContinuousNoiseMaker2D n;
	protected int xRange,yRange;
	protected double xScale,yScale;
	
	public NoisePanel2D(ContinuousNoiseMaker2D n,int width,int height,int xRange,int yRange) {
		super(width,height);
		this.n=n;
		this.xRange=xRange;
		this.yRange=yRange;
		xScale=1.*xRange/w;
		yScale=1.*yRange/h;
	}
	
	@Override
	public void paintComponent(Graphics page) {
		int c;
		for (int y1=0;y1<h;y1++)
			for (int x1=0;x1<w;x1++) {
				//c=(int) ((n1.get(x1*xScale)+n2.get((x1^y1)*yScale))/zScale);
				//c=(int) ((n1.get((x1^y1)*xScale)+n2.get((x1^y1)*yScale))/zScale);
				c=(int) (n.get(x1*xScale,y1*yScale)*255);
				page.setColor(new Color(c,c,c));
				page.fillRect(x1,y1,1,1);
			}
	}
}
