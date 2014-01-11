package NoiseMakers;

/**
 * Uses a {@link ContinuousNoiseMaker2D} and recursively sums compressed copies to generate noise over a continuous 2D domain. Floating-point octave counts are determined for each point by a second noise function.
 * 
 * @author Joseph Avolio
 */
public class VariableOctaveSpectralSynthesisNoiseMaker2D implements ContinuousNoiseMaker2D {
	ContinuousNoiseMaker2D continuousNoise;
	ContinuousNoiseMaker2D octaveNoise;
	protected int m;
	protected double scale,stretch;
	
	/**
	 * Creates a noise instance
	 * 
	 * @param continuousNoise The {@link ContinuousNoiseMaker2D} for spectral synthesis
	 * @param octaveNoise The {@link ContinuousNoiseMaker2D} to determine the number of octaves at a point
	 * @param maxOctaves The highest number of octaves possible
	 * @param stretch How much to stretch out the octaveNoise function. A stretch of 1 is no stretch; a stretch of 2 has half the frequency
	 */
	public VariableOctaveSpectralSynthesisNoiseMaker2D(ContinuousNoiseMaker2D continuousNoise,ContinuousNoiseMaker2D octaveNoise,int maxOctaves,double stretch) {
		this.continuousNoise=continuousNoise;
		this.octaveNoise=octaveNoise;
		m=maxOctaves;
		scale=2-1/(1<<m-1);
		this.stretch=stretch;
	}
	
	@Override
	public double get(double x,double y) {
		double sum=0;
		double d=getOctaves(x,y);
		for (int i=0;i<d;i++)
			sum+=continuousNoise.get(x*(1<<i),y*(1<<i))/(1<<i);
		sum+=continuousNoise.get(x*(1<<(int) d+1),y*(1<<(int) d+1))/(1<<(int) d+1)*(d-(int) d);
		return sum/scale;
	}
	
	/**
	 * Calculate the number of octaves at a point
	 * 
	 * @param x The x coordinate of the position
	 * @param y The y coordinate of the position
	 * @return The number of octaves at (x, y)
	 */
	public double getOctaves(double x,double y) {
		return octaveNoise.get(x/stretch,y/stretch)*(m-1)+1; // [1, m]
	}
}
