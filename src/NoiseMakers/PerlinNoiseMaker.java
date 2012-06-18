package NoiseMakers;
public class PerlinNoiseMaker extends CosineInterpolatedNoiseMaker {
	protected int d;
	protected double scale;
	
	public PerlinNoiseMaker(int seed,int c1,int c2,int c3,int c4,int depth) {
		super(seed,c1,c2,c3,c4);
		d=depth;
		scale=2-1/(1<<d-1);
	}
	
	@Override
	public double get(double x) {
		int sum=0;
		for (int i=0;i<d;i++)
			sum+=super.get(x*(1<<i))/(1<<i);
		return sum/scale;
	}
	
}
