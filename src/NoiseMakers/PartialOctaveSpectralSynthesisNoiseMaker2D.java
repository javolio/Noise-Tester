package NoiseMakers;

/**
 * Uses a {@link ContinuousNoiseMaker2D} and recursively sums compressed copies to generate noise over a continuous 2D domain. Can handle non-integer octave counts. The partial octave is the frequency of a full octave, with amplitude scaled to its size.
 * 
 * @author Joseph Avolio
 */
public class PartialOctaveSpectralSynthesisNoiseMaker2D implements ContinuousNoiseMaker2D {
	ContinuousNoiseMaker2D continuousNoise;
	protected double d,scale;
	
	/**
	 * Creates a noise instance
	 * 
	 * @param continuousNoise The {@link ContinuousNoiseMaker} for spectral synthesis
	 * @param octaves The number of octaves to layer
	 */
	public PartialOctaveSpectralSynthesisNoiseMaker2D(ContinuousNoiseMaker2D continuousNoise,double depth) {
		this.continuousNoise=continuousNoise;
		d=depth;
		scale=2-1/(1<<(int) d);
	}
	
	@Override
	public double get(double x,double y) {
		double sum=0;
		for (int i=0;i<d;i++)
			sum+=continuousNoise.get(x*(1<<i),y*(1<<i))/(1<<i);
		sum+=continuousNoise.get(x*(1<<(int) d+1),y*(1<<(int) d+1))/(1<<(int) d+1)*(d-(int) d);
		return sum/scale;
	}
	
}
