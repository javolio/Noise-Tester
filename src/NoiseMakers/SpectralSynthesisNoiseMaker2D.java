package NoiseMakers;

public class SpectralSynthesisNoiseMaker2D implements ContinuousNoiseMaker2D {
	ContinuousNoiseMaker2D continuousNoise;
	protected int d;
	protected double scale;
	
	public SpectralSynthesisNoiseMaker2D(ContinuousNoiseMaker2D continuousNoise,int depth) {
		this.continuousNoise=continuousNoise;
		d=depth;
		scale=2-1/(1<<d-1);
	}
	
	@Override
	public double get(double x,double y) {
		double sum=0;
		for (int i=0;i<d;i++)
			sum+=continuousNoise.get(x*(1<<i),y*(1<<i))/(1<<i);
		return sum/scale;
	}
	
}
