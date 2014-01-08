package NoiseMakers;

/**
 * Uses an {@link IntegerLatticeValueNoiseMaker2D} and interpolates it to generate value noise over a continuous 2D domain. Utilizes nearest-neighbor piecewise interpolation, by taking the values for undefined points from the closest defined points.
 * 
 * @author Joseph Avolio
 */
public class NearestNeighborPiecewiseInterpolatedIntegerLatticeValueNoiseMaker2D implements ContinuousNoiseMaker2D {
	IntegerLatticeValueNoiseMaker2D latticeNoise;
	
	/**
	 * Creates a noise instance
	 * 
	 * @param latticeNoise The {@link IntegerLatticeValueNoiseMaker2D} to be interpolated
	 */
	public NearestNeighborPiecewiseInterpolatedIntegerLatticeValueNoiseMaker2D(IntegerLatticeValueNoiseMaker2D latticeNoise) {
		this.latticeNoise=latticeNoise;
	}
	
	@Override
	public double get(double x,double y) {
		return latticeNoise.get((int) (x+.5),(int) (y+.5));
	}
}
