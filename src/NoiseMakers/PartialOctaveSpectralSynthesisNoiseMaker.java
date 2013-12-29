package NoiseMakers;

public class PartialOctaveSpectralSynthesisNoiseMaker implements ContinuousNoiseMaker {
	ContinuousNoiseMaker continuousNoise;
	protected double d,scale;
	
	public PartialOctaveSpectralSynthesisNoiseMaker(ContinuousNoiseMaker continuousNoise,double depth) {
		this.continuousNoise=continuousNoise;
		d=depth;
		scale=2-1/(1<<(int) d);
	}
	
	@Override
	public double get(double x) {
		double sum=0;
		for (int i=0;i<d;i++)
			sum+=continuousNoise.get(x*(1<<i))/(1<<i);
		sum+=continuousNoise.get(x*(1<<(int) d+1))/(1<<(int) d+1)*(d-(int) d);
		return sum/scale;
	}
}
