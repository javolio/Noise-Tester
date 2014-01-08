package NoiseMakers;

/**
 * Uses an {@link IntegerLatticeValueNoiseMaker} and interpolates it to generate value noise over a continuous 1D domain. Utilizes cosine interpolation, by taking a segment of cos(x) from domain 0 to pi and range 1 to -1 and positioning that curve between every pair of lattice points.
 * 
 * @author Joseph Avolio  
 */
public class CosineInterpolatedIntegerLatticeValueNoiseMaker implements ContinuousNoiseMaker {
	IntegerLatticeValueNoiseMaker latticeNoise;
	
	/**
	 * Creates a noise instance
	 * 
	 * @param latticeNoise The {@link IntegerLatticeValueNoiseMaker} to be interpolated
	 */
	public CosineInterpolatedIntegerLatticeValueNoiseMaker(IntegerLatticeValueNoiseMaker latticeNoise) {
		this.latticeNoise=latticeNoise;
	}
	
	@Override
	public double get(double x) {
		double f=(1-Math.cos((x-(int) x)*Math.PI))*.5;
		return latticeNoise.get((int) x)*(1-f)+latticeNoise.get((int) x+1)*f;
	}
	
}
