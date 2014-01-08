package NoiseMakers;

/**
 * Uses an {@link IntegerLatticeValueNoiseMaker} and interpolates it to generate value noise over a continuous 1D domain. Utilizes nearest-neighbor piecewise interpolation, by taking the values for undefined points from the closest defined points.
 * 
 * @author Joseph Avolio
 */
public class NearestNeighborPiecewiseInterpolatedIntegerLatticeValueNoiseMaker implements ContinuousNoiseMaker {
	IntegerLatticeValueNoiseMaker latticeNoise;
	
	/**
	 * Creates a noise instance
	 * 
	 * @param latticeNoise The {@link IntegerLatticeValueNoiseMaker} to be interpolated
	 */
	public NearestNeighborPiecewiseInterpolatedIntegerLatticeValueNoiseMaker(IntegerLatticeValueNoiseMaker latticeNoise) {
		this.latticeNoise=latticeNoise;
	}
	
	@Override
	public double get(double x) {
		return latticeNoise.get((int) (x+.5));
	}
}
