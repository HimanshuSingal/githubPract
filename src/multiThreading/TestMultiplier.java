package multiThreading;

import org.junit.Assert;
import org.junit.Test;

public class TestMultiplier {
	
	
	
	@Test(expected = IllegalArgumentException.class)
	public void InvalidTests() {
		
			naiveMultiplier mult=new naiveMultiplier(-2);
			threadedMultiplier multThread=new threadedMultiplier(mult);
			int ans1[][]=mult.multiply();
			int ans2[][]=multThread.multiply();
			Assert.assertArrayEquals(ans1,ans2);
				
	}
	
	@Test
	public void NormalTests() {
		
		for(int i=1;i<10;i++)
		{
			naiveMultiplier mult=new naiveMultiplier(i);
			threadedMultiplier multThread=new threadedMultiplier(mult);
			int ans1[][]=mult.multiply();
			int ans2[][]=multThread.multiply();
			Assert.assertArrayEquals(ans1,ans2);
				
		}
	}
	
	@Test
	public void LargeTests() {
		
		for(int i=100;i<1000;i+=100)
		{
			naiveMultiplier mult=new naiveMultiplier(i);
			threadedMultiplier multThread=new threadedMultiplier(mult);
			int ans1[][]=mult.multiply();
			int ans2[][]=multThread.multiply();
			Assert.assertArrayEquals(ans1,ans2);
				
		}
	}
	

}
