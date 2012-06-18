package NoiseMakers;
public abstract class NoiseMaker2D {
	public final int SEED,C1,C2,C3,C4,C5,C6,C7,C8;
	protected int[] values;
	
	public NoiseMaker2D(int seed,int c1,int c2,int c3,int c4,int c5,int c6,int c7,int c8) {
		SEED=seed;
		C1=c1;
		C2=c2;
		C3=c3;
		C4=c4;
		C5=c5;
		C6=c6;
		C7=c7;
		C8=c8;
		populate();
	}
	
	public abstract double get(double x,double y);
	
	public int rand1(int x) {
		return (x*C1+C2)*C3+C4&4194303;
	}
	
	public int rand2(int y) {
		return (y*C5+C6)*C7+C8&4194303;
	}
	
	public void populate() {
		values=new int[4194304];
		int cur=SEED;
		for (int i=0;i<4194304;i++) {
			values[i]=cur=rand1(cur);
		}
	}
	
	public int getValue(int x,int y) {
		int cur=values[x];
		for (int i=0;i<y;i++)
			cur=rand2(cur);
		return cur;
	}
}
