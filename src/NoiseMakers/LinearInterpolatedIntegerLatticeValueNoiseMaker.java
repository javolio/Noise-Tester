package NoiseMakers;

/**
 * Uses an {@link IntegerLatticeValueNoiseMaker} and interpolates it to generate value noise over a continuous 1D domain. Utilizes linear interpolation, by taking the value for undefined points from the line that passes between the two nearest points.
 * 
 * @author Joseph Avolio
 */
public class LinearInterpolatedIntegerLatticeValueNoiseMaker implements ContinuousNoiseMaker {
	IntegerLatticeValueNoiseMaker latticeNoise;
	
	/**
	 * Creates a noise instance
	 * 
	 * @param latticeNoise The {@link IntegerLatticeValueNoiseMaker} to be interpolated
	 */
	public LinearInterpolatedIntegerLatticeValueNoiseMaker(IntegerLatticeValueNoiseMaker latticeNoise) {
		this.latticeNoise=latticeNoise;
	}
	
	@Override
	public double get(double x) {
		return (latticeNoise.get((int) x+1)-latticeNoise.get((int) x))*(x-(int) x)+latticeNoise.get((int) x);
	}
	
}
