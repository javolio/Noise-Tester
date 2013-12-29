package NoiseMakers;

public class LinearInterpolatedNoiseMaker extends NoiseMaker {
	
	public LinearInterpolatedNoiseMaker(long seed) {
		super(seed);
	}
	
	@Override
	public double get(double x) {
		return (super.get(x+1)-super.get(x))*(x-(int) x)+super.get(x);
	}
	
}
