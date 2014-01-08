package NoiseMakers;

/**
 * Uses an {@link IntegerLatticeValueNoiseMaker2D} and interpolates it to generate value noise over a continuous 2D domain. Utilizes cosine interpolation, by taking a segment of cos(x) from domain 0 to pi and range 1 to -1 and positioning that curve between every pair of lattice points.
 * 
 * @author Joseph Avolio
 */
public class CosineInterpolatedIntegerLatticeValueNoiseMaker2D implements ContinuousNoiseMaker2D {
	IntegerLatticeValueNoiseMaker2D latticeNoise;
	
	/**
	 * Creates a noise instance
	 * 
	 * @param latticeNoise The {@link IntegerLatticeValueNoiseMaker2D} to be interpolated
	 */
	public CosineInterpolatedIntegerLatticeValueNoiseMaker2D(IntegerLatticeValueNoiseMaker2D latticeNoise) {
		this.latticeNoise=latticeNoise;
	}
	
	@Override
	public double get(double x,double y) {
		double left=cosineInterpolate(latticeNoise.get((int) x,(int) y),latticeNoise.get((int) x,(int) y+1),y-(int) y);
		double right=cosineInterpolate(latticeNoise.get((int) x+1,(int) y),latticeNoise.get((int) x+1,(int) y+1),y-(int) y);
		return cosineInterpolate(left,right,x-(int) x);
	}
	
	/**
	 * Calculated the value at a position along a cosine curve between two points 
	 * 
	 * @param a The value at the first point
	 * @param b The value at the second point
	 * @param x The position between the points
	 * @return The value at x along a cosine curve between a and b
	 */
	private double cosineInterpolate(double a,double b,double x) {
		double f=(1-Math.cos(x*Math.PI))*.5;
		return a*(1-f)+b*f;
	}
	
}
