package NoiseMakers;

public class PiecewiseInterpolatedIntegerLatticeValueNoiseMaker2D implements ContinuousNoiseMaker2D {
	IntegerLatticeValueNoiseMaker2D latticeNoise;
	
	public PiecewiseInterpolatedIntegerLatticeValueNoiseMaker2D(IntegerLatticeValueNoiseMaker2D latticeNoise) {
		this.latticeNoise=latticeNoise;
	}
	
	public double get(double x,double y) {
		return latticeNoise.get((int) x,(int) y);
	}
}
