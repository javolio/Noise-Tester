package NoiseMakers;

/**
 * Uses an {@link IntegerLatticeValueNoiseMaker} and interpolates it to generate value noise over a continuous 1D domain. Utilizes floored piecewise interpolation, by taking the values for undefined points from the greatest point less than the undefined point.
 * 
 * @author Joseph Avolio
 */
public class PiecewiseInterpolatedIntegerLatticeValueNoiseMaker implements ContinuousNoiseMaker {
	IntegerLatticeValueNoiseMaker latticeNoise;
	
	/**
	 * Creates a noise instance
	 * 
	 * @param latticeNoise The {@link IntegerLatticeValueNoiseMaker} to be interpolated
	 */
	public PiecewiseInterpolatedIntegerLatticeValueNoiseMaker(IntegerLatticeValueNoiseMaker latticeNoise) {
		this.latticeNoise=latticeNoise;
	}
	
	@Override
	public double get(double x) {
		return latticeNoise.get((int) x);
	}
}
