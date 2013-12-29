package NoiseMakers;

public class PerlinNoiseMaker extends CosineInterpolatedNoiseMaker {
	protected int d;
	protected double scale;
	
	public PerlinNoiseMaker(long seed,int depth) {
		super(seed);
		d=depth;
		scale=2-1/(1<<d-1);
	}
	
	@Override
	public double get(double x) {
		double sum=0;
		for (int i=0;i<d;i++)
			sum+=super.get(x*(1<<i))/(1<<i);
		return sum/scale;
	}
	
}
