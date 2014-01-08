package NoiseMakers;

/**
 * Uses a {@link ContinuousNoiseMaker} and recursively sums compressed copies to generate noise over a continuous 1D domain. Floating-point octave counts are determined for each point by a second noise function.
 * 
 * @author Joseph Avolio 
 */
public class VariableOctaveSpectralSynthesisNoiseMaker implements ContinuousNoiseMaker {
	ContinuousNoiseMaker continuousNoise;
	ContinuousNoiseMaker octaveNoise;
	protected int m;
	protected double scale,stretch;
	
	/**
	 * Creates a noise instance.
	 * 
	 * @param continuousNoise The {@link ContinuousNoiseMaker} for spectral synthesis
	 * @param octaveNoise The {@link ContinuousNoiseMaker} to determine the number of octaves at a point
	 * @param maxOctaves The highest number of octaves possible
	 * @param stretch How much to stretch out the octaveNoise function. A stretch of 1 is no stretch; a stretch of 2 has half the frequency
	 */
	public VariableOctaveSpectralSynthesisNoiseMaker(ContinuousNoiseMaker continuousNoise,ContinuousNoiseMaker octaveNoise,int maxOctaves,double stretch) {
		this.continuousNoise=continuousNoise;
		this.octaveNoise=octaveNoise;
		m=maxOctaves;
		scale=2-1/(1<<m-1);
		this.stretch=stretch;
	}
	
	@Override
	public double get(double x) {
		double sum=0;
		double d=getOctaves(x);
		for (int i=0;i<d;i++)
			sum+=continuousNoise.get(x*(1<<i))/(1<<i);
		sum+=continuousNoise.get(x*(1<<(int) d+1))/(1<<(int) d+1)*(d-(int) d);
		return sum/scale;
	}
	
	/**
	 * Calculate the number of octaves at a point
	 * 
	 * @param x The position
	 * @return The number of octaves at x
	 */
	public double getOctaves(double x) {
		return octaveNoise.get(x/stretch)*(m-1)+1; // [1, m]
	}
}
