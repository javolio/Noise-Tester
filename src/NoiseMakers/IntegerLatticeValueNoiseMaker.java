package NoiseMakers;

import java.util.Random;

/**
 * Generates value noise at integer lattice points over a 1D domain. The noise function is undefined at non-integer points.
 * 
 * @author Joseph Avolio
 */
public class IntegerLatticeValueNoiseMaker {
	public final long SEED;
	public static final int RANDRANGE=0x400000;
	private int[] values;
	
	/**
	 * Creates a noise instance with evenly-distributed values between 0 and 1, inclusive
	 * 
	 * @param seed The seed for the random value generation
	 */
	public IntegerLatticeValueNoiseMaker(long seed) {
		SEED=seed;
		
		//Force uniform distribution by having every number in the array
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
	
	/**
	 * Calculates the value of the noise at a lattice point
	 * 
	 * @param x The position
	 * @return The value of the noise at x
	 */
	public double get(int x) {
		return (double) values[x%RANDRANGE]/(RANDRANGE-1); // [0, 1]
	}
}
