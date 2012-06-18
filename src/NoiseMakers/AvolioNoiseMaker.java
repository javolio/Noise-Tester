package NoiseMakers;
public class AvolioNoiseMaker extends CosineInterpolatedNoiseMaker {
	protected NoiseMaker n;
	protected int m;
	protected double scale;
	
	public AvolioNoiseMaker(int seed,int c1,int c2,int c3,int c4,int maxDepth,NoiseMaker n) {
		super(seed,c1,c2,c3,c4);
		m=maxDepth;
		scale=2-1/(1<<m-1);
		this.n=n;
	}
	
	@Override
	public double get(double x) {
		int sum=0;
		double d=n.get(x)*(m-1)/4194304+1;
		for (int i=0;i<d;i++)
			sum+=super.get(x*(1<<i))/(1<<i);
		sum+=super.get(x*(1<<(int) d+1))/(1<<(int) d+1)*(d-(int) d);
		return sum/scale;
	}
}
