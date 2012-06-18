package NoiseMakers;
public class PerlinNoiseMaker2D extends CosineInterpolatedNoiseMaker2D {
	protected int d;
	protected double scale;
	
	public PerlinNoiseMaker2D(int seed,int c1,int c2,int c3,int c4,int c5,int c6,int c7,int c8,int depth) {
		super(seed,c1,c2,c3,c4,c5,c6,c7,c8);
		d=depth;
		scale=2-1/(1<<d-1);
	}
	
	@Override
	public double get(double x,double y) {
		int sum=0;
		for (int i=0;i<d;i++)
			sum+=super.get(x*(1<<i),y*(1<<i))/(1<<i);
		return sum/scale;
	}
	
}
