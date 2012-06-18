package NoiseMakers;
public class DoublePerlinNoiseMaker2D extends CosineInterpolatedNoiseMaker2D {
	protected double d,scale;
	
	public DoublePerlinNoiseMaker2D(int seed,int c1,int c2,int c3,int c4,int c5,int c6,int c7,int c8,double depth) {
		super(seed,c1,c2,c3,c4,c5,c6,c7,c8);
		d=depth;
		scale=2-1/(1<<(int) d);
	}
	
	@Override
	public double get(double x,double y) {
		int sum=0;
		for (int i=0;i<d;i++)
			sum+=super.get(x*(1<<i),y*(1<<i))/(1<<i);
		sum+=super.get(x*(1<<(int) d+1),y*(1<<(int) d+1))/(1<<(int) d+1)*(d-(int) d);
		return sum/scale;
	}
	
}
