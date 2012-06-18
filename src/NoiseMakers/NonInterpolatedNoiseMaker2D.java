package NoiseMakers;
public class NonInterpolatedNoiseMaker2D extends NoiseMaker2D {
	
	public NonInterpolatedNoiseMaker2D(int seed,int c1,int c2,int c3,int c4,int c5,int c6,int c7,int c8) {
		super(seed,c1,c2,c3,c4,c5,c6,c7,c8);
	}
	
	@Override
	public double get(double x,double y) {
		return getValue((int) x,(int) y);
	}
	
}
