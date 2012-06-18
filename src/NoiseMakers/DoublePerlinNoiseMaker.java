package NoiseMakers;
public class DoublePerlinNoiseMaker extends CosineInterpolatedNoiseMaker {
	protected double d,scale;
	
	public DoublePerlinNoiseMaker(int seed,int c1,int c2,int c3,int c4,double depth) {
		super(seed,c1,c2,c3,c4);
		d=depth;
		scale=2-1/(1<<(int) d);
	}
	
	@Override
	public double get(double x) {
		int sum=0;
		for (int i=0;i<d;i++)
			sum+=super.get(x*(1<<i))/(1<<i);
		sum+=super.get(x*(1<<(int) d+1))/(1<<(int) d+1)*(d-(int) d);
		return sum/scale;
	}
}
