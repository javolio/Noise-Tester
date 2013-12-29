package NoiseMakers;

import java.util.Random;

public abstract class NoiseMaker {
	public final long SEED;
	public static final int RANDRANGE=0x400000;
	private int[] values;
	
	public NoiseMaker(long seed) {
		SEED=seed;
		
		//Force uniform distribution by having every number
		values=new int[RANDRANGE];
		for (int i=0;i<RANDRANGE;i++)
			values[i]=i;
		
		//Shuffle the array
		Random gen=new Random(seed);
		int t,r;
		for (int i=0;i<RANDRANGE;i++) {
			t=values[i];
			r=gen.nextInt(RANDRANGE);
			values[i]=values[r];
			values[r]=t;
		}
	}
	
	public double get(double x) {
		return (double) values[(int) x%RANDRANGE]/(RANDRANGE-1); // [0, 1)
	}
}
