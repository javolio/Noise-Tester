package NoiseMakers;

/**
 * Generates noise over a continuous 2D domain.
 * 
 * @author Joseph Avolio
 */
public interface ContinuousNoiseMaker2D {
	/**
	 * Calculates the value of the noise at a position
	 * 
	 * @param x The x coordinate of the position
	 * @param y The y coordinate of the position
	 * @return The value of the noise at (x, y)
	 */
	public double get(double x,double y);
}
