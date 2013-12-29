package UI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.MemoryImageSource;
import NoiseMakers.NoiseMaker;
import NoiseMakers.AvolioNoiseMaker;
import NoiseMakers.NoiseMaker2D;

@SuppressWarnings("serial")
public class SwitchableNoisePanel extends NoisePanel {
	private boolean is2D;
	private NoiseMaker n1;
	private NoiseMaker2D n2;
	private double xScale,yScale,yScale1D;
	private int xRange,yRange;
	private Image image;
	
	public SwitchableNoisePanel(int width,int height,int xRange,int yRange) {
		super(width,height);
		is2D=false;
		setXRange(xRange);
		setYRange(yRange);
		yScale1D=1;
		image=refreshImage();
	}
	
	@Override
	public void paintComponent(Graphics page) {
		page.drawImage(image,0,0,null);
	}
	
	public void setXRange(int range) {
		xRange=range;
		xScale=1.*xRange/w;
		image=refreshImage();
	}
	
	public void setYRange(int range) {
		yRange=range;
		yScale=1.*yRange/h;
		image=refreshImage();
	}
	
	public void setNoiseMaker(NoiseMaker n) {
		n1=n;
		is2D=false;
		image=refreshImage();
	}
	
	public void setNoiseMaker(NoiseMaker2D n) {
		n2=n;
		is2D=true;
		image=refreshImage();
	}
	
	public Image refreshImage() {
		if (!is2D) { //1-Dimensional
			BufferedImage i=new BufferedImage(w,h,BufferedImage.TYPE_INT_ARGB);
			Graphics g=i.createGraphics();
			g.setColor(Color.BLACK);
			g.fillRect(0,0,w,h);
			if (n1!=null) {
				g.setColor(Color.BLUE);
				for (int x=1;x<w-1;x++) {
					g.drawLine(x,(int) (n1.get(x*xScale)*yScale1D/yScale),x+1,(int) (n1.get((x+1)*xScale)*yScale1D/yScale));
					g.drawLine(x,(int) (n1.get(x*xScale)*yScale1D/yScale),x-1,(int) (n1.get((x-1)*xScale)*yScale1D/yScale));
				}
				if (n1 instanceof AvolioNoiseMaker) {
					g.setColor(Color.GREEN);
					for (int x=1;x<w-1;x++) {
						g.drawLine(x,(int) (((AvolioNoiseMaker) n1).getDepth(x*xScale)*yScale1D/yScale),x+1,(int) (((AvolioNoiseMaker) n1).getDepth((x+1)*xScale)*yScale1D/yScale));
						g.drawLine(x,(int) (((AvolioNoiseMaker) n1).getDepth(x*xScale)*yScale1D/yScale),x-1,(int) (((AvolioNoiseMaker) n1).getDepth((x-1)*xScale)*yScale1D/yScale));
					}
				}
			}
			return i;
		} else { //2-Dimensional
			if (n2!=null) {
				int[] map=new int[w*h];
				int c,i=0;
				for (int y=0;y<h;y++) {
					for (int x=0;x<w;x++) {
						c=(int) (n2.get(x*xScale,y*yScale)*255); //Convert to 8-bit unsigned int
						map[i++]=255<<24|c<<16|c<<8|c;
					}
				}
				MemoryImageSource source=new MemoryImageSource(w,h,map,0,w);
				return createImage(source);
			} else {
				BufferedImage i=new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);
				Graphics g=i.createGraphics();
				g.setColor(Color.BLACK);
				g.fillRect(0,0,w,h);
				return i;
			}
		}
	}
}
