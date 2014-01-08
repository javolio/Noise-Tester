package NoiseMakers;

/**
 * Uses an {@link IntegerLatticeValueNoiseMaker2D} and interpolates it to generate value noise over a continuous 2D domain. Utilizes floored piecewise interpolation, by taking the values for undefined points from the greatest point less than the undefined point.
 * 
 * @author Joseph Avolio
 */
public class PiecewiseInterpolatedIntegerLatticeValueNoiseMaker2D implements ContinuousNoiseMaker2D {
	IntegerLatticeValueNoiseMaker2D latticeNoise;
	
	/**
	 * Creates a noise instance
	 * 
	 * @param latticeNoise The {@link IntegerLatticeValueNoiseMaker2D} to be interpolated
	 */
	public PiecewiseInterpolatedIntegerLatticeValueNoiseMaker2D(IntegerLatticeValueNoiseMaker2D latticeNoise) {
		this.latticeNoise=latticeNoise;
	}
	
	@Override
	public double get(double x,double y) {
		return latticeNoise.get((int) x,(int) y);
	}
}
