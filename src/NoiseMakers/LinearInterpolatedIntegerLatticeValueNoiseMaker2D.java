package NoiseMakers;

public class LinearInterpolatedIntegerLatticeValueNoiseMaker2D implements ContinuousNoiseMaker2D {
	IntegerLatticeValueNoiseMaker2D latticeNoise;
	
	public LinearInterpolatedIntegerLatticeValueNoiseMaker2D(IntegerLatticeValueNoiseMaker2D latticeNoise) {
		this.latticeNoise=latticeNoise;
	}
	
	@Override
	public double get(double x,double y) {
		double left=linearInterpolate(latticeNoise.get((int) x,(int) y),latticeNoise.get((int) x,(int) y+1),y-(int) y);
		double right=linearInterpolate(latticeNoise.get((int) x+1,(int) y),latticeNoise.get((int) x+1,(int) y+1),y-(int) y);
		return linearInterpolate(left,right,x-(int) x);
	}
	
	private double linearInterpolate(double a,double b,double x) {
		return (b-a)*x+a;
	}
	
}
