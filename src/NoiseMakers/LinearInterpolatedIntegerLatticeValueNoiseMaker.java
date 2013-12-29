package NoiseMakers;

public class LinearInterpolatedIntegerLatticeValueNoiseMaker implements ContinuousNoiseMaker {
	IntegerLatticeValueNoiseMaker latticeNoise;
	
	public LinearInterpolatedIntegerLatticeValueNoiseMaker(IntegerLatticeValueNoiseMaker latticeNoise) {
		this.latticeNoise=latticeNoise;
	}
	
	@Override
	public double get(double x) {
		return (latticeNoise.get((int) x+1)-latticeNoise.get((int) x))*(x-(int) x)+latticeNoise.get((int) x);
	}
	
}
