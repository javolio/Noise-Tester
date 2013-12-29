package NoiseMakers;

public class VariableOctaveSpectralSynthesisNoiseMaker implements ContinuousNoiseMaker {
	ContinuousNoiseMaker continuousNoise;
	ContinuousNoiseMaker octaveNoise;
	protected int m;
	protected double scale,stretch;
	
	//stretch determines how quickly to change roughness
	public VariableOctaveSpectralSynthesisNoiseMaker(ContinuousNoiseMaker continuousNoise,ContinuousNoiseMaker octaveNoise,int maxDepth,double stretch) {
		this.continuousNoise=continuousNoise;
		this.octaveNoise=octaveNoise;
		m=maxDepth;
		scale=2-1/(1<<m-1);
		this.stretch=stretch;
	}
	
	@Override
	public double get(double x) {
		double sum=0;
		double d=getDepth(x);
		for (int i=0;i<d;i++)
			sum+=continuousNoise.get(x*(1<<i))/(1<<i);
		sum+=continuousNoise.get(x*(1<<(int) d+1))/(1<<(int) d+1)*(d-(int) d);
		return sum/scale;
	}
	
	public double getDepth(double x) {
		return octaveNoise.get(x/stretch)*(m-1)+1;
	}
}
