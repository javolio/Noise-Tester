package NoiseMakers;

public class SpectralSynthesisNoiseMaker implements ContinuousNoiseMaker {
	ContinuousNoiseMaker continuousNoise;
	protected int d;
	protected double scale;
	
	public SpectralSynthesisNoiseMaker(ContinuousNoiseMaker continuousNoise,int depth) {
		this.continuousNoise=continuousNoise;
		d=depth;
		scale=2-1/(1<<d-1);
	}
	
	@Override
	public double get(double x) {
		double sum=0;
		for (int i=0;i<d;i++)
			sum+=continuousNoise.get(x*(1<<i))/(1<<i);
		return sum/scale;
	}
	
}
