package NoiseMakers;
public abstract class NoiseMaker {
	public final int SEED,C1,C2,C3,C4;
	protected int[] values;
	
	public NoiseMaker(int seed,int c1,int c2,int c3,int c4) {
		SEED=seed;
		C1=c1;
		C2=c2;
		C3=c3;
		C4=c4;
		populate();
	}
	
	public abstract double get(double x);
	
	public int rand(int x) {
		return (x*C1+C2)*C3+C4&4194303;
	}
	
	public void populate() {
		values=new int[4194304];
		int cur=SEED;
		for (int i=0;i<4194304;i++)
			values[i]=cur=rand(cur);
	}
}
