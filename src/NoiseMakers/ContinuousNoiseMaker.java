package NoiseMakers;

/**
 * Generates noise over a continuous 1D domain.
 * 
 * @author Joseph Avolio
 */
public interface ContinuousNoiseMaker {
	/**
	 * Calculates the value of the noise at a position
	 * 
	 * @param x The position
	 * @return The value of the noise at x
	 */
	public double get(double x);
}
