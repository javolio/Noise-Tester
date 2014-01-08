package NoiseMakers;

/**
 * Uses a {@link ContinuousNoiseMaker} and recursively sums compressed copies to generate noise over a continuous 1D domain. Can handle non-integer octave counts. The partial octave is the frequency of a full octave, with amplitude scaled to its size.
 * 
 * @author Joseph Avolio
 */
public class PartialOctaveSpectralSynthesisNoiseMaker implements ContinuousNoiseMaker {
	ContinuousNoiseMaker continuousNoise;
	protected double o,scale;
	
	/**
	 * Creates a noise instance.
	 * 
	 * @param continuousNoise The {@link ContinuousNoiseMaker} for spectral synthesis
	 * @param octaves The number of octaves to layer
	 */
	public PartialOctaveSpectralSynthesisNoiseMaker(ContinuousNoiseMaker continuousNoise,double octaves) {
		this.continuousNoise=continuousNoise;
		o=octaves;
		scale=2-1/(1<<(int) o);
	}
	
	@Override
	public double get(double x) {
		double sum=0;
		for (int i=0;i<o;i++)
			sum+=continuousNoise.get(x*(1<<i))/(1<<i);
		sum+=continuousNoise.get(x*(1<<(int) o+1))/(1<<(int) o+1)*(o-(int) o);
		return sum/scale;
	}
}
