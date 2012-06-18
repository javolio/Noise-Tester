package NoiseMakers;
public class LinearInterpolatedNoiseMaker2D extends NoiseMaker2D {
	
	public LinearInterpolatedNoiseMaker2D(int seed,int c1,int c2,int c3,int c4,int c5,int c6,int c7,int c8) {
		super(seed,c1,c2,c3,c4,c5,c6,c7,c8);
	}
	
	@Override
	public double get(double x,double y) {
		double left=linearInterpolate(getValue((int) x,(int) y),getValue((int) x,(int) y+1),y-(int) y);
		double right=linearInterpolate(getValue(((int) x+1),(int) y),getValue((int) x+1,(int) y+1),y-(int) y);
		return linearInterpolate(left,right,x-(int) x);
	}
	
	public double linearInterpolate(double a,double b,double x) {
		return a*(1-x)+b*x;
	}
	
}
