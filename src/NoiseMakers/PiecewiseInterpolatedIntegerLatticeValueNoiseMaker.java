package NoiseMakers;

public class PiecewiseInterpolatedIntegerLatticeValueNoiseMaker implements ContinuousNoiseMaker {
	IntegerLatticeValueNoiseMaker latticeNoise;
	
	public PiecewiseInterpolatedIntegerLatticeValueNoiseMaker(IntegerLatticeValueNoiseMaker latticeNoise) {
		this.latticeNoise=latticeNoise;
	}
	
	public double get(double x) {
		return latticeNoise.get((int) x);
	}
}
