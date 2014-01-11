package NoiseMakers;

/**
 * Uses a {@link ContinuousNoiseMaker2D} and shifts the input to generate noise over a continuous 2D domain. The input shift is determined for each point by two other {@link ContinuousNoiseMaker2D ContinuousNoiseMaker2Ds}.
 * 
 * @author Joseph Avolio 
 */
public class TurbulenceNoiseMaker2D implements ContinuousNoiseMaker2D {
	ContinuousNoiseMaker2D continuousNoise;
	ContinuousNoiseMaker2D turbulenceNoiseX;
	ContinuousNoiseMaker2D turbulenceNoiseY;
	protected double shift;
	
	/**
	 * Creates a noise instance
	 * 
	 * @param continuousNoise The base noise
	 * @param turbulenceNoiseX The noise for determining the x input shift
	 * @param turbulenceNoiseY The noise for determining the y input shift
	 * @param maxShift The scale for the maximum input displacement
	 */
	public TurbulenceNoiseMaker2D(ContinuousNoiseMaker2D continuousNoise,ContinuousNoiseMaker2D turbulenceNoiseX,ContinuousNoiseMaker2D turbulenceNoiseY,double maxShift) {
		this.continuousNoise=continuousNoise;
		this.turbulenceNoiseX=turbulenceNoiseX;
		this.turbulenceNoiseY=turbulenceNoiseY;
		shift=maxShift;
	}
	
	@Override
	public double get(double x,double y) {
		return continuousNoise.get(x+getXShift(x,y),y+getYShift(x,y));
	}
	
	/**
	 * Calculate the x input shift at a point
	 * 
	 * @param x The x coordinate of the position
	 * @param y The y coordinate of the position
	 * @return The x input shift at (x, y)
	 */
	public double getXShift(double x,double y) {
		return shift*turbulenceNoiseX.get(x,y);
	}
	
	/**
	 * Calculate the y input shift at a point
	 * 
	 * @param x The x coordinate of the position
	 * @param y The y coordinate of the position
	 * @return The y input shift at (x, y)
	 */
	public double getYShift(double x,double y) {
		return shift*turbulenceNoiseY.get(x,y);
	}
}
