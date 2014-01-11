package NoiseMakers;

/**
 * Uses a {@link ContinuousNoiseMaker} and shifts the input to generate noise over a continuous 1D domain. The input shift is determined for each point by another {@link ContinuousNoiseMaker}.
 * 
 * @author Joseph Avolio 
 */
public class TurbulenceNoiseMaker implements ContinuousNoiseMaker {
	ContinuousNoiseMaker continuousNoise;
	ContinuousNoiseMaker turbulenceNoise;
	protected double shift;
	
	/**
	 * Creates a noise instance
	 * 
	 * @param continuousNoise The base noise
	 * @param turbulenceNoise The noise for determining the input shift
	 * @param maxShift The scale for the maximum input displacement
	 */
	public TurbulenceNoiseMaker(ContinuousNoiseMaker continuousNoise,ContinuousNoiseMaker turbulenceNoise,double maxShift) {
		this.continuousNoise=continuousNoise;
		this.turbulenceNoise=turbulenceNoise;
		shift=maxShift;
	}
	
	@Override
	public double get(double x) {
		return continuousNoise.get(x+getXShift(x));
	}
	
	/**
	 * Calculate the input shift at a point
	 * 
	 * @param x The position
	 * @return The input shift at x
	 */
	public double getXShift(double x) {
		return shift*turbulenceNoise.get(x);
	}
}
