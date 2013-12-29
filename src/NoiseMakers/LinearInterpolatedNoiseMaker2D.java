package NoiseMakers;

public class LinearInterpolatedNoiseMaker2D extends NoiseMaker2D {
	
	public LinearInterpolatedNoiseMaker2D(long seed) {
		super(seed);
	}
	
	@Override
	public double get(double x,double y) {
		double left=linearInterpolate(super.get((int) x,(int) y),super.get((int) x,(int) y+1),y-(int) y);
		double right=linearInterpolate(super.get((int) x+1,(int) y),super.get((int) x+1,(int) y+1),y-(int) y);
		return linearInterpolate(left,right,x-(int) x);
	}
	
	private double linearInterpolate(double a,double b,double x) {
		return (b-a)*x+a;
	}
	
}
