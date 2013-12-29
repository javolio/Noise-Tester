package NoiseMakers;

public class DoublePerlinNoiseMaker2D extends CosineInterpolatedNoiseMaker2D {
	protected double d,scale;
	
	public DoublePerlinNoiseMaker2D(long seed,double depth) {
		super(seed);
		d=depth;
		scale=2-1/(1<<(int) d);
	}
	
	@Override
	public double get(double x,double y) {
		double sum=0;
		for (int i=0;i<d;i++)
			sum+=super.get(x*(1<<i),y*(1<<i))/(1<<i);
		sum+=super.get(x*(1<<(int) d+1),y*(1<<(int) d+1))/(1<<(int) d+1)*(d-(int) d);
		return sum/scale;
	}
	
}
