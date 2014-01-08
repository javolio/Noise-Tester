package NoiseMakers;

/**
 * Uses an {@link IntegerLatticeValueNoiseMaker2D} and interpolates it to generate value noise over a continuous 2D domain. Utilizes linear interpolation, by taking the value for undefined points from the line that passes between the two nearest points.
 * 
 * @author Joseph Avolio
 */
public class LinearInterpolatedIntegerLatticeValueNoiseMaker2D implements ContinuousNoiseMaker2D {
	IntegerLatticeValueNoiseMaker2D latticeNoise;
	
	/**
	 * Creates a noise instance
	 * 
	 * @param latticeNoise The {@link IntegerLatticeValueNoiseMaker2D} to be interpolated
	 */
	public LinearInterpolatedIntegerLatticeValueNoiseMaker2D(IntegerLatticeValueNoiseMaker2D latticeNoise) {
		this.latticeNoise=latticeNoise;
	}
	
	@Override
	public double get(double x,double y) {
		double left=linearInterpolate(latticeNoise.get((int) x,(int) y),latticeNoise.get((int) x,(int) y+1),y-(int) y);
		double right=linearInterpolate(latticeNoise.get((int) x+1,(int) y),latticeNoise.get((int) x+1,(int) y+1),y-(int) y);
		return linearInterpolate(left,right,x-(int) x);
	}
	
	/**
	 * Calculated the value at a position along a line segment between two points 
	 * 
	 * @param a The value at the first point
	 * @param b The value at the second point
	 * @param x The position between the points
	 * @return The value at x along a line segment between a and b
	 */
	private double linearInterpolate(double a,double b,double x) {
		return (b-a)*x+a;
	}
	
}
