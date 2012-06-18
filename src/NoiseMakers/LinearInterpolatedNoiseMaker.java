package NoiseMakers;

public class LinearInterpolatedNoiseMaker extends NoiseMaker {
	
	public LinearInterpolatedNoiseMaker(int seed,int c1,int c2,int c3,int c4) {
		super(seed,c1,c2,c3,c4);
	}
	
	@Override
	public double get(double x) {
		return values[(int) x]*(1-(int) x+x)+values[(int) x+1]*((int) x-x);
	}
	
}
