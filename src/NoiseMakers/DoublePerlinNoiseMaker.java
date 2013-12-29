package NoiseMakers;

public class DoublePerlinNoiseMaker extends CosineInterpolatedNoiseMaker {
	protected double d,scale;
	
	public DoublePerlinNoiseMaker(long seed,double depth) {
		super(seed);
		d=depth;
		scale=2-1/(1<<(int) d);
	}
	
	@Override
	public double get(double x) {
		double sum=0;
		for (int i=0;i<d;i++)
			sum+=super.get(x*(1<<i))/(1<<i);
		sum+=super.get(x*(1<<(int) d+1))/(1<<(int) d+1)*(d-(int) d);
		return sum/scale;
	}
}
