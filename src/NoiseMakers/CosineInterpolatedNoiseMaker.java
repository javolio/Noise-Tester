package NoiseMakers;
public class CosineInterpolatedNoiseMaker extends NoiseMaker {
	
	public CosineInterpolatedNoiseMaker(int seed,int c1,int c2,int c3,int c4) {
		super(seed,c1,c2,c3,c4);
	}
	
	@Override
	public double get(double x) {
		double f=(1-Math.cos((x-(int) x)*Math.PI))*.5;
		return values[(int) x%values.length]*(1-f)+values[((int) x+1)%values.length]*f;
	}
	
}
