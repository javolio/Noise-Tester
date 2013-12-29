package NoiseMakers;

public class NearestNeighborPiecewiseInterpolatedIntegerLatticeValueNoiseMaker implements ContinuousNoiseMaker {
	IntegerLatticeValueNoiseMaker latticeNoise;
	
	public NearestNeighborPiecewiseInterpolatedIntegerLatticeValueNoiseMaker(IntegerLatticeValueNoiseMaker latticeNoise) {
		this.latticeNoise=latticeNoise;
	}
	
	public double get(double x) {
		return latticeNoise.get((int) (x+.5));
	}
}
