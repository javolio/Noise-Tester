package NoiseMakers;
public class AvolioNoiseMaker2D extends CosineInterpolatedNoiseMaker2D {
	protected NoiseMaker2D n;
	protected int m;
	protected double scale;
	
	public AvolioNoiseMaker2D(int seed,int c1,int c2,int c3,int c4,int c5,int c6,int c7,int c8,int maxDepth,NoiseMaker2D n) {
		super(seed,c1,c2,c3,c4,c5,c6,c7,c8);
		m=maxDepth;
		scale=2-1/(1<<m-1);
		this.n=n;
	}
	
	@Override
	public double get(double x,double y) {
		int sum=0;
		double d=n.get(x,y)*(m-1)/4194304+1;
		for (int i=0;i<d;i++)
			sum+=super.get(x*(1<<i),y*(1<<i))/(1<<i);
		sum+=super.get(x*(1<<(int) d+1),y*(1<<(int) d+1))/(1<<(int) d+1)*(d-(int) d);
		return sum/scale;
	}
	
}
