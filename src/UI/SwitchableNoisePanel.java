package UI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.MemoryImageSource;
import NoiseMakers.ContinuousNoiseMaker;
import NoiseMakers.VariableOctaveSpectralSynthesisNoiseMaker;
import NoiseMakers.ContinuousNoiseMaker2D;

/**
 * A panel for displaying a {@link ContinuousNoiseMaker} or {@link ContinuousNoiseMaker2D}.
 * 
 * @author Joseph Avolio
 */
@SuppressWarnings("serial")
public class SwitchableNoisePanel extends NoisePanel {
	private boolean is2D;
	private ContinuousNoiseMaker n1;
	private ContinuousNoiseMaker2D n2;
	private double xScale,yScale,yScale1D;
	private int xRange,yRange;
	private Image image;
	
	/**
	 * Creates a panel instance with a given size
	 * 
	 * @param width The width of the display in pixels
	 * @param height The height of the display in pixels
	 * @param xRange The horizontal range for the noise function
	 * @param yRange The vertical range for the noise function
	 */
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
	
	/**
	 * Sets the horizontal range and refreshes the image
	 * 
	 * @param range The horizontal range for the noise function
	 */
	public void setXRange(int range) {
		xRange=range;
		xScale=1.*xRange/w;
		image=refreshImage();
	}
	
	/**
	 * Sets the vertical range and refreshes the image
	 * 
	 * @param range The vertical range for the noise function
	 */
	public void setYRange(int range) {
		yRange=range;
		yScale=1.*yRange/h;
		image=refreshImage();
	}
	
	/**
	 * Sets the NoiseMaker and refreshes the image
	 * 
	 * @param n The new {@link ContinuousNoiseMaker}
	 */
	public void setNoiseMaker(ContinuousNoiseMaker n) {
		n1=n;
		is2D=false;
		image=refreshImage();
	}
	
	/**
	 * Sets the NoiseMaker and refreshes the image
	 * 
	 * @param n The new {@link ContinuousNoiseMaker2D}
	 */
	public void setNoiseMaker(ContinuousNoiseMaker2D n) {
		n2=n;
		is2D=true;
		image=refreshImage();
	}
	
	/**
	 * Generate a new image for the current noise function at the proper range
	 * 
	 * @return The new image
	 */
	private Image refreshImage() {
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
				if (n1 instanceof VariableOctaveSpectralSynthesisNoiseMaker) {
					g.setColor(Color.GREEN);
					for (int x=1;x<w-1;x++) {
						g.drawLine(x,(int) (((VariableOctaveSpectralSynthesisNoiseMaker) n1).getOctaves(x*xScale)*yScale1D/yScale),x+1,(int) (((VariableOctaveSpectralSynthesisNoiseMaker) n1).getOctaves((x+1)*xScale)*yScale1D/yScale));
						g.drawLine(x,(int) (((VariableOctaveSpectralSynthesisNoiseMaker) n1).getOctaves(x*xScale)*yScale1D/yScale),x-1,(int) (((VariableOctaveSpectralSynthesisNoiseMaker) n1).getOctaves((x-1)*xScale)*yScale1D/yScale));
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
