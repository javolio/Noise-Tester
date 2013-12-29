package NoiseMakers;

public class NearestNeighborPiecewiseInterpolatedIntegerLatticeValueNoiseMaker2D implements ContinuousNoiseMaker2D {
	IntegerLatticeValueNoiseMaker2D latticeNoise;
	
	public NearestNeighborPiecewiseInterpolatedIntegerLatticeValueNoiseMaker2D(IntegerLatticeValueNoiseMaker2D latticeNoise) {
		this.latticeNoise=latticeNoise;
	}
	
	public double get(double x,double y) {
		return latticeNoise.get((int) (x+.5),(int) (y+.5));
	}
}
