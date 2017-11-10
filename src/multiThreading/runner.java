package multiThreading;

import java.util.Date;

public class runner {
	public static void main(String args[])
	{
		Multiplier m=new naiveMultiplier(1000);
		long t1,t2;
		
		t1=(new Date()).getTime();
		int ans1[][]=m.multiply();
		t2=(new Date()).getTime();
		System.out.println("Naive: "+(t2-t1)+" milliseconds");

		Multiplier m2=new threadedMultiplier(m);
		
		t1=(new Date()).getTime();
		int ans2[][]=m2.multiply();
		t2=(new Date()).getTime();
		System.out.println("Parallel: "+(t2-t1)+" milliseconds");

	}
}
