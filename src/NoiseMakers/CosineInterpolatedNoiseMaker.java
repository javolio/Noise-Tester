package NoiseMakers;

public class CosineInterpolatedNoiseMaker extends NoiseMaker {
	
	public CosineInterpolatedNoiseMaker(long seed) {
		super(seed);
	}
	
	@Override
	public double get(double x) {
		double f=(1-Math.cos((x-(int) x)*Math.PI))*.5;
		return super.get(x)*(1-f)+super.get(x+1)*f;
	}
	
}
