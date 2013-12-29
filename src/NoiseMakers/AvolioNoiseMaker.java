package NoiseMakers;

public class AvolioNoiseMaker extends CosineInterpolatedNoiseMaker {
	protected NoiseMaker n;
	protected int m;
	protected double scale,stretch;
	
	//width determines how quickly to change roughness 
	public AvolioNoiseMaker(long seed,int maxDepth,double stretch,NoiseMaker n) {
		super(seed);
		m=maxDepth;
		scale=2-1/(1<<m-1);
		this.n=n;
		this.stretch=stretch;
	}
	
	@Override
	public double get(double x) {
		double sum=0;
		double d=getDepth(x);
		for (int i=0;i<d;i++)
			sum+=super.get(x*(1<<i))/(1<<i);
		sum+=super.get(x*(1<<(int) d+1))/(1<<(int) d+1)*(d-(int) d);
		return sum/scale;
	}
	
	public double getDepth(double x) {
		return n.get(x/stretch)*(m-1)+1;
	}
}
