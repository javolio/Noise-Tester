package NoiseMakers;

public class CosineInterpolatedIntegerLatticeValueNoiseMaker implements ContinuousNoiseMaker {
	IntegerLatticeValueNoiseMaker latticeNoise;
	
	public CosineInterpolatedIntegerLatticeValueNoiseMaker(IntegerLatticeValueNoiseMaker latticeNoise) {
		this.latticeNoise=latticeNoise;
	}
	
	@Override
	public double get(double x) {
		double f=(1-Math.cos((x-(int) x)*Math.PI))*.5;
		return latticeNoise.get((int) x)*(1-f)+latticeNoise.get((int) x+1)*f;
	}
	
}
